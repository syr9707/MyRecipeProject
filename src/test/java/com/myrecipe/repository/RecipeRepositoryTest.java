package com.myrecipe.repository;

import com.myrecipe.constant.RecipeLevel;
import com.myrecipe.entity.QRecipe;
import com.myrecipe.entity.Recipe;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static com.myrecipe.entity.QRecipe.recipe;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class RecipeRepositoryTest {

    @Autowired
    RecipeRepository recipeRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("레시피 저장 테스트")
    public void createRecipeTest() {
        Recipe recipe = new Recipe();
        recipe.setRecipeName("테스트 레시피");
        recipe.setPrice(30000);
        recipe.setRecipeDetail("테스트 레시피 상세 설명");
        recipe.setRecipeLevel(RecipeLevel.EASY);
        recipe.setRecommendation(0);
        recipe.setRegTime(LocalDateTime.now());
        recipe.setUpdateTime(LocalDateTime.now());
        Recipe savedRecipe = recipeRepository.save(recipe);
        System.out.println(savedRecipe.toString());
    }

    public void createRecipeList() {
        for(int i = 1; i <= 10; i++) {
            Recipe recipe = new Recipe();
            recipe.setRecipeName("테스트 레시피" + i);
            recipe.setPrice(30000 + i);
            recipe.setRecipeDetail("테스트 레시피 상세 설명" + i);
            recipe.setRecipeLevel(RecipeLevel.EASY);
            recipe.setRecommendation(0);
            recipe.setRegTime(LocalDateTime.now());
            recipe.setUpdateTime(LocalDateTime.now());
            Recipe savedRecipe = recipeRepository.save(recipe);
        }
    }

    @Test
    @DisplayName("레시피명 조회 테스트")
    public void findByRecipeNameTest() {
        this.createRecipeList();
        List<Recipe> recipeList = recipeRepository.findByRecipeName("테스트 레시피1");
        for(Recipe recipe : recipeList) {
            System.out.println(recipe.toString());
        }
    }

    @Test
    @DisplayName("레시피명, 레시피상세설명 or 테스트")
    public void findByRecipeOrRecipeDetailTest() {
        this.createRecipeList();
        List<Recipe> recipeList = recipeRepository.findByRecipeNameOrRecipeDetail("테스트 레시피1", "테스트 레시피 상세 설명5");
        for(Recipe recipe : recipeList) {
            System.out.println(recipe.toString());
        }
    }

    @Test
    @DisplayName("가격 LessThan 테스트")
    public void findByPriceLessThanTest() {
        this.createRecipeList();
        List<Recipe> recipeList = recipeRepository.findByPriceLessThan(30005);
        for (Recipe recipe : recipeList) {
            System.out.println(recipe.toString());
        }
    }

    @Test
    @DisplayName("가격 내림차순 조회 테스트")
    public void findByPriceLessThanOrderByPriceDescTest() {
        this.createRecipeList();
        List<Recipe> recipeList = recipeRepository.findByPriceLessThanOrderByPriceDesc(30005);
        for (Recipe recipe : recipeList) {
            System.out.println(recipe.toString());
        }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByRecipeDetailTest() {
        this.createRecipeList();
        List<Recipe> recipeList = recipeRepository.findByRecipeDetail("테스트 레시피 상세 설명");
        for (Recipe recipe : recipeList) {
            System.out.println(recipe.toString());
        }
    }

    @Test
    @DisplayName("Querydsl 조회 테스트1")
    public void queryDslTest() {
        this.createRecipeList();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QRecipe qRecipe = recipe;
        JPAQuery<Recipe> query = queryFactory.selectFrom(qRecipe)
                .where(qRecipe.recipeLevel.eq(RecipeLevel.EASY))
                .where(qRecipe.recipeDetail.like("%" + "테스트 레시피 상세 설명" + "%"))
                .orderBy(qRecipe.price.desc());

        List<Recipe> recipeList = query.fetch();

        for (Recipe recipe : recipeList) {
            System.out.println(recipe.toString());
        }
    }

    public void createRecipeList2() {
        for(int i = 1; i <= 5; i++) {
            Recipe recipe = new Recipe();
            recipe.setRecipeName("테스트 레시피" + i);
            recipe.setPrice(30000 + i);
            recipe.setRecipeDetail("테스트 레시피 상세 설명" + i);
            recipe.setRecipeLevel(RecipeLevel.EASY);
            recipe.setRecommendation(0);
            recipe.setRegTime(LocalDateTime.now());
            recipe.setUpdateTime(LocalDateTime.now());
            Recipe savedRecipe = recipeRepository.save(recipe);
        }

        for(int i = 6; i <= 10; i++) {
            Recipe recipe = new Recipe();
            recipe.setRecipeName("테스트 레시피" + i);
            recipe.setPrice(30000 + i);
            recipe.setRecipeDetail("테스트 레시피 상세 설명" + i);
            recipe.setRecipeLevel(RecipeLevel.HARD);
            recipe.setRecommendation(0);
            recipe.setRegTime(LocalDateTime.now());
            recipe.setUpdateTime(LocalDateTime.now());
            Recipe savedRecipe = recipeRepository.save(recipe);
        }
    }

    @Test
    @DisplayName("상품 Querydsl 조회 테스트 2")
    public void queryDslTest2(){

        this.createRecipeList();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QRecipe recipe = QRecipe.recipe;
        String recipeDetail = "테스트 레시피 상세 설명";
        int price = 30003;
        String recipeLevelStat = "EASY";

        booleanBuilder.and(recipe.recipeDetail.like("%" + recipeDetail + "%"));
        booleanBuilder.and(recipe.price.gt(price));

        if(StringUtils.equals(recipeLevelStat, RecipeLevel.EASY)){
            booleanBuilder.and(recipe.recipeLevel.eq(RecipeLevel.EASY.EASY));
        }

        Pageable pageable = PageRequest.of(0, 5);
        Page<Recipe> recipePagingResult = recipeRepository.findAll(booleanBuilder, pageable);
        System.out.println("total elements : " + recipePagingResult. getTotalElements ());

        List<Recipe> resultRecipeList = recipePagingResult.getContent();
        for(Recipe resultRecipe: resultRecipeList){
            System.out.println(resultRecipe.toString());
        }
    }

}