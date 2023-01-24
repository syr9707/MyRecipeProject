package com.myrecipe.controller;

import com.myrecipe.constant.RecipeLevel;
import com.myrecipe.dto.RecipeFormDto;
import com.myrecipe.exception.AppException;
import com.myrecipe.exception.ErrorCode;
import com.myrecipe.service.RecipeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 로그인된 사용자의 Role에 따라 레시피 등록 페이지에 접근이 가능한지 테스트
 * */
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
class RecipeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RecipeService recipeService;

    @Test
    @DisplayName("레시피 등록 페이지 권한 테스트")
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void recipeFormTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/recipe/new"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("레시피 등록 페이지 일반 회원 접근 테스트")
    @WithMockUser(username = "user", roles = "USER")
    public void recipeFormNotAdminTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/recipe/new"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("레시피 이미지 등록하지 않았을 때 테스트")
    @WithMockUser(username = "admin", roles = "USER")
    public void recipeImgIsEmpty() {
        RecipeFormDto recipeFormDto = new RecipeFormDto();
        recipeFormDto.setRecipeName("테스트 레시피");
        recipeFormDto.setRecipeLevel(RecipeLevel.EASY);
        recipeFormDto.setRecipeDetail("테스트 레시피 입니다.");
        recipeFormDto.setPrice(30000);

        List<MultipartFile> multipartFileList = new ArrayList<>();

//        try {
////            recipeService.saveRecipe(recipeFormDto, multipartFileList);
//        } catch (AppException e) {
//            e = assertThrows(AppException.class, () -> {
//                recipeService.saveRecipe(recipeFormDto, multipartFileList);
//            });
//            assertEquals("첫 번째 레시피dkdk 이미지는 필수 입력 값 입니다.", e.getMessage());
//        }


        Throwable e = assertThrows(AppException.class, () -> {
            recipeService.saveRecipe(recipeFormDto, multipartFileList);
//            throw new AppException(ErrorCode.RECIPEIMG_NULL, "첫 번째 레시피 이미지는 필수 입력 값 입니다.");
        });

        assertEquals("첫 번째 레시피dkdk 이미지는 필수 입력 값 입니다.", e.getMessage());

    }

}