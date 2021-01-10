package com.epam.jwd.core_final.exception;

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
        String message = "Such entity does not exist.";
        if(entityName != null || entityName != ""){
            message += " Entity name: " + entityName +  ".";
            if(args != null){
                message += " Another info:";
                for (Object arg : args) {
                    if(arg != null){
                        message += " " + arg.toString() + ";";
                    }
                }
            }
        }
        return message;
    }

}
