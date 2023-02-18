package com.myrecipe.dto;

import com.myrecipe.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {

    private Long id;
    private String comment;
    private String name;
    private Long recipeId;

    /* Entity -> Dto*/
    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.name = comment.getMember().getName();
        this.recipeId = comment.getRecipe().getId();
    }

}
