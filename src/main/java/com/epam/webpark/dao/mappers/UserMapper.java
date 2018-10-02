package com.epam.webpark.dao.mappers;
import com.epam.webpark.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User(
                resultSet.getString("firstName"),
                resultSet.getString("secondName"),
                resultSet.getInt("role"),
                resultSet.getString("login"),
                resultSet.getString("password"));
         user.setId(resultSet.getInt("id"));

         return user;

    }
}
