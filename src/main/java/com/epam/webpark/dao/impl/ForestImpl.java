package com.epam.webpark.dao.impl;

import com.epam.webpark.entity.Tree;
import com.epam.webpark.dao.ForestRep;
import com.epam.webpark.dao.mappers.ForestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ForestImpl implements ForestRep {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Tree> findAll() {
        return jdbcTemplate.query("SELECT * FROM Forest", new ForestMapper());
    }

    @Override
    public Tree findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Forest WHERE id = ?", new Object[]{id}, new ForestMapper());
    }

    @Override
    public long add(Tree entity) {
        return jdbcTemplate.update("INSERT INTO Forest(tree_kind, color, status) VALUES (?,?,?)",
                entity.getColor(), entity.getTreeKind(), entity.isHealthy());
    }

    @Override
    public long update(long id, Tree entity) {
        return jdbcTemplate.update("UPDATE Forest SET tree_kind = ?, color = ?, status = ? WHERE id = ?",
                entity.getTreeKind(), entity.getColor(), entity.isHealthy(), id);
    }

    @Override
    public long deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM Forest WHERE id = ?", id);
    }

    @Override
    public void paintTree(long id, String color) {
        jdbcTemplate.update("UPDATE Forest SET color = ?, WHERE id = ?", color, id);


    }
}
