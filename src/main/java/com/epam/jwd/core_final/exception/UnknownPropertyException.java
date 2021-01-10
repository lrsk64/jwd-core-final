package com.epam.jwd.core_final.exception;

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
        String message = "Property not fount in properties file.";
        // todo
        // you should use entityName, args (if necessary)
        if(propertyName != null){
            message += "Property name: " + propertyName +  ".";
            if(args != null){
                message += "Another info: ";
                for (Object arg : args) {
                    message += arg.toString();
                }
            }
        }
        return message;
    }
}
