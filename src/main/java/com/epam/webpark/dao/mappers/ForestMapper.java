package com.epam.webpark.dao.mappers;

import com.epam.webpark.entity.Tree;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ForestMapper implements RowMapper<Tree> {
    @Override
    public Tree mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Tree tree = new Tree(
                resultSet.getString("treeKind"),
                resultSet.getString("color"),
                resultSet.getLong("status"));
        tree.setId(resultSet.getLong("id"));
        return tree;

    }
}
