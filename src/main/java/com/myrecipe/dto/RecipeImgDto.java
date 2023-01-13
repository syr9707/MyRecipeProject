package com.myrecipe.dto;

import com.myrecipe.entity.RecipeImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Setter
@Getter
public class RecipeImgDto {

    private Long id;

    private String imgName;

    private String oriImgName;

    private String imgUrl;

    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();  // 멤버 변수로 ModelMapper 객체 추가

    public static RecipeImgDto of(RecipeImg recipeImg) {
        /**
         * RecipeImg 엔티티 객체를 파라미터로 받아서
         * RecipeImg 객체의 자료형과 멤버변수의 이름이 같을 때
         * RecipeImgDto로 값을 복사해서 반환.
         * static : RecipeImgDto 객체 생성 안 해도 호출 가능
         * */
        return modelMapper.map(recipeImg, RecipeImgDto.class);
    }

}
