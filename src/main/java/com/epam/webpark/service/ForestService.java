package com.epam.webpark.service;

import com.epam.webpark.entity.Tree;

public interface ForestService extends BasicService<Tree> {
    void paintTree(long id, String color);
}
