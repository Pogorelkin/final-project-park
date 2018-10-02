package com.epam.webpark.service.impl;

import com.epam.webpark.entity.Request;
import com.epam.webpark.dao.impl.RequestDAOImpl;
import com.epam.webpark.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestDAOImpl requestDAO;

    @Override
    public List<Request> getAll() {
        return this.requestDAO.findAll();
    }

    @Override
    public void add(Request obj) {
        requestDAO.add(obj);

    }

    @Override
    public void deleteById(Long idObj) {
        requestDAO.deleteById(idObj);

    }

    @Override
    public void update(Long idObj, Request obj) {
        requestDAO.update(idObj,obj);

    }

    @Override
    public Request findById(Long idObj) {
        return this.requestDAO.findById(idObj);
    }

    @Override
    public void confirmRequest(Long id) {
        requestDAO.confirmRequest(id);

    }

    @Override
    public void workComplete(Long id) {
        requestDAO.confirmRequest(id);

    }



}


