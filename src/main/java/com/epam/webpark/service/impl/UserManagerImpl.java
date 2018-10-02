package com.epam.webpark.service.impl;

import com.epam.webpark.entity.User;
import com.epam.webpark.service.UserManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {

    private User user;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}

