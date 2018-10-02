package com.epam.webpark.dao.mappers;
import com.epam.webpark.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
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
