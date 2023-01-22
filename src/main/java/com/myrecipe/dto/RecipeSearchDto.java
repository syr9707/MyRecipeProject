package com.myrecipe.dto;

import com.myrecipe.constant.RecipeLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecipeSearchDto {

    private String searchDateType;
    private RecipeLevel searchLevel;
    private String searchBy;
    private String searchQuery = "";

}
