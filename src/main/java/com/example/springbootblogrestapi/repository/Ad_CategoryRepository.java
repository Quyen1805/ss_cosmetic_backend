package com.example.springbootblogrestapi.repository;

import java.util.List;

import com.example.springbootblogrestapi.entity.Ad_CategoryModel;

public interface Ad_CategoryRepository {
    int create(Ad_CategoryModel model);
    int update(Ad_CategoryModel model);
    int deleteById(int cate_id);
    List<Ad_CategoryModel> getALL();

    Ad_CategoryModel getCategoryById(int cate_id);


}
