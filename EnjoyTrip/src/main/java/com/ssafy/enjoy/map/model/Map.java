package com.ssafy.enjoy.map.model;

public class Map {
	private int sido_code;
	private String sido_name;
	private int gugun_code;
	private String gugun_name;
	private int content_type_Id;
	private String title;
	private String first_image;
	private String addr1;
	private String addr2;
	private int zipcode;
	private int tel;
	@Override
	public String toString() {
		return "Map [sido_code=" + sido_code + ", sido_name=" + sido_name + ", gugun_code=" + gugun_code
				+ ", gugun_name=" + gugun_name + ", content_type_Id=" + content_type_Id + ", title=" + title
				+ ", first_image=" + first_image + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode
				+ ", tel=" + tel + "]";
	}
	public int getSido_code() {
		return sido_code;
	}
	public void setSido_code(int sido_code) {
		this.sido_code = sido_code;
	}
	public String getSido_name() {
		return sido_name;
	}
	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}
	public int getGugun_code() {
		return gugun_code;
	}
	public void setGugun_code(int gugun_code) {
		this.gugun_code = gugun_code;
	}
	public String getGugun_name() {
		return gugun_name;
	}
	public void setGugun_name(String gugun_name) {
		this.gugun_name = gugun_name;
	}
	public int getContent_type_Id() {
		return content_type_Id;
	}
	public void setContent_type_Id(int content_type_Id) {
		this.content_type_Id = content_type_Id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst_image() {
		return first_image;
	}
	public void setFirst_image(String first_image) {
		this.first_image = first_image;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
}
