package com.sheng.security.web.dto;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

/**
 * Created by shengxingyue on 2017/10/18.
 */
public class User {
    // 声明 jsonview 视图
    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView{};

    @JsonView(UserSimpleView.class)
    private Integer id;
    @JsonView(UserSimpleView.class)
    private String username;
    @JsonView(UserDetailView.class)
    private String password;
    @JsonView(UserSimpleView.class)
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
