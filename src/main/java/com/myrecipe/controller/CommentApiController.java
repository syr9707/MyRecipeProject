package com.myrecipe.controller;

import com.myrecipe.dto.CommentRequestDto;
import com.myrecipe.service.CommentService;
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

}
