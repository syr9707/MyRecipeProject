package com.myrecipe.entity;

import com.myrecipe.constant.RecipeLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 레시피 코드

    @Column(nullable = false, length = 50)
    private String recipeName; // 레시피명

    @Column(nullable = false)
    private int price; // 예상 가격

    @Column(nullable = false)
    private int recommendation; // 추천수

    @Lob
    @Column(nullable = false)
    private String recipeDetail; // 레시피 상세 설명

    @Enumerated(EnumType.STRING)
    private RecipeLevel recipeLevel;

    private LocalDateTime regTime; // 레시피 등록 시간
    private LocalDateTime updateTime; // 레시피 수정 시간


}
