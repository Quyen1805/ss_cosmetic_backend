package com.example.springbootblogrestapi.entity;

public class Ad_CategoryModel {
    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public int getCate_status() {
        return cate_status;
    }

    public void setCate_status(int cate_status) {
        this.cate_status = cate_status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    private int cate_id ;
    private String cate_name;
    private int cate_status;
    private String created_at;
    private String updated_at;
//    public CategoryModel(int cate_id, String cate_name,  int cate_status, String created_at, String updated_at) {
//        super();
//        this.cate_id = cate_id;
//        this.cate_name = cate_name;
//        this.cate_status = cate_status;
//        this.created_at = created_at;
//        this.updated_at = updated_at;
//    }
}
