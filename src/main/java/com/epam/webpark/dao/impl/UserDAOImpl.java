package com.epam.webpark.dao.impl;

import com.epam.webpark.entity.User;
import com.epam.webpark.dao.UserRep;
import com.epam.webpark.dao.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
@Qualifier("usersRepository")
public class UserDAOImpl implements UserRep {
@Autowired
private JdbcTemplate jdbcTemplate;



    @Override
    public User findByLogin(String login) {
        return jdbcTemplate.queryForObject("SELECT * FROM Accounts WHERE login = ?", new Object[]{login}, new UserMapper());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM Accounts", new UserMapper());
    }

    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Accounts WHERE id = ?", new Object[]{id}, new UserMapper());
    }

    @Override
    public long add(User user) {
        return jdbcTemplate.update("INSERT INTO Accounts(firstName, secondName, role, login, password) VALUES (?,?,?,?,?)",
                user.getFirstName(), user.getSecondName(), user.isOwner(), user.getLogin(), user.getPassword());
    }

    @Override
    public long update(long id, User entity) {
        return jdbcTemplate.update("UPDATE Accounts SET firstName = ?, secondName = ?, role = ?, login = ?, password = ? WHERE id = ?",
                entity.getFirstName(), entity.getSecondName(), entity.isOwner(), entity.getLogin(), entity.getPassword(), id);
    }

    @Override
    public long deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM Accounts WHERE id = ?", id);
    }
}
