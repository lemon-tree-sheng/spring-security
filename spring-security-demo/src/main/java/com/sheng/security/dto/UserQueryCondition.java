package com.sheng.security.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by shengxingyue on 2017/10/18.
 */
public class UserQueryCondition {
    @ApiModelProperty("用户名")
    private String username;
    private int age;
    private int ageTo;
    private String xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }
}
