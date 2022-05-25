package com.kkb.Exception;

/**
 * 自定义异常类
 */
public class TeamException extends Exception {

    public TeamException(){
    }

    public TeamException(String message){
        super(message);
    }
}
