package com.lance.persistence.mapper;

import com.lance.persistence.model.UserLeavePO;

import java.util.List;

public interface UserLeaveMapper {
    int insert(UserLeavePO record);

    List<UserLeavePO> selectUserLeaveByName(String name);

    UserLeavePO selectUserLeaveById(int id);

    void deleteUserLeaveById(int id);

    void update(UserLeavePO userLeavePO);
}