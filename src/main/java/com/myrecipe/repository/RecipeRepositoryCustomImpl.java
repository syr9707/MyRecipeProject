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
                        searchLevelEq(recipeSearchDto.getSearchLevel()),
                        searchByLike(recipeSearchDto.getSearchBy(), recipeSearchDto.getSearchQuery()))
                .orderBy(QRecipe.recipe.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.select(Wildcard.count).from(QRecipe.recipe)
                .where(regDtsAfter(recipeSearchDto.getSearchDateType()),
                        searchLevelEq(recipeSearchDto.getSearchLevel()),
                        searchByLike(recipeSearchDto.getSearchBy(), recipeSearchDto.getSearchQuery()))
                .fetchOne()
                ;

        return new PageImpl<>(content, pageable, total);
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 검색어가 null이 아니면, 게시물명에 해당 검색어가 포함되는 게시물을 조회하는 조건 반환
     *
     * BooleanExpression ; null 반환 시 자동으로 조건절에서 제거됨
     * 단, 모든 조건이 null인 경우 장애 발생
     * */
    private BooleanExpression recipeNameLike(String searchQuery) {
        return StringUtils.isEmpty(searchQuery) ? null : QRecipe.recipe.recipeName.like("%" + searchQuery + "%");
    }

    @Override
    public Page<MainItemDto> getMainRecipePage(RecipeSearchDto recipeSearchDto, Pageable pageable) {
        QRecipe recipe = QRecipe.recipe; // Querydsl을 통해 쿼리를 생성하기 위해, 플러그인을 통해 자동으로 생성된 QRecipe 객체를 이용함.
        QRecipeImg recipeImg = QRecipeImg.recipeImg;

        List<MainItemDto> content = queryFactory
                .select(
                        new QMainItemDto( // QMainItemDto의 생성자에 반환할 값 넣어줌. @QueryProjection 덕분에 엔티티 조회 후 DTO 변환 과정 없이 DTO로 바로 조회 가능.
                                recipe.id,
                                recipe.recipeName,
                                recipe.recipeDetail,
                                recipeImg.imgUrl,
                                recipe.price,
                                recipe.view)
                )
                .from(recipeImg)
                .join(recipeImg.recipe, recipe) // RecipeImg와 Recipe를 내부 조인
                .where(recipeImg.repimgYn.eq("Y")) // 대표 이미지만 가져옴
                .where(recipeNameLike(recipeSearchDto.getSearchQuery()))
                .orderBy(recipe.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch(); // JPAQuery 메소드 중 하나인 fetch를 이용해서 쿼리 결과를 리스트로 반환한다. fetch() 메소드 실행 시점에 쿼리문이 실행된다.

        long total = queryFactory
                .select(Wildcard.count) // select count(*)
                .from(recipeImg)
                .join(recipeImg.recipe, recipe)
                .where(recipeImg.repimgYn.eq("Y"))
                .where(recipeNameLike(recipeSearchDto.getSearchQuery()))
                .fetchOne()
                ;

        // Page<User> page = new PageImpl<>(users.subList(start, end), pageable, users.size());
        // content의 타입을 바꿔준 list, pageable, 총 데이터 개수
        return new PageImpl<>(content, pageable, total);
    }
}
