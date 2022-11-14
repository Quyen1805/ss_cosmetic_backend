package com.example.springbootblogrestapi.repository;

import java.util.List;

import com.example.springbootblogrestapi.entity.Ad_ProductModel;


public interface Ad_ProductRepository {
	int create(Ad_ProductModel model);
	int update(Ad_ProductModel model);
	List<Ad_ProductModel> findByName(String condition);
	public List<Ad_ProductModel> findById(int pr_id);
	int deleteById(int pr_id);
	List<Ad_ProductModel> getAll();
	List<Ad_ProductModel> getListProduct();
	public Ad_ProductModel getProductById(int pr_id);
}
