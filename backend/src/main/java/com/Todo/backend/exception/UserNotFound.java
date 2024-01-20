package com.Todo.backend.exception;

public class UserNotFound extends MasterException{

    private final static String MESSAGE = "존재하지 않는 회원입니다.";

    public UserNotFound() {
        super(MESSAGE);
    }


    @Override
    public int stateCode() {
        return 404;
    }
}
