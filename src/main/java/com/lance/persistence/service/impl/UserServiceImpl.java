package com.lance.persistence.service.impl;

import com.lance.persistence.mapper.UserMapper;
import com.lance.persistence.model.User;
import com.lance.persistence.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by perdonare on 2015/5/2.
 */
@Service
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }
    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
