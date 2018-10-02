package com.epam.webpark.entity;


import java.io.Serializable;


public class Request implements Serializable {

    private int id;
    private String workKind;
    private String status;
    private int id_owner;
    private int id_forester;
    private int id_tree;

    public Request(String workKind, String status, int id_owner, int id_forester, int id_tree) {
        this.workKind = workKind;
        status = status;
        this.id_owner = id_owner;
        this.id_forester = id_forester;
        this.id_tree = id_tree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkKind() {
        return workKind;
    }

    public void setWorkKind(String workKind) {
        this.workKind = workKind;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

    public int getId_owner() {
        return id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }

    public int getId_forester() {
        return id_forester;
    }

    public void setId_forester(int id_forester) {
        this.id_forester = id_forester;
    }

    public int getId_tree() {
        return id_tree;
    }

    public void setId_tree(int id_tree) {
        this.id_tree = id_tree;
    }

    @Override
    public String toString() {
        return "Request{" +
                "workKind='" + workKind + '\'' +
                ", Status='" + status+ '\'' +
                ", id_owner=" + id_owner +
                ", id_forester=" + id_forester +
                ", id_tree=" + id_tree +
                '}';
    }
}
