package com.kevin.mybatisdemo.mapper;

//import com.wyh.springbootmybatisdemo.pojo.User;

import com.kevin.mybatisdemo.pojo.User;

import java.util.List;

public interface UserMapper {
    User findById(Long id);
    List<User> findAll();
}
