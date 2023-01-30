package com.myrecipe.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * 여기서 금액을 저장하는 필드를 long 타입(원시타입)으로 정하면
 * Null값이 들어와도 0으로 들어와 문제를 감지하지 못한다.
 * 사용자에게 입력받는 RequestDto는 레퍼런스타입으로 지정해야한다.
 * */
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
