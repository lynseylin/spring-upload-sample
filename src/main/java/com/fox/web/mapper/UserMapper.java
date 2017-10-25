package com.fox.web.mapper;

import com.fox.web.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by linxiaofang on 2017/8/31.
 */
public interface UserMapper {
    @Select("select * from user")
    List<User> findAllUsers();

    @Select("select * from user where id=#{id,jdbcType=INTEGER}")
    User findUserById(Integer id);
}
