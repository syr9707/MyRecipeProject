package com.myrecipe.repository;

import com.myrecipe.dto.CartDetailDto;
import com.myrecipe.entity.CartRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRecipeRepository extends JpaRepository<CartRecipe, Long> {

    CartRecipe findByCartIdAndRecipeId(Long cartId, Long recipeId);

    @Query("select new com.myrecipe.dto.CartDetailDto(cr.id, r.recipeName, r.price, rm.imgUrl) " +
            "from CartRecipe cr, RecipeImg rm " +
            "join cr.recipe r " +
            "where cr.cart.id = :cartId " +
            "and rm.recipe.id = cr.recipe.id " +
            "and rm.repimgYn = 'Y' " +
            "order by cr.regTime desc")

    List<CartDetailDto> findCartDetailDtoList(Long cartId);

}
