package com.myrecipe.service.comment;

import com.myrecipe.dto.CommentRequestDto;
import com.myrecipe.entity.Comment;
import com.myrecipe.entity.Member;
import com.myrecipe.entity.Recipe;
import com.myrecipe.exception.member.MemberException;
import com.myrecipe.exception.member.MemberExceptionType;
import com.myrecipe.repository.CommentRepository;
import com.myrecipe.repository.MemberRepository;
import com.myrecipe.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final RecipeRepository recipeRepository;

    /* CREATE */
    @Transactional
    public Long commentSave(String email, Long id, CommentRequestDto dto) {
        Member member = memberRepository.findByEmail(email);
        Recipe recipe = recipeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id)
        );

        dto.setMember(member);
        dto.setRecipe(recipe);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }

    /* UPDATE */
    @Transactional
    public void update(Long id, CommentRequestDto dto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다." + id)
        );

        comment.update(dto.getComment());
    }

    /* DELETE */
    @Transactional
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다." + id)
        );

        commentRepository.delete(comment);
    }

}
