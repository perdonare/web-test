package com.lance.persistence.mapper;

import com.lance.persistence.model.User;

import java.util.List;

public interface UserMapper {
    List<User> queryUsers();
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}