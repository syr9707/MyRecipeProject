package com.myrecipe.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // 회원 이름 중복
    MEMBERNAME_DUPLICATED(HttpStatus.CONFLICT, ""),

    // 레시피 이름 중복
    RECIPENAME_DUPLICATED(HttpStatus.CONFLICT, ""),

    // 레시피 이미지 등록하지 않은 경우
    RECIPEIMG_NULL(HttpStatus.NOT_FOUND, "");

    private HttpStatus httpStatus;
    private String message;

}
