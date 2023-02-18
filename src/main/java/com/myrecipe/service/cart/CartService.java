package com.myrecipe.service.cart;

import com.myrecipe.dto.CartDetailDto;
import com.myrecipe.dto.CartRecipeDto;
import com.myrecipe.entity.Cart;
import com.myrecipe.entity.CartRecipe;
import com.myrecipe.entity.Member;
import com.myrecipe.entity.Recipe;
import com.myrecipe.exception.AppException;
import com.myrecipe.exception.ErrorCode;
import com.myrecipe.exception.cart.CartException;
import com.myrecipe.exception.cart.CartExceptionType;
import com.myrecipe.exception.member.MemberException;
import com.myrecipe.exception.member.MemberExceptionType;
import com.myrecipe.repository.CartRecipeRepository;
import com.myrecipe.repository.CartRepository;
import com.myrecipe.repository.MemberRepository;
import com.myrecipe.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final RecipeRepository recipeRepository;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    private final CartRecipeRepository cartRecipeRepository;

    public Long addCart(CartRecipeDto cartRecipeDto, String email) {
        Recipe recipe = recipeRepository.findById(cartRecipeDto.getRecipeId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);

        Cart cart = cartRepository.findByMemberId(member.getId());
        if(cart == null) {
            cart = Cart.createCart(member);
            cartRepository.save(cart);
        }

        CartRecipe savedCartRecipe = cartRecipeRepository.findByCartIdAndRecipeId(cart.getId(), recipe.getId());

        // 레시피 중복 저장
        if(savedCartRecipe != null) {
            throw new CartException(CartExceptionType.ALREADY_EXIST_CART);
        }

        CartRecipe cartRecipe = CartRecipe.createCartRecipe(cart, recipe);
        cartRecipeRepository.save(cartRecipe);
        return cartRecipe.getId();
    }

    @Transactional(readOnly = true)
    public List<CartDetailDto> getCartList(String email) {

        List<CartDetailDto> cartDetailDtoList = new ArrayList<>();

        Member member = memberRepository.findByEmail(email);
        Cart cart = cartRepository.findByMemberId(member.getId());
        if(cart == null) {
            return  cartDetailDtoList;
        }

        cartDetailDtoList = cartRecipeRepository.findCartDetailDtoList(cart.getId());
        return cartDetailDtoList;
    }

    public void deleteCartRecipe(Long cartRecipeId) {
        CartRecipe cartRecipe = cartRecipeRepository.findById(cartRecipeId)
                .orElseThrow(EntityNotFoundException::new);
        cartRecipeRepository.delete(cartRecipe);
    }

}
