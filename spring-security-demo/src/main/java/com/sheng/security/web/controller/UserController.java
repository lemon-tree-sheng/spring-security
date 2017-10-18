package com.sheng.security.web.controller;

import com.sheng.security.web.dto.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengxingyue on 2017/10/18.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(@RequestParam(value = "username", defaultValue = "hello") String username) {
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }
}
