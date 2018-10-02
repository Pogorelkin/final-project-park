package com.epam.webpark.dao;

import com.epam.webpark.entity.Request;

public interface RequestRep extends BasicDAO<Request> {
    long confirmRequest(long id);

    long workComplete(long id);

}
