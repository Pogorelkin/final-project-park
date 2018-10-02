package com.epam.webpark.service;


import com.epam.webpark.entity.User;

public interface UserManager {
    void setUser(User user);

    User getUser();
}