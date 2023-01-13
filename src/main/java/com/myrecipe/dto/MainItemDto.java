package com.myrecipe.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MainItemDto {

    private Long id;
    private String recipeName;
    private String recipeDetail;
    private String imgUrl;
    private Integer price;

    @QueryProjection
    public MainItemDto(Long id, String recipeName, String recipeDetail, String imgUrl, Integer price) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeDetail = recipeDetail;
        this.imgUrl = imgUrl;
        this.price = price;
    }
}
