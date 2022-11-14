package com.example.springbootblogrestapi.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springbootblogrestapi.entity.Ad_CategoryModel;
import com.example.springbootblogrestapi.repository.Ad_CategoryRepository;

@Repository
public class Ad_CategoryService implements Ad_CategoryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Ad_CategoryModel model) {
        // TODO Auto-generated method stub
        return jdbcTemplate.update("INSERT INTO Category (cate_name, cate_status, created_at, updated_at)  VALUES(?,?,?,?)",
                new Object[] { model.getCate_name(), model.getCate_status(), model.getCreated_at(), model.getUpdated_at()});
    }

    @Override
    public int update(Ad_CategoryModel model) {
        // TODO Auto-generated method stub
        return jdbcTemplate.update("UPDATE Category SET cate_name=?, cate_status=?, created_at=?, updated_at=? WHERE cate_id=?",
                new Object[] { model.getCate_name(), model.getCate_status(), model.getCreated_at(), model.getUpdated_at(), model.getCate_id() });
    }

    @Override
    public int deleteById(int cate_id) {
        // TODO Auto-generated method stub
        return jdbcTemplate.update("DELETE FROM Category WHERE cate_id=?", cate_id);

    }

    @Override
    public List<Ad_CategoryModel> getALL() {
        return jdbcTemplate.query("SELECT * from Category", BeanPropertyRowMapper.newInstance(Ad_CategoryModel.class));
    }

    @Override
    public Ad_CategoryModel getCategoryById(int cate_id) {
        String sql="SELECT * FROM Category WHERE cate_id= ?";
        Object[] args= {cate_id};
        Ad_CategoryModel category= jdbcTemplate.queryForObject(sql,args,BeanPropertyRowMapper.newInstance(Ad_CategoryModel.class));
        return category;
    }

}
