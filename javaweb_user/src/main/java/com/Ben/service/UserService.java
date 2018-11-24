package com.Ben.service;

import com.Ben.dao.UserDao;
import com.Ben.domain.User;

public class UserService {
    public void add(User user) {
        new UserDao().add(user);
    }
}
