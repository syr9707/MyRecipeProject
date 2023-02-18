package com.myrecipe.dto;

import com.myrecipe.entity.Comment;
import com.myrecipe.entity.Member;
import com.myrecipe.entity.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {

    private Long id;
    private String comment;
    private Member member;
    private Recipe recipe;

    /* Dto -> Entity */
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .comment(comment)
                .member(member)
                .recipe(recipe)
                .build();

        return comments;
    }

}
