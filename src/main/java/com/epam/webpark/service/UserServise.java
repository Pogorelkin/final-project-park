package com.epam.webpark.service;

import com.epam.webpark.entity.User;

public interface UserServise extends BasicService<User> {

    User findUserByLogin(String login);
    User logPassValidAndReturnUser(String lgn, String pwd);
}
