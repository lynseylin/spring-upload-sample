package com.fox.web.service;

import com.fox.web.mapper.UserMapper;
import com.fox.web.domain.Result;
import com.fox.web.domain.ResultEnum;
import com.fox.web.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by linxiaofang on 2017/8/31.
 */
@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public Result<?> findAllUsers() {
        LOGGER.info("request for all products");
        List<User> users = userMapper.findAllUsers();
        LOGGER.info("user size: {}", users == null ? 0 : users.size());
        return new Result(ResultEnum.SUCCESS, users);
    }

    public Result<?> findUserById(Integer id) {
        User user=userMapper.findUserById(id);
        LOGGER.info("request for userId: {},founded {}", id,user!=null);
        return new Result(ResultEnum.SUCCESS, user);
    }

    public Long addUser(User user) {
//        return userDao.addUser(user);
        return null;
    }

    public Long updateUser(User user) {
//        return userDao.updateUser(user);
        return null;
    }

    public Long deleteUser(Integer id) {
//        return userDao.deleteUser(id);
        return null;
    }
}