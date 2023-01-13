package com.myrecipe.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CartRecipeDto {

    @NotNull(message = "레시피 아이디는 필수 입력 값 입니다.")
    private Long recipeId;

}
