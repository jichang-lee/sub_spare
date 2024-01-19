package com.Todo.backend.exception;

public class AlreadyExistsEmail extends MasterException{

    private static final String MESSAGE = "이미 가입된 이메일이 존재합니다.";

    public AlreadyExistsEmail() {
        super(MESSAGE);
    }

    @Override
    public int stateCode() {
        return 400;
    }
}
