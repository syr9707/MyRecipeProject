package com.myrecipe.controller;

import com.myrecipe.dto.MainItemDto;
import com.myrecipe.dto.RecipeSearchDto;
import com.myrecipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final RecipeService recipeService;

    @GetMapping(value = "/")
    public String main(RecipeSearchDto recipeSearchDto, Optional<Integer> page, Model model){

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
        Page<MainItemDto> recipes = recipeService.getMainRecipePage(recipeSearchDto, pageable);

        model.addAttribute("recipes", recipes);
        model.addAttribute("recipeSearchDto", recipeSearchDto);
        model.addAttribute("maxPage", 5);

        return "main";
    }

}
