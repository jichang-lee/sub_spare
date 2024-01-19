package com.Todo.backend.exception;

import java.util.HashMap;
import java.util.Map;

public abstract class MasterException extends RuntimeException{


    public Map<String,String> validation = new HashMap<>();
    public abstract int stateCode();

    public MasterException(String message) {
        super(message);
    }

    public void addValidation(String message , String fliedName){
        validation.put(message,fliedName);
    }
}
