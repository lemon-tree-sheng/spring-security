package com.sheng.security.web.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by shengxingyue on 2017/10/18.
 */
public class User {
    // 声明 jsonview 视图
    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView{};

    @JsonView(UserSimpleView.class)
    private String username;
    @JsonView(UserDetailView.class)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
