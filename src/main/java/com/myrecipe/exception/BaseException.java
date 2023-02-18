package com.myrecipe.exception;

public abstract class BaseException extends RuntimeException {

    public abstract BaseExceptionType getExceptionType();

}
