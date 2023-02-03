package com.chen.learn.action;

import com.chen.learn.domain.User;
import com.chen.learn.service.UserService;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO 类描述
 *
 * @version 1.0
 * @auth chenqiliang
 * @date 2023-01-29 23:54
 */
@RestController
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser.do")
    public List<User> getUser(String id){
        return userService.getUserById(id);
    }

    @GetMapping("/getUserOne.do")
    public User getUserOne(String id){
        return userService.getUserByIdOne(id);
    }

}
