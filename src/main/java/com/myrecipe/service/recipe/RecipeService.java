package com.myrecipe.service.recipe;

import com.myrecipe.dto.MainItemDto;
import com.myrecipe.dto.RecipeFormDto;
import com.myrecipe.dto.RecipeImgDto;
import com.myrecipe.dto.RecipeSearchDto;
import com.myrecipe.entity.Recipe;
import com.myrecipe.entity.RecipeImg;
import com.myrecipe.repository.RecipeImgRepository;
import com.myrecipe.repository.RecipeRepository;
import com.myrecipe.service.recipe.RecipeImgService;
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

        // recipeName 중복 체크
//        List<Recipe> findRecipe = recipeRepository.findByRecipeName(recipeFormDto.getRecipeName());
//        if(findRecipe != null) {
//            throw new AppException(ErrorCode.RECIPENAME_DUPLICATED, recipeFormDto.getRecipeName() + "는 이미 있습니다.");
//        }

        // 레시피 등록
        Recipe recipe = recipeFormDto.createRecipe();
        recipeRepository.save(recipe);

//        if(recipeImgFileList.get(0).isEmpty() && recipeFormDto.getId() == null) {
//            throw new AppException(ErrorCode.RECIPEIMG_NULL, "첫 번째 레시피 이미지는 필수 입력 값 입니다.");
//        }


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

        if(recipe.getCreatedBy() != null) {
            recipeFormDto.setUsername(recipe.getCreatedBy());
        }

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
    public Page<MainItemDto> getMainRecipePage(RecipeSearchDto recipeSearchDto, Pageable pageable) {
        return recipeRepository.getMainRecipePage(recipeSearchDto, pageable);
    }

    // 조회수 카운팅
    @Transactional
    public int updateView(Long id) {
        return recipeRepository.updateView(id);
    }

    // 조회수 출력
    @Transactional(readOnly = true)
    public int printView(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        return recipe.getView();
    }

}
