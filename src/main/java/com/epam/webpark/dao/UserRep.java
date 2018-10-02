package com.epam.webpark.dao;
import com.epam.webpark.entity.User;

public interface UserRep extends BasicDAO<User> {

    User findByLogin(String login);


}
