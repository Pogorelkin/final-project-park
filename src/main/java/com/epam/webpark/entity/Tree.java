package com.epam.webpark.entity;

import java.io.Serializable;

public class Tree implements Serializable {

    private int id;
    private String treeKind;
    private String color = "default";
    private int status = 1; // 0=sick, 1=healthy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTreeKind() {
        return treeKind;
    }

    public void setTreeKind(String treeKind) {
        this.treeKind = treeKind;
    }

    public Tree(String treeKind, String color, int status) {
        this.treeKind = treeKind;
        this.color = color;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int isHealthy() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Tree(String treeKind) {
        this.treeKind = treeKind;

    }

    @Override
    public String toString() {
        return "Tree{" +
                "treeKind='" + treeKind + '\'' +
                ", color='" + color + '\'' +
                ", status=" + status +
                '}';
    }
}
