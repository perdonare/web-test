package com.lance.persistence.service;

import com.lance.persistence.model.UserLeavePO;

import java.util.List;

/**
 * Created by perdonare on 2015/6/21.
 */
public interface IUserLeaveService {

    public List<UserLeavePO> getList(String name);

    public void deleteById(int id);

    void update(UserLeavePO userLeavePO);

    public UserLeavePO getById(int id);

    void add(UserLeavePO userLeavePO);
}
