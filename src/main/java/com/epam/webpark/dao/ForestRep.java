package com.epam.webpark.dao;
import com.epam.webpark.entity.Tree;

public interface ForestRep extends BasicDAO<Tree> {

    void paintTree(long id, String color);


}
