package com.chen.learn.service;

import com.chen.learn.domain.User;

import java.util.List;

/**
 * TODO 类描述
 *
 * @version 1.0
 * @auth chenqiliang
 * @date 2023-02-02 22:02
 */
public interface UserService {

    List<User> getUserById(String id);

    User getUserByIdOne(String id);
}
