package com.epam.jwd.core_final.exception;

import java.util.Arrays;

public class DuplicateEntityException extends RuntimeException{

    private final String entityName;
    private final Object[] args;

    public DuplicateEntityException(String entityName) {
        this.entityName = entityName;
        this.args = null;
    }

    public DuplicateEntityException(String entityName, Object[] args) {
        this.entityName = entityName;
        this.args = args;
    }

    @Override
    public String getMessage() {
        String message = "Entity '" + entityName + "' already exist.\n";

        if (args != null || args.length != 0){
            message += "Another info: " + Arrays.toString(args);
        }
        return message;
    }

}
