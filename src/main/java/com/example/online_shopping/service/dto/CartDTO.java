package com.example.online_shopping.service.dto;

public class CartDTO {
	
	private Long id;

	private String user;

	private Long product;

	private Integer quantity;

	private Double totalPrice;
	
	private Double totalOrderPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(Double totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	@Override
	public String toString() {
		return "CartDTO [id=" + id + ", user=" + user + ", product=" + product + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", totalOrderPrice=" + totalOrderPrice + "]";
	}

	public CartDTO(Long id, String user, Long product, Integer quantity, Double totalPrice, Double totalOrderPrice) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.totalOrderPrice = totalOrderPrice;
	}
	
	

}
