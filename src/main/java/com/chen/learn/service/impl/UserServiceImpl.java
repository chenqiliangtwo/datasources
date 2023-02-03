package com.chen.learn.service.impl;

import com.chen.learn.DataSourceTagEnum;
import com.chen.learn.annotation.DataSourceAnnotation;
import com.chen.learn.dao.UserMapper;
import com.chen.learn.datasource.DynamicDataSource;
import com.chen.learn.domain.User;
import com.chen.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 类描述
 *
 * @version 1.0
 * @auth chenqiliang
 * @date 2023-02-02 22:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserById(String id) {
        List<User> userList = new ArrayList<>();
        DynamicDataSource.threadLocal.set(DataSourceTagEnum.DATA_SOURCE_ONE);
        User userByIdFromOne = userMapper.getUserById(id);
        DynamicDataSource.threadLocal.set(DataSourceTagEnum.DATA_SOURCE_tWO);
        User userByIdFromTwo = userMapper.getUserById(id);
        userList.add(userByIdFromOne);
        userList.add(userByIdFromTwo);
        return userList;
    }

    @Override
    @DataSourceAnnotation(DataSourceTagEnum.DATA_SOURCE_ONE)
    public User getUserByIdOne(String id) {
        return userMapper.getUserById(id);
    }
}
