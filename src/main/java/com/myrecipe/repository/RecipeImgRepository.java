package com.myrecipe.repository;

import com.myrecipe.entity.RecipeImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeImgRepository extends JpaRepository<RecipeImg, Long> {

    // 상품 이미지 아이디 오름차순 정렬
    List<RecipeImg> findByRecipeIdOrderByIdAsc(Long recipeId);

}
