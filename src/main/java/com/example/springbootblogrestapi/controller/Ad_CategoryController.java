package com.example.springbootblogrestapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootblogrestapi.entity.Ad_CategoryModel;
import com.example.springbootblogrestapi.repository.Ad_CategoryRepository;

@RestController
@RequestMapping("/webss")
public class Ad_CategoryController {
    @Autowired
    Ad_CategoryRepository categoryRepository;
    @GetMapping("/api")
    public ResponseEntity<?> getListCategory(){
        List<Ad_CategoryModel> listCategorys = categoryRepository.getALL();
        return ResponseEntity.ok(listCategorys);
    }
    @PostMapping("/create_cate")
    public ResponseEntity<String> createcategory(@RequestBody Ad_CategoryModel model) {
        try {
            categoryRepository.create(model);
            return new ResponseEntity<>("Thêm mới thành công", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{cate_id}")
    public ResponseEntity<String> deletecategory(@PathVariable("cate_id") String cate_id) {
        ResponseEntity<String> msg = null;
        try {
            int result = categoryRepository.deleteById(Integer.parseInt(cate_id));
            if (result == 0) {
                msg = new ResponseEntity<>("Không thể tìm thấy id=" + cate_id, HttpStatus.NOT_FOUND);
            }else {
                msg = new ResponseEntity<>("Xóa thành công.", HttpStatus.OK);
            }

        } catch (NumberFormatException e) {
            msg = new ResponseEntity<>("ID nhap vao khong phai la so", HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            msg = new ResponseEntity<>("Không có id = " + cate_id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return msg;
    }
    //sửa item follow id
    @PutMapping("/edit/{cate_id}")
    public ResponseEntity<?> update(@PathVariable("cate_id") int cate_id, @RequestBody Ad_CategoryModel category) {
        try {
            Ad_CategoryModel cate = categoryRepository.getCategoryById(cate_id);
            if (cate != null) {
                cate.setCate_id(cate_id);
                cate.setCate_name(category.getCate_name());
                cate.setCate_status(category.getCate_status());
                cate.setCreated_at(category.getCreated_at());
                cate.setUpdated_at(category.getUpdated_at());

                categoryRepository.update(cate);
                return new ResponseEntity<>("Category was updated successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Category find Tutorial with id=" + cate_id, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Khong the tim thay id = " +cate_id,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
