package com.chen.learn.dao;

import com.chen.learn.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * TODO 类描述
 *
 * @version 1.0
 * @auth chenqiliang
 * @date 2023-02-02 21:58
 */
@Mapper
public interface UserMapper {

    User getUserById(String id);
}
