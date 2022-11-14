package com.example.springbootblogrestapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springbootblogrestapi.entity.Ad_ProductModel;
import com.example.springbootblogrestapi.repository.Ad_ProductRepository;

@Repository
public class Ad_ProductService implements Ad_ProductRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Ad_ProductModel model) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"INSERT INTO Product (pr_name, category_id, brand_id, pr_description, price, hot, image, quanity,status,created_at, updated_at)  VALUES(?,?,?,?,?,?,?,?,?,?,?)",
				new Object[] { model.getPr_name(), model.getCategory_id(), model.getBrand_id(),
						model.getPr_description(), model.getPrice(), model.getHot(), model.getImage(),
						model.getQuanity(), model.getStatus(), model.getCreated_at(), model.getUpdated_at() });
	}

	@Override
	public int update(Ad_ProductModel model) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"UPDATE Product SET pr_name=?, category_id=?, brand_id=?, pr_description=?, price=?, hot=?, image=?, quanity=?,status=?,created_at=?, updated_at=? WHERE pr_id=?",
				new Object[] { model.getPr_name(), model.getCategory_id(), model.getBrand_id(),
						model.getPr_description(), model.getPrice(), model.getHot(), model.getImage(),
						model.getQuanity(), model.getStatus(), model.getCreated_at(), model.getUpdated_at(),
						model.getPr_id() });
	}

	@Override
	public List<Ad_ProductModel> findByName(String condition) {
		// TODO Auto-generated method stub
		String sql = "SELECT*FROM Product";
		List<Ad_ProductModel> listProduct = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Ad_ProductModel.class));
		List<Ad_ProductModel> list = new ArrayList<>();
		for (Ad_ProductModel product : listProduct) {
			if (product.getPr_name().contains(condition)) {
				list.add(product);
			}
		}
		return list;
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<Ad_ProductModel> findById(int pr_id) {
		
			String sql = "SELECT *FROM Product WHERE pr_id=?";
			Object[]args= {pr_id};
			List<Ad_ProductModel> listProduct = new ArrayList<Ad_ProductModel>();
			listProduct = jdbcTemplate.query(sql,args,BeanPropertyRowMapper.newInstance(Ad_ProductModel.class));
			return listProduct;
	
	}

	@Override
	public int deleteById(int pr_id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM Product WHERE pr_id=?", pr_id);

	}

	@Override
	public List<Ad_ProductModel> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from Product", BeanPropertyRowMapper.newInstance(Ad_ProductModel.class));

	}

	@Override
	public Ad_ProductModel getProductById(int pr_id) {
		String sql = "SELECT * FROM Product WHERE pr_id= ?";
		Object[] args = { pr_id };
		Ad_ProductModel product = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Ad_ProductModel.class));
		return product;
	}

	@Override
	public List<Ad_ProductModel> getListProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
