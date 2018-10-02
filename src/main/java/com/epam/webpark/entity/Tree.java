package com.epam.webpark.entity;

import java.io.Serializable;

public class Tree implements Serializable {

    private long id;
    private String treeKind;
    private String color = "default";
    private long status = 1; // 0=sick, 1=healthy, -1 = dead;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTreeKind() {
        return treeKind;
    }

    public void setTreeKind(String treeKind) {
        this.treeKind = treeKind;
    }

    public Tree(String treeKind, String color, long status) {
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

    public long isHealthy() {
        return status;
    }

    public void setStatus(long status) {
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
