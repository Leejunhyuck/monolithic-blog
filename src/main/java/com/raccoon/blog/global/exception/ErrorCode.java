package com.raccoon.blog.global.exception;

public enum ErrorCode {

    AUTHENTICATION_FAILED(100, "authentication failed."),
    AUTHORIZATION_FAILED (101, "authorization failed."),
    DUPLICATE_USERNAME(200, "id already exists."),
    INVALID_JWT(300, "jwt validation failed.");

    private int code;
    private String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}