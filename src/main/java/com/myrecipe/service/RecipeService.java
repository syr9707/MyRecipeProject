package com.myrecipe.service;

import com.myrecipe.dto.MainItemDto;
import com.myrecipe.dto.RecipeFormDto;
import com.myrecipe.dto.RecipeImgDto;
import com.myrecipe.dto.RecipeSearchDto;
import com.myrecipe.entity.Recipe;
import com.myrecipe.entity.RecipeImg;
import com.myrecipe.repository.RecipeImgRepository;
import com.myrecipe.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * 레시피 등록
 * */
@Service
@Transactional
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeImgRepository recipeImgRepository;
    private final RecipeImgService recipeImgService;

    public Long saveRecipe(RecipeFormDto recipeFormDto, List<MultipartFile> recipeImgFileList) throws Exception {

        // 레시피 등록
        Recipe recipe = recipeFormDto.createRecipe();
        recipeRepository.save(recipe);

        // 이미지 등록
        for(int i = 0; i < recipeImgFileList.size(); i++) {
            RecipeImg recipeImg = new RecipeImg();
            recipeImg.setRecipe(recipe);
            if(i == 0) {
                recipeImg.setRepimgYn("Y");
            } else {
                recipeImg.setRepimgYn("N");
            }
            recipeImgService.saveRecipeImg(recipeImg, recipeImgFileList.get(i));
        }

        return recipe.getId();

    }

    /**
     * 등록된 상품을 불러옴
     * */
    @Transactional(readOnly = true)
    public RecipeFormDto getRecipeDtl(Long recipeId){
        List<RecipeImg> recipeImgList = recipeImgRepository.findByRecipeIdOrderByIdAsc(recipeId);
        List<RecipeImgDto> recipeImgDtoList = new ArrayList<>();
        for (RecipeImg recipeImg : recipeImgList) {
            RecipeImgDto recipeImgDto = RecipeImgDto.of(recipeImg);
            recipeImgDtoList.add(recipeImgDto);
        }

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(EntityNotFoundException::new);
        RecipeFormDto recipeFormDto = RecipeFormDto.of(recipe);
        recipeFormDto.setRecipeImgDtoList(recipeImgDtoList);
        return recipeFormDto;
    }

    public Long updateRecipe(RecipeFormDto recipeFormDto, List<MultipartFile> recipeImgFileList) throws Exception {

        // 상품 수정
        Recipe recipe = recipeRepository.findById(recipeFormDto.getId())
                .orElseThrow(EntityNotFoundException::new);
        recipe.updateRecipe(recipeFormDto);

        List<Long> recipeImgIds = recipeFormDto.getRecipeImgIds();

        // 이미지 등록
        for(int i = 0; i < recipeImgFileList.size(); i++) {
            recipeImgService.updateRecipeImg(recipeImgIds.get(i), recipeImgFileList.get(i));
        }

        return recipe.getId();
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getMainItemPage(RecipeSearchDto recipeSearchDto, Pageable pageable) {
        return recipeRepository.getMainRecipePage(recipeSearchDto, pageable);
    }

}