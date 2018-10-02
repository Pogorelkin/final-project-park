package com.epam.webpark.dao.impl;

import com.epam.webpark.entity.Request;
import com.epam.webpark.dao.RequestRep;
import com.epam.webpark.dao.mappers.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestDAOImpl implements RequestRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Request> findAll() {
        return jdbcTemplate.query("SELECT * FROM Requests", new RequestMapper());
    }

    @Override
    public Request findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Requests WHERE id = ?", new Object[]{id}, new RequestMapper());
    }

    @Override
    public long add(Request entity) {
        return jdbcTemplate.update("INSERT INTO Requests(work_kind, id_owner, id_forester, status, tree_id) VALUES (?,?,?,?,?)", entity.getWorkKind(), entity.getId_owner(), entity.getId_forester(), "undone", entity.getId_tree());
    }

    @Override
    public long update(long id, Request entity) {
        return jdbcTemplate.update("UPDATE Requests SET work_kind = ?, id_owner= ?, id_forester = ?, status= ?, tree_id = ? WHERE id = ?",
                entity.getWorkKind(), entity.getId_owner(), entity.getId_forester(), entity.getStatus(), entity.getId_tree(), id);

    }

    @Override
    public long deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM Requests WHERE id = ?", id);
    }

    @Override
    public long confirmRequest(long id) {
        return jdbcTemplate.update("UPDATE Requests SET status = ? WHERE id = ?", "checked", id);

    }
    @Override
    public long workComplete(long id) {
        return jdbcTemplate.update("UPDATE Requests SET status = ? WHERE id = ?", "complete", id);
    }



}
