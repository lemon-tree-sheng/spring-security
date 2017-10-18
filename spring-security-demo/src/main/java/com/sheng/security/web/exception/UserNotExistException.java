package com.sheng.security.web.exception;

/**
 * Created by shengxingyue on 2017/10/19.
 */
public class UserNotExistException extends RuntimeException{

    private String id;

    public UserNotExistException(String id) {
        super("user is not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
