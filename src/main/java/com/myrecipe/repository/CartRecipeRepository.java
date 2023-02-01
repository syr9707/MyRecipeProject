package com.myrecipe.repository;

import com.myrecipe.dto.CartDetailDto;
import com.myrecipe.entity.CartRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRecipeRepository extends JpaRepository<CartRecipe, Long> {

    CartRecipe findByCartIdAndRecipeId(Long cartId, Long recipeId);

    /**
     * <JPA에서 DTO로 바로 조회>
     *      * 마이페이지에 전달할 CartDeatilDto List를 쿼리 하나로 조회하는 JPQL.
     *      * new 명령어를 사용해서 JPQL의 결과를 DTO로 즉시 변환.
     *      * SELECT 절에서 원하는 데이터를 직접 선택하므로 DB -> 애플리케이션 네트웍 용량 최적화
     * JPQL 쿼리 실행 시 플러시 자동 호출
     * 성능 최적화를 위해 DTO 생성자를 이용하여 DTO 객체 반환.
     * */
    @Query("select new com.myrecipe.dto.CartDetailDto(cr.id, r.recipeName, r.price, rm.imgUrl) " +
            "from CartRecipe cr, RecipeImg rm " +
            "join cr.recipe r " +
            "where cr.cart.id = :cartId " +
            "and rm.recipe.id = cr.recipe.id " +
            "and rm.repimgYn = 'Y' " +
            "order by cr.regTime desc")
    List<CartDetailDto> findCartDetailDtoList(Long cartId);

//    CartRecipe findByCartIdAndRecipeIdAndMemberId(Long cartId, Long recipeId, Long memberId);

}
