package com.myrecipe.repository;

import com.myrecipe.constant.RecipeLevel;
import com.myrecipe.dto.MainItemDto;
import com.myrecipe.dto.QMainItemDto;
import com.myrecipe.dto.RecipeSearchDto;
import com.myrecipe.entity.QRecipe;
import com.myrecipe.entity.QRecipeImg;
import com.myrecipe.entity.Recipe;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class RecipeRepositoryCustomImpl implements RecipeRepositoryCustom{

    private JPAQueryFactory queryFactory; // 동적 쿼리 생성

    public RecipeRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression searchLevelEq(RecipeLevel searchLevel) {
        return searchLevel == null ? null : QRecipe.recipe.recipeLevel.eq(searchLevel);
    }

    private BooleanExpression regDtsAfter(String searchDateType){

        LocalDateTime dateTime = LocalDateTime.now();

        if(StringUtils.equals("all", searchDateType) || searchDateType == null){
            return null;
        } else if(StringUtils.equals("1d", searchDateType)){
            dateTime = dateTime.minusDays(1);
        } else if(StringUtils.equals("1w", searchDateType)){
            dateTime = dateTime.minusWeeks(1);
        } else if(StringUtils.equals("1m", searchDateType)){
            dateTime = dateTime.minusMonths(1);
        } else if(StringUtils.equals("6m", searchDateType)){
            dateTime = dateTime.minusMonths(6);
        }

        return QRecipe.recipe.regTime.after(dateTime);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery) {
        if(StringUtils.equals("recipeName", searchBy)) {
            return QRecipe.recipe.recipeName.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("createdBy", searchBy)) {
            return QRecipe.recipe.createdBy.like("%" + searchQuery + "%");
        }

        return null;
    }

    @Override
    public Page<Recipe> getAdminRecipePage(RecipeSearchDto recipeSearchDto, Pageable pageable) {
        List<Recipe> content = queryFactory
                .selectFrom(QRecipe.recipe)
                .where(regDtsAfter(recipeSearchDto.getSearchDateType()),
                        searchLevelEq(recipeSearchDto.getSearchRecipeLevel()),
                        searchByLike(recipeSearchDto.getSearchBy(), recipeSearchDto.getSearchQuery()))
                .orderBy(QRecipe.recipe.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.select(Wildcard.count).from(QRecipe.recipe)
                .where(regDtsAfter(recipeSearchDto.getSearchDateType()),
                        searchLevelEq(recipeSearchDto.getSearchRecipeLevel()),
                        searchByLike(recipeSearchDto.getSearchBy(), recipeSearchDto.getSearchQuery()))
                .fetchOne()
                ;

        return new PageImpl<>(content, pageable, total);
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////

    private BooleanExpression recipeNameLike(String searchQuery) {
        return StringUtils.isEmpty(searchQuery) ? null : QRecipe.recipe.recipeName.like("%" + searchQuery + "%");
    }

    @Override
    public Page<MainItemDto> getMainRecipePage(RecipeSearchDto recipeSearchDto, Pageable pageable) {
        QRecipe recipe = QRecipe.recipe;
        QRecipeImg recipeImg = QRecipeImg.recipeImg;

        List<MainItemDto> content = queryFactory
                .select(
                        new QMainItemDto(
                                recipe.id,
                                recipe.recipeName,
                                recipe.recipeDetail,
                                recipeImg.imgUrl,
                                recipe.price)
                )
                .from(recipeImg)
                .join(recipeImg.recipe, recipe)
                .where(recipeImg.repimgYn.eq("Y"))
                .where(recipeNameLike(recipeSearchDto.getSearchQuery()))
                .orderBy(recipe.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(Wildcard.count)
                .from(recipeImg)
                .join(recipeImg.recipe, recipe)
                .where(recipeImg.repimgYn.eq("Y"))
                .where(recipeNameLike(recipeSearchDto.getSearchQuery()))
                .fetchOne()
                ;

        return new PageImpl<>(content, pageable, total);
    }
}
