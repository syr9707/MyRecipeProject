package com.myrecipe.service.recipe;

import com.myrecipe.entity.RecipeImg;
import com.myrecipe.repository.RecipeImgRepository;
import com.myrecipe.service.recipe.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;

/**
 * 레시피의 이미지 업로드, 레시피 이미지 정보 저장
 * */
@Service
@RequiredArgsConstructor
@Transactional
public class RecipeImgService {

    @Value("${recipeImgLocation}")
    private String recipeImgLocation;

    private final RecipeImgRepository recipeImgRepository;

    private final FileService fileService;

    public void saveRecipeImg(RecipeImg recipeImg, MultipartFile recipeImgFile) throws Exception {
        String oriImgName = recipeImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        //파일 업로드
        if(StringUtils.hasText(oriImgName)){
            imgName = fileService.uploadFile(recipeImgLocation, oriImgName,
                    recipeImgFile.getBytes());
            imgUrl = "/images/recipe/" + imgName;
        }

        // 레시피 이미지 정보 저장
        recipeImg.updateRecipeImg(oriImgName, imgName, imgUrl);
        recipeImgRepository.save(recipeImg);
    }

    public void updateRecipeImg(Long recipeImgId, MultipartFile recipeImgFile) throws Exception {
        if(!recipeImgFile.isEmpty()) {
            RecipeImg savedRecipeImg = recipeImgRepository.findById(recipeImgId)
                    .orElseThrow(EntityNotFoundException::new);

            // 기존 이미지 파일 삭제
            if(StringUtils.hasText(savedRecipeImg.getImgName())) {
                fileService.deleteFile(recipeImgLocation+"/"+savedRecipeImg.getImgName());
            }

            String oriImgName = recipeImgFile.getOriginalFilename();
            String imgName = fileService.uploadFile(recipeImgLocation, oriImgName, recipeImgFile.getBytes());
            String imgUrl = "/images/recipe/" + imgName;
            savedRecipeImg.updateRecipeImg(oriImgName, imgName, imgUrl);
        }
    }

}
