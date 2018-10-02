package com.epam.webpark.service;

import com.epam.webpark.entity.Request;

public interface RequestService extends BasicService<Request> {

    void confirmRequest(Long id);

    void workComplete(Long id);

}
