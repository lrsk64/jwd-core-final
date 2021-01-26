package com.epam.jwd.core_final.exception;

import java.util.Arrays;

public class UnknownPropertyException extends RuntimeException{

    private final String propertyName;
    private final Object[] args;

    public UnknownPropertyException(String propertyName) {
        super();
        this.propertyName = propertyName;
        this.args = null;
    }

    public UnknownPropertyException(String propertyName, Object[] args) {
        super();
        this.propertyName = propertyName;
        this.args = args;
    }


    public String getMessage() {
        String message = "Property '" + propertyName +  "' not found in properties file.";
        if(args != null || args.length != 0){
            message += "Another info: " + Arrays.toString(args);
        }
        return message;
    }
}
