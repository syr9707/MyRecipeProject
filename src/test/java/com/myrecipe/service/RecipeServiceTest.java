package com.myrecipe.service;

import com.myrecipe.constant.RecipeLevel;
import com.myrecipe.dto.RecipeFormDto;
import com.myrecipe.entity.Recipe;
import com.myrecipe.entity.RecipeImg;
import com.myrecipe.repository.RecipeImgRepository;
import com.myrecipe.repository.RecipeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeImgRepository recipeImgRepository;

    List<MultipartFile> createMultipartFiles() throws Exception {

        List<MultipartFile> multipartFileList = new ArrayList<>();

        for(int i=0;i<5;i++){
            String path = "C:/shop/recipe/";
            String imageName = "image" + i + ".jpg";
            MockMultipartFile multipartFile =
                    new MockMultipartFile(path, imageName, "image/jpg", new byte[]{1,2,3,4});
            multipartFileList.add(multipartFile);
        }

        return multipartFileList;
    }

    @Test
    @DisplayName("레시피 등록 테스트")
    @WithMockUser(username = "admin", roles = "ADMIN")
    void saveRecipe() throws Exception {
        RecipeFormDto recipeFormDto = new RecipeFormDto();
        recipeFormDto.setRecipeName("테스트 레시피");
        recipeFormDto.setRecipeLevel(RecipeLevel.EASY);
        recipeFormDto.setRecipeDetail("테스트 레시피 입니다.");
        recipeFormDto.setPrice(30000);

        List<MultipartFile> multipartFileList = createMultipartFiles();
        Long recipeId = recipeService.saveRecipe(recipeFormDto, multipartFileList);
        List<RecipeImg> recipeImgList = recipeImgRepository.findByRecipeIdOrderByIdAsc(recipeId);

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(EntityNotFoundException::new);

        assertEquals(recipeFormDto.getRecipeName(), recipe.getRecipeName());
        assertEquals(recipeFormDto.getRecipeLevel(), recipe.getRecipeLevel());
        assertEquals(recipeFormDto.getRecipeDetail(), recipe.getRecipeDetail());
        assertEquals(recipeFormDto.getPrice(), recipe.getPrice());
        assertEquals(multipartFileList.get(0).getOriginalFilename(), recipeImgList.get(0).getOriImgName());
    }

}