package com.epam.webpark.dao.mappers;

import com.epam.webpark.entity.Request;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper implements RowMapper<Request> {

    @Override
    public Request mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Request request = new Request(
                resultSet.getString("work_kind"),
                resultSet.getString("status"),
                resultSet.getInt("id_owner"),
                resultSet.getInt("id_forester"),
                resultSet.getInt("tree_id"));
        request.setId(resultSet.getInt("id"));

        return request;

    }
}
