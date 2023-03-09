package com.myrecipe.controller;

import com.myrecipe.dto.CommentRequestDto;
import com.myrecipe.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CommentApiController {

    private final CommentService commentService;

    /* CREATE */
    @PostMapping("/recipe/{recipeId}/comments")
    public ResponseEntity commentSave(@PathVariable("recipeId") Long recipeId, @RequestBody CommentRequestDto dto, Principal principal) {

        return ResponseEntity.ok(commentService.commentSave(principal.getName(), recipeId, dto));
    }

    /* UPDATE */
    @PutMapping("/recipe/{recipeId}/comments/{commentId}")
    public ResponseEntity update(@PathVariable("recipeId") Long recipeId, @RequestBody CommentRequestDto dto, @PathVariable("commentId") Long commentId) {
        commentService.update(commentId, dto);
        return ResponseEntity.ok(commentId);
    }

    /* DELETE */
    @DeleteMapping("/recipe/{recipeId}/comments/{commentId}")
    public ResponseEntity delete(@PathVariable("recipeId") Long recipeId, @PathVariable("commentId") Long commentId) {
        commentService.delete(commentId);
        return ResponseEntity.ok(commentId);
    }

}
