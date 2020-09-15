package com.kevin.mybatisdemo.controller;

import com.kevin.mybatisdemo.configure.Result;
import com.kevin.mybatisdemo.mapper.UserMapper;
import com.kevin.mybatisdemo.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping
    public User findUser(@RequestParam(value = "id") Long id){
        return userMapper.findById(id);
    }
    @GetMapping("/all")
    public List<User> findUsers(){
        return userMapper.findAll();
    }
    @GetMapping("/test")
    public Result<String,String> test() {
        return Result.success("ok");
    }
}