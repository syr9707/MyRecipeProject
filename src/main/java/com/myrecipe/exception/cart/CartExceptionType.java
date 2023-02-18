package com.myrecipe.exception.cart;

import com.myrecipe.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum CartExceptionType implements BaseExceptionType {

    ALREADY_EXIST_CART(600, HttpStatus.CONFLICT, "마이페이지에 이미 저장되어있습니다."),
    NOT_FOUND_CART(602, HttpStatus.NOT_FOUND, "장바구니 정보가 없습니다.");

    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    CartExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
