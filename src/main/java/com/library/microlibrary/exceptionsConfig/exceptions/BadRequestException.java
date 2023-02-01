package com.library.microlibrary.exceptionsConfig.exceptions;

public class BadRequestException extends RuntimeException{

    private static final String DESCRIPTION = "Bad Request ";

    public BadRequestException(String detail){
        super(DESCRIPTION.concat(detail));
    }
}
