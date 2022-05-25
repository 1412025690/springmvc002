package com.kkb.Exception;

/**
 * 自定义异常类
 */
public class TeamIdException extends TeamException {

    public TeamIdException(){
    }

    public TeamIdException(String message){
        super(message);
    }
}
