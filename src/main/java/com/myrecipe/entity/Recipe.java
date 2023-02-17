package com.myrecipe.entity;

import com.myrecipe.constant.RecipeLevel;
import com.myrecipe.dto.RecipeFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@Entity
public class Recipe extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="recipe_id")
    private Long id; // 레시피 코드

    @Column(nullable = false, length = 50)
    private String recipeName; // 레시피명

    @Column(nullable = false)
    private int price; // 예상 가격

//    @Column(nullable = false)
//    private int recommendation; // 추천수

    @Lob
    @Column(nullable = false)
    private String recipeDetail; // 레시피 상세 설명

    @Enumerated(EnumType.STRING)
    private RecipeLevel recipeLevel; // 요리 난이도

    // 조회수 업데이트
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    public void updateRecipe(RecipeFormDto recipeFormDto) {
        this.recipeName = recipeFormDto.getRecipeName();
        this.price = recipeFormDto.getPrice();
        this.recipeDetail = recipeFormDto.getRecipeDetail();
        this.recipeLevel = recipeFormDto.getRecipeLevel();
    }

}
