package com.example.springbootblogrestapi.services;

import com.example.springbootblogrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> DelUser(Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            userRepository.deleteById(id);
            response.put("Xóa thành công", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("Xóa thất bại", false);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
}

//@DeleteMapping("/delete_pro/{pr_id}")
//public ResponseEntity<String> deleteuser(@PathVariable("pr_id") String pr_id) {
//	ResponseEntity<String> msg =null;
//    try {
//    	int result = UserRepository.deleteById(Integer.parseInt(pr_id));
//		if (result == 0) {
//			msg = new ResponseEntity<>("Không thể tìm thấy id=" + pr_id,HttpStatus.NOT_FOUND);
//		}else {
//			msg = new ResponseEntity<>("Xóa thành công.", HttpStatus.OK);
//		}
//    } 
//    catch(NumberFormatException e){
//        msg = new ResponseEntity<>("id nhap vao phai la mot so", HttpStatus.BAD_REQUEST);
//    }
//    catch (Exception e) {
//	msg = new ResponseEntity<>("Không có id = " + pr_id, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//	return msg;