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
    RECIPENAME_DUPLICATED(HttpStatus.CONFLICT, "");

    private HttpStatus httpStatus;
    private String message;

}
