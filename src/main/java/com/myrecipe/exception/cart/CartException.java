package com.myrecipe.exception.cart;

import com.myrecipe.exception.BaseException;
import com.myrecipe.exception.BaseExceptionType;

public class CartException extends BaseException {

    private BaseExceptionType exceptionType;

    public CartException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}
