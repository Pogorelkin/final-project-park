package com.epam.webpark.service.impl;

import com.epam.webpark.entity.Tree;
import com.epam.webpark.dao.impl.ForestImpl;

import com.epam.webpark.service.ForestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("usersService")
public class ForestServiceImpl implements ForestService {

    @Autowired
    private ForestImpl forestDAO;


    @Override
    public List<Tree> getAll() {
        return this.forestDAO.findAll();
    }

    @Override
    public void add(Tree obj) {
        forestDAO.add(obj);

    }

    @Override
    public void deleteById(Long idObj) {
        forestDAO.deleteById(idObj);

    }

    @Override
    public void update(Long idObj, Tree obj) {
        forestDAO.update(idObj,obj);

    }

    @Override
    public Tree findById(Long idObj) {
        return this.forestDAO.findById(idObj);
    }
}
