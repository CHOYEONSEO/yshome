package com.portfolio.yshome.domain;

public class ProductDTO {

	private String name;
	private double price;
	
	public ProductDTO() {
	}

	public ProductDTO(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	//DTO에 들어 오는 실제 값을 편리하게 확인할 수  있다
	//ProductDTO.toString 으로 호출
	@Override
	public String toString() {
		return "ProductDTO <br>[name = " + name + ",<br> price = " + price + "]";
	}
}
