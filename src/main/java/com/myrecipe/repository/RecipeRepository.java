package com.myrecipe.repository;

import com.myrecipe.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long>, QuerydslPredicateExecutor<Recipe>, RecipeRepositoryCustom {

    // 레시피명으로 데이터 조회
    List<Recipe> findByRecipeName(String recipeName);

    // 레시피명과 레시피 상세 설명을 OR 조건을 이용하여 조회
    List<Recipe> findByRecipeNameOrRecipeDetail(String recipeName, String recipeDetail);

    // 파라미터로 넘어온 price 변수보다 값이 작은 레시피 데이터를 조회
    List<Recipe> findByPriceLessThan(Integer price);

    // 레시피 가격 높은 순 조회
    List<Recipe> findByPriceLessThanOrderByPriceDesc(Integer price);

    /**
     * 레시피 상세 설명을 파라미터로 받아 해당 내용을 레시피 상세 설명에 포함하고 있는 데이터 조회.
     * 정렬 순서 : 가격 높은 순
     * */
    @Query("select r from Recipe r where r.recipeDetail like %:recipeDetail% order by r.price desc")
    List<Recipe> findByRecipeDetail(@Param("recipeDetail") String recipeDetail);

}
