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
    @PostMapping("/posts/{id}/comments")
    public ResponseEntity commentSave(@PathVariable Long id, @RequestBody CommentRequestDto dto, Principal principal) {

        return ResponseEntity.ok(commentService.commentSave(principal.getName(), id, dto));
    }

    /* UPDATE */
    @PutMapping("/posts/{id}/comments/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody CommentRequestDto dto) {
        commentService.update(id, dto);
        return ResponseEntity.ok(id);
    }

    /* DELETE */
    @DeleteMapping("/posts/{id}/comments/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.ok(id);
    }

}
