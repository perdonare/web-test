package com.lance.persistence.service;

import com.lance.persistence.model.User;

/**
 * Created by perdonare on 2015/5/2.
 */
public interface IUserService {
    public User getUser(Long id);
    public void addUser(User user);
}
