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

    private int view;

    /**
     * @QueryProjection : Querydsl로 결과 조회 시, MainItemDto 객체로 바로 받아옴
     * - DTO 클래스로 변환하는 과정 없이 바로 DTO 객체를 뽑아냄
     * - DTO 기반으로 생성된 QDTO 객체의 생성자를 사용하는 것
     * */
    @QueryProjection
    public MainItemDto(Long id, String recipeName, String recipeDetail, String imgUrl, Integer price, int view) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeDetail = recipeDetail;
        this.imgUrl = imgUrl;
        this.price = price;
        this.view = view;
    }
}
