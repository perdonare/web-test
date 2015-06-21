package com.lance.persistence.service.impl;

import com.lance.persistence.mapper.UserLeaveMapper;
import com.lance.persistence.model.UserLeavePO;
import com.lance.persistence.service.IUserLeaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by perdonare on 2015/6/21.
 */
@Service
public class UserLeaveServiceImpl implements IUserLeaveService {
    @Resource
    private UserLeaveMapper userLeaveMapper;
    @Override
    public List<UserLeavePO> getList(String name) {
        List<UserLeavePO> userLeavePOs =  userLeaveMapper.selectUserLeaveByName(name);
        if (userLeavePOs.size()>0) {
            return userLeavePOs;
        }else {
            return null;
        }

    }

    @Override
    public void deleteById(int id) {
        userLeaveMapper.deleteUserLeaveById(id);
    }

    @Override
    public void update(UserLeavePO userLeavePO) {
        userLeaveMapper.update(userLeavePO);
    }

    @Override
    public UserLeavePO getById(int id) {
        return userLeaveMapper.selectUserLeaveById(id);
    }

    @Override
    public void add(UserLeavePO userLeavePO){
        userLeaveMapper.insert(userLeavePO);
    }

}
