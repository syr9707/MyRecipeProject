package com.myrecipe.controller;

import com.myrecipe.dto.RecipeFormDto;
import com.myrecipe.service.recipe.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping(value = "/admin/recipe/new")
    public String recipeForm(Model model) {
        model.addAttribute("recipeFormDto", new RecipeFormDto());
        return "recipe/recipeForm";
    }

    @PostMapping(value = "/admin/recipe/new")
    public String recipeNew(@Valid RecipeFormDto recipeFormDto, BindingResult bindingResult,
                          Model model, @RequestParam("recipeImgFile") List<MultipartFile> recipeImgFileList){

        if(bindingResult.hasErrors()){
            return "recipe/recipeForm";
        }

        if(recipeImgFileList.get(0).isEmpty() && recipeFormDto.getId() == null){
            model.addAttribute("errorMessage", "첫번째 음식 이미지는 필수 입력 값 입니다.");
            return "recipe/recipeForm";
        }

        try {
            recipeService.saveRecipe(recipeFormDto, recipeImgFileList);
        } catch (Exception e){
            model.addAttribute("errorMessage", "레시피 등록 중 에러가 발생하였습니다.");
            return "recipe/recipeForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/admin/recipe/{recipeId}")
    public String recipeDtl(@PathVariable("recipeId") Long recipeId, Model model) {

        try{
            RecipeFormDto recipeFormDto = recipeService.getRecipeDtl(recipeId);
            model.addAttribute("recipeFormDto", recipeFormDto);
        } catch (EntityNotFoundException e) {
            model.addAttribute("errorMessage", "존재하지 않는 레시피 입니다.");
            model.addAttribute("recipeFormDto", new RecipeFormDto());
            return "recipe/recipeForm";
        }

        return "recipe/recipeForm";
    }

    @PostMapping(value = "/admin/recipe/{recipeId}")
    public String recipeUpdate(@Valid RecipeFormDto recipeFormDto, BindingResult bindingResult,
                               @RequestParam("recipeImgFile") List<MultipartFile> recipeImgFileList, Model model) {

        if(bindingResult.hasErrors()) {
            return "recipe/recipeForm";
        }

        if(recipeImgFileList.get(0).isEmpty() && recipeFormDto.getId() == null) {
            model.addAttribute("errorMessage", "첫번째 음식 이미지는 필수 입력 값 입니다.");
            return "recipe/recipeForm";
        }

        try {
            recipeService.updateRecipe(recipeFormDto, recipeImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "레시피 수정 중 에러가 발생하였습니다.");
            return "recipe/recipeForm";
        }

        return "redirect:/";
    }

    // 게시물 상세보기
    @GetMapping(value = "/recipe/{recipeId}")
    public String recipeDtl(Model model, @PathVariable("recipeId") Long recipeId) {
        RecipeFormDto recipeFormDto = recipeService.getRecipeDtl(recipeId);

        /* 댓글 관련 */
//        List<CommentResponseDto> comments = recipeFormDto.getComments();
//
//        if(comments != null && comments.isEmpty()) {
//            model.addAttribute("comments", comments);
//        }

        /* 사용자 관련 */
//        String email = principal.getName(); // principle 객체에서 현재 로그인한 회원의 이메일 정보를 조회
//        if (email != null) {
//            model.addAttribute("email", email);
//        }

        recipeService.updateView(recipeId); // views ++
        model.addAttribute("recipe", recipeFormDto);

        return "recipe/recipeDtl";
    }

}
