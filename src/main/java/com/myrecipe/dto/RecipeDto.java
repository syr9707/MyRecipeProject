package com.myrecipe.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RecipeDto {

    private Long id;
    private String recipeName;
    private Integer price;
    private String recipeDetail;
    private String levelStatCd;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}
