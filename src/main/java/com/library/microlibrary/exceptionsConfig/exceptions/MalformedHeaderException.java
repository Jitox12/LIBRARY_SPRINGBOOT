package com.library.microlibrary.exceptionsConfig.exceptions;

public class MalformedHeaderException extends BadRequestException{

    private static final String DESCRIPTION = "Malformed Header ";

    public MalformedHeaderException(String detail) {
        super(DESCRIPTION.concat(detail));
    }
}