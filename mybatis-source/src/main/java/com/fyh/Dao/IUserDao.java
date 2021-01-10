package com.fyh.Dao;

import com.fyh.cfg.annotation.Select;
import com.fyh.pojo.User;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
