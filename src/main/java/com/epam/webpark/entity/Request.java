package com.epam.webpark.entity;


import java.io.Serializable;


public class Request implements Serializable {

    private long id;
    private String workKind;
    private String status;
    private long id_owner;
    private long id_forester;
    private long id_tree;

    public Request(String workKind, String status, long id_owner, long id_forester, long id_tree) {
        this.workKind = workKind;
        status = status;
        this.id_owner = id_owner;
        this.id_forester = id_forester;
        this.id_tree = id_tree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getId_owner() {
        return id_owner;
    }

    public void setId_owner(long id_owner) {
        this.id_owner = id_owner;
    }

    public long getId_forester() {
        return id_forester;
    }

    public void setId_forester(long id_forester) {
        this.id_forester = id_forester;
    }

    public long getId_tree() {
        return id_tree;
    }

    public void setId_tree(long id_tree) {
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
