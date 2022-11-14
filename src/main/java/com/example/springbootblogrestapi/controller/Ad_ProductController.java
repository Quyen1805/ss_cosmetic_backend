package com.example.springbootblogrestapi.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootblogrestapi.entity.Ad_ProductModel;
import com.example.springbootblogrestapi.repository.Ad_ProductRepository;

@RestController
@RequestMapping("/webss")
public class Ad_ProductController<product> {
	@Autowired
	Ad_ProductRepository productRepository;
	private Object product;
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<?> getAll(){
		List<Ad_ProductModel> listProduct = productRepository.getAll();
		return ResponseEntity.ok(listProduct);
	}public Ad_ProductController() {
		// TODO Auto-generated constructor stub
	}
	
	
//	public ResponseEntity<List<ProductModel>> getAll(@RequestParam(required = false) String pr_name) {
//		List<ProductModel> x = new ArrayList<ProductModel>();
//		try {
//			if (pr_name == null)
//				productRepository.getAll().forEach(x::add);
//			else
//				productRepository.findByName(pr_name).forEach(x::add);
//
//			if (x.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//
//			return new ResponseEntity<>(x, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	@PostMapping("/create_pr")
	public ResponseEntity<String> createproduct(@RequestBody Ad_ProductModel model) {
		try {
			productRepository.create(model);
			return new ResponseEntity<>("Thêm mới thành công", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete_pro/{pr_id}")
	public ResponseEntity<String> deleteproduct(@PathVariable("pr_id") String pr_id) {
		ResponseEntity<String> msg =null;
        try {
        	int result = productRepository.deleteById(Integer.parseInt(pr_id));
			if (result == 0) {
				msg = new ResponseEntity<>("Không thể tìm thấy id=" + pr_id,HttpStatus.NOT_FOUND);
			}else {
				msg = new ResponseEntity<>("Xóa thành công.", HttpStatus.OK);
			}
        } 
        catch(NumberFormatException e){
            msg = new ResponseEntity<>("id nhap vao phai la mot so", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
		msg = new ResponseEntity<>("Không có id = " + pr_id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		return msg;
	}
	//sửa item follow id
	 @PutMapping("/edit_pro/{pr_id}")
	  public ResponseEntity<?> update(@PathVariable("pr_id") int pr_id, @RequestBody Ad_ProductModel product) {
		
		 try {
			 Ad_ProductModel pro = productRepository.getProductById(pr_id);
			 if (pro != null) {
			    	pro.setPr_id(pr_id);
			    	pro.setPr_name(product.getPr_name());
			    	pro.setCategory_id(product.getCategory_id());
			    	pro.setBrand_id(product.getBrand_id());
			    	pro.setPr_description(product.getPr_description());
			    	pro.setPrice(product.getPrice());
			    	pro.setHot(product.getHot());
			    	pro.setImage(product.getImage());
			    	pro.setQuanity(product.getQuanity());
			    	pro.setStatus(product.getStatus());
			    	pro.setCreated_at(product.getCreated_at());
			    	pro.setUpdated_at(product.getUpdated_at());
			    	
			    	productRepository.update(pro);
			      return new ResponseEntity<>("Product was updated successfully.", HttpStatus.OK);
			    } else {
			      return new ResponseEntity<>("product find Tutorial with id=" + pr_id, HttpStatus.NOT_FOUND);
			    }
			} catch (Exception e) {
				return new ResponseEntity<>("Không thể tìm thấy id = " + pr_id, HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
	  }
		
	 @GetMapping("/search_pro/{pr_id}")
	 public ResponseEntity<?> findById(@PathVariable("pr_id") String pr_id) {
		 try{
		    	
		    	List<Ad_ProductModel> product = productRepository.findById(Integer.parseInt(pr_id));

		    	if (product.size() != 0) {
		    		return new ResponseEntity<>(product, HttpStatus.OK);
			    }else
			    {
			    	return new ResponseEntity<>("Cannot find Product with id = " + pr_id, HttpStatus.NOT_FOUND);
			    	}
		      }
		 catch(NumberFormatException e) {
		    	  return new ResponseEntity<>("ID hợp lệ phải là một số " , HttpStatus.NOT_FOUND);
		       }
		}
	
		
	 @GetMapping("/findbyname")
	 public ResponseEntity<?> searchProduct(@RequestParam(name="condition", required=false, defaultValue="")String pr_name){
		 ResponseEntity<String> msg =null;
			try {
				List<Ad_ProductModel> list= productRepository.findByName(pr_name);
				if (list.isEmpty()) {
					msg = new ResponseEntity<>("Không thể tìm thấy san pham co ten =" + pr_name,HttpStatus.NOT_FOUND);
//					return new ResponseEntity<String>("No content" , HttpStatus.NO_CONTENT);
				}
				else {

					return new ResponseEntity<>(list, HttpStatus.OK);
				}
			
			} catch (Exception e) {
				msg= new ResponseEntity<>("Không thể tìm thấy san pham co ten = " + pr_name, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return msg;
	 }
}


