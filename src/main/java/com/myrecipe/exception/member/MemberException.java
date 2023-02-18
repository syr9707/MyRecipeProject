package com.myrecipe.exception.member;

import com.myrecipe.exception.BaseException;
import com.myrecipe.exception.BaseExceptionType;

public class MemberException extends BaseException {

    private BaseExceptionType exceptionType;

    public MemberException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}
