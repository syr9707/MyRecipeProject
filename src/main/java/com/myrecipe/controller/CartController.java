package com.myrecipe.controller;

import com.myrecipe.dto.CartDetailDto;
import com.myrecipe.dto.CartRecipeDto;
import com.myrecipe.exception.AppException;
import com.myrecipe.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    /**
     * Principal : 현재 로그인한 유저의 정보를 얻기 위해 principle 객체를 넘겨 줄 경우 해당 객체에 직접 접근 가능함.
     * */
    @PostMapping(value = "/cart")
    public @ResponseBody ResponseEntity order(@RequestBody @Valid CartRecipeDto cartRecipeDto, BindingResult bindingResult, Principal principal, Model model) {

        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                sb.append(fieldError.getDefaultMessage());
            }

            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        String email = principal.getName(); // principle 객체에서 현재 로그인한 회원의 이메일 정보를 조회
        Long cartRecipeId;

//        try {
//            cartRecipeId = cartService.addCart(cartRecipeDto, email);
//        } catch (Exception e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }

        try {
            cartRecipeId = cartService.addCart(cartRecipeDto, email);
        } catch (AppException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Long>(cartRecipeId, HttpStatus.OK);
    }

    @GetMapping(value = "/cart")
    public String orderHist(Principal principal, Model model) {
        List<CartDetailDto> cartDetailList = cartService.getCartList(principal.getName()); // principle 객체에서 현재 로그인한 회원의 정보를 조회
        model.addAttribute("cartRecipes", cartDetailList);
        return "cart/cartList";
    }

    @DeleteMapping(value = "/cartRecipe/{cartRecipeId}")
    public @ResponseBody ResponseEntity deleteCartRecipe(@PathVariable("cartRecipeId") Long cartRecipeId, Principal principal) {

        cartService.deleteCartRecipe(cartRecipeId);

        return new ResponseEntity<Long>(cartRecipeId, HttpStatus.OK);
    }

}
