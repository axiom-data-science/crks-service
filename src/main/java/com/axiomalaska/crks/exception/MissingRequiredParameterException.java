package com.axiomalaska.crks.exception;

public class MissingRequiredParameterException extends Exception {
    public MissingRequiredParameterException( String param ){
        super("Missing required parameter: " + param );
    }
}
