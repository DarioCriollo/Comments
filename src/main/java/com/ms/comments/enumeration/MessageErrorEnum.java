package com.ms.comments.enumeration;

import org.springframework.http.HttpStatus;

public enum MessageErrorEnum {

    VALIDATION_ERROR(HttpStatus.BAD_REQUEST,"There are attributes with wrong values"),
    BAD_FORMAT(HttpStatus.BAD_REQUEST, "The message not have a correct form"),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "Comment not found"),
    COMMENT_SAME_ID(HttpStatus.BAD_REQUEST, "There is a comment with the same id"),
    ;
    private final HttpStatus httpStatus;
    private final String message;

    MessageErrorEnum(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
