package com.epam.jwd.core_final.exception;

import java.util.Arrays;

public class NotAbleToAssignException extends RuntimeException{
    private final String name;
    private final Object[] args;

    public NotAbleToAssignException(String name) {
        this.name = name;
        this.args = null;
    }

    public NotAbleToAssignException(String name, Object[] args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public String getMessage() {
        String message = "Entity '" + name + "'  is not able to be assigned.\n";

        if (args != null || args.length != 0){
            message += "Another info: " + Arrays.toString(args);
        }
        return message;
    }
}
