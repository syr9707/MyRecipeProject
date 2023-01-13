package com.myrecipe.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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

}