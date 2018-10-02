package com.epam.webpark.service.impl;

import com.epam.webpark.dao.impl.UserDAOImpl;
import com.epam.webpark.service.UserServise;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.epam.webpark.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServise {
    @Autowired
    private UserDAOImpl userDAO;

    @Override
    public List<User> getAll() {
        return this.userDAO.findAll();
    }

    @Override
    public void add(User obj) {
        userDAO.add(obj);

    }

    @Override
    public void deleteById(Long idObj) {
        userDAO.deleteById(idObj);

    }

    @Override
    public void update(Long idObj, User obj) {
        userDAO.update(idObj, obj);

    }

    @Override
    public User findById(Long idObj) {
        return this.userDAO.findById(idObj);
    }

    @Override
    public User findUserByLogin(String login) {
        return this.userDAO.findByLogin(login);
    }

    @Override
    public User logPassValidAndReturnUser(String login, String password) {
        User user = userDAO.findByLogin(login);
        if (user != null && user.getPassword() == password) {
            return user;

        } else {
            return null;
        }

    }
}
