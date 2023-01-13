package com.myrecipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    @GetMapping(value = "/admin/recipe/new")
    public String recipeForm() {
        return "/recipe/recipeForm";
    }

}
