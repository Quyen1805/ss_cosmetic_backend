package com.example.springbootblogrestapi.entity;

public class Ad_ProductModel {
	private int pr_id ;
	private String pr_name;
	private int category_id;
	private int brand_id;
	private String pr_description;
	private float price;
	private int hot;
	private String image;
	private int quanity;
	private int status;
	private String created_at;
	private String updated_at;
	public int getPr_id() {
		return pr_id;
	}
	public void setPr_id(int pr_id) {
		this.pr_id = pr_id;
	}
	public String getPr_name() {
		return pr_name;
	}
	public void setPr_name(String pr_name) {
		this.pr_name = pr_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public Ad_ProductModel(int pr_id, String pr_name, int category_id, int brand_id, String pr_description, float price,
						   int hot, String image, int quanity, int status, String created_at, String updated_at) {
		super();
		this.pr_id = pr_id;
		this.pr_name = pr_name;
		this.category_id = category_id;
		this.brand_id = brand_id;
		this.pr_description = pr_description;
		this.price = price;
		this.hot = hot;
		this.image = image;
		this.quanity = quanity;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Ad_ProductModel() {
		
	}
	
	public Ad_ProductModel(String pr_name2, int category_id2, int brand_id2, String pr_description2, float price2,
						   int hot2, String image2, int quanity2, int status2, int status3, String created_at2, String updated_at2) {
		// TODO Auto-generated constructor stub
		this.pr_name = pr_name2;
		this.category_id = category_id2;
		this.brand_id = brand_id2;
		this.pr_description = pr_description2;
		this.price = price2;
		this.hot = hot2;
		this.image = image2;
		this.quanity = quanity2;
		this.status = status2;
		this.created_at = created_at2;
		this.updated_at = updated_at2;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getPr_description() {
		return pr_description;
	}
	public void setPr_description(String pr_description) {
		this.pr_description = pr_description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
}
