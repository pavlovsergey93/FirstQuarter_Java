package com.geekbrains.java.lesson9.Exception;

public class MyArraySizaException extends RuntimeException{
    public MyArraySizaException(){
    }

    public MyArraySizaException(String message) {
        super(message);
    }

    public MyArraySizaException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArraySizaException(Throwable cause) {
        super(cause);
    }

    public MyArraySizaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
