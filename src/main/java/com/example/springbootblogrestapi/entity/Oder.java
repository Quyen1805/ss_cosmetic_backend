package com.example.springbootblogrestapi.entity;

import lombok.Data;

import javax.persistence.*;

import java.sql.Date;


@Data
@Entity

public class Oder {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long od_id;
	    private String tenkh;
	    private String sdt;
	    private String diachi;
	    private String ngaydat;
		public long getOd_id() {
			return od_id;
		}
		public void setOd_id(long od_id) {
			this.od_id = od_id;
		}
		public String getTenkh() {
			return tenkh;
		}
		public void setTenkh(String tenkh) {
			this.tenkh = tenkh;
		}
		public String getSdt() {
			return sdt;
		}
		public void setSdt(String sdt) {
			this.sdt = sdt;
		}
		public String getDiachi() {
			return diachi;
		}
		public void setDiachi(String diachi) {
			this.diachi = diachi;
		}
		public String getNgaydat() {
			return ngaydat;
		}
		public void setNgaydat(String ngaydat) {
			this.ngaydat = ngaydat;
		}
	    
}
