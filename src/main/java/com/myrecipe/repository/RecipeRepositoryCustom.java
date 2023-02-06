package com.myrecipe.repository;

import com.myrecipe.dto.MainItemDto;
import com.myrecipe.dto.RecipeSearchDto;
import com.myrecipe.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecipeRepositoryCustom {

    /**
     * itemSearchDto : 상품 조회 조건 객체
     * pageable : 페이징 정보 담고있는 객체
     * */
    Page<Recipe> getAdminRecipePage(RecipeSearchDto recipeSearchDto, Pageable pageable);

    // 반환 타입 : Page<MainItemDTO>
    Page<MainItemDto> getMainRecipePage(RecipeSearchDto recipeSearchDto, Pageable pageable);

}

