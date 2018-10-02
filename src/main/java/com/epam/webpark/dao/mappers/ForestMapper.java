package com.epam.webpark.dao.mappers;

import com.epam.webpark.entity.Tree;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ForestMapper implements RowMapper<Tree> {
    @Override
    public Tree mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Tree tree = new Tree(
                resultSet.getString("treeKind"),
                resultSet.getString("color"),
                resultSet.getInt("status"));
        tree.setId(resultSet.getInt("id"));
        return tree;

    }
}
