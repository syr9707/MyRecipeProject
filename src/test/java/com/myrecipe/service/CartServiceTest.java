package com.myrecipe.service;

import com.myrecipe.constant.RecipeLevel;
import com.myrecipe.dto.CartRecipeDto;
import com.myrecipe.entity.Cart;
import com.myrecipe.entity.CartRecipe;
import com.myrecipe.entity.Member;
import com.myrecipe.entity.Recipe;
import com.myrecipe.repository.CartRecipeRepository;
import com.myrecipe.repository.MemberRepository;
import com.myrecipe.repository.RecipeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
class CartServiceTest {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CartService cartService;

    @Autowired
    CartRecipeRepository cartRecipeRepository;

    public Recipe saveRecipe() {
        Recipe recipe = new Recipe();
        recipe.setRecipeName("테스트 레시피");
        recipe.setPrice(30000);
        recipe.setRecipeDetail("테스트 레시피 상세 설명");
        recipe.setRecipeLevel(RecipeLevel.EASY);
        return recipeRepository.save(recipe);
    }

    public Member saveMember(){
        Member member = new Member();
        member.setEmail("test@test.com");
        return memberRepository.save(member);
    }

    @Test
    @DisplayName("장바구니 담기 테스트")
    public void addCart(){
        Recipe recipe = saveRecipe();
        Member member = saveMember();

        CartRecipeDto cartRecipeDto = new CartRecipeDto();
        cartRecipeDto.setRecipeId(recipe.getId());

        Long cartRecipeId = cartService.addCart(cartRecipeDto, member.getEmail());
        CartRecipe cartRecipe = cartRecipeRepository.findById(cartRecipeId)
                .orElseThrow(EntityNotFoundException::new);

        assertEquals(recipe.getId(), cartRecipe.getRecipe().getId());
    }

}