package com.fox.web.controller;

import com.fox.web.domain.Result;
import com.fox.web.domain.User;
import com.fox.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by linxiaofang on 2017/8/31.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Result<?> findUserById(@PathVariable("id") Integer id) { return userService.findUserById(id); }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Result<?> findAllCity() { return userService.findAllUsers(); }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }
}

