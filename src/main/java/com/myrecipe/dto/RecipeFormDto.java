package com.myrecipe.dto;

import com.myrecipe.constant.RecipeLevel;
import com.myrecipe.entity.Recipe;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 레시피 데이터 정보를 전달하는 DTO
 * */
@Getter
@Setter
public class RecipeFormDto {

    private Long id;

    @NotBlank(message = "레시피명은 필수 입력 값입니다.")
    private String recipeName;

    @NotNull(message = "예상 가격은 필수 입력 값입니다.")
    private Integer price;

    @NotBlank(message = "레시피 상세는 필수 입력 값입니다.")
    private String recipeDetail;

//    @NotNull(message = "재고는 필수 입력 값입니다.")
//    private Integer stockNumber;

    private RecipeLevel recipeLevel;

    private List<RecipeImgDto> recipeImgDtoList = new ArrayList<>(); // 레시피 저장 후 수정할 때 레시피 이미지 정보를 저장하는 리스트

    private List<Long> recipeImgIds = new ArrayList<>(); // 레시피 이미지 아이디 저장 리스트

    private static ModelMapper modelMapper = new ModelMapper(); // 엔티티 객체와 DTO 객체 간의 데이터를 복사하여 복사한 객체를 반환


    /**
     * modelMapper를 이용하여 엔티티 객체와 DTO 객체 간의 데이터를 복사하여
     * 복사한 객체를 반환해주는 메소드
     * */
    /**
     * - Entity -> DTO = of()
     * - DTO -> Entitty = toEntity()
     * */
    public Recipe createRecipe() {
        return modelMapper.map(this, Recipe.class);
    }

    // Entity -> DTO
    public static RecipeFormDto of(Recipe recipe) {
        return modelMapper.map(recipe, RecipeFormDto.class);
    }

}
