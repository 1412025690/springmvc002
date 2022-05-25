package com.kkb.Exception;

/**
 * 自定义异常类
 */
public class TeamNameException extends TeamException {

    public TeamNameException(){
    }

    public TeamNameException(String message){
        super(message);
    }
}
