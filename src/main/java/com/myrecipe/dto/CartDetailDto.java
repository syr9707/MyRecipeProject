package com.myrecipe.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartDetailDto {

    private Long cartRecipeId; //장바구니 레시피 아이디

    private String recipeName; //레시피명

    private int price; //레시피 금액

    private String imgUrl; //레시피 이미지 경로

    public CartDetailDto(Long cartRecipeId, String recipeName, int price, String imgUrl) {
        this.cartRecipeId = cartRecipeId;
        this.recipeName = recipeName;
        this.price = price;
        this.imgUrl = imgUrl;
    }

}
