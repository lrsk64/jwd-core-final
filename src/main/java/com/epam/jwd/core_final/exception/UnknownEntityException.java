package com.epam.jwd.core_final.exception;

import java.lang.reflect.Array;
import java.security.MessageDigestSpi;
import java.util.Arrays;

public class UnknownEntityException extends RuntimeException {

    private final String entityName;
    private final Object[] args;

    public UnknownEntityException(String entityName) {
        super();
        this.entityName = entityName;
        this.args = null;
    }

    public UnknownEntityException(String entityName, Object[] args) {
        super();
        this.entityName = entityName;
        this.args = args;
    }

    @Override
    public String getMessage() {
        // todo
        // you should use entityName, args (if necessary)
        String message = "Entity '" + entityName + "' does not exist.\n";

        if (args != null || args.length != 0){
            message += "Another info: " + Arrays.toString(args);
        }
        return message;
    }
}
