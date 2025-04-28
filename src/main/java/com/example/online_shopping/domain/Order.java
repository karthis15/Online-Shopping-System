package com.example.online_shopping.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends AbstractAuditingEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "order_id")
	private String orderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name="price")
	private Double price;

	@Column(name="quantity")
	private Integer quantity;

	@Column(name="status")
	private String status;

	@Column(name="payment_type")
	private String paymentType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderAddress_id")
	private OrderAddress orderAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public OrderAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrderAddress orderAddress) {
		this.orderAddress = orderAddress;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", user=" + user + ", price=" + price + ", quantity="
				+ quantity + ", status=" + status + ", paymentType=" + paymentType + ", orderAddress=" + orderAddress
				+ "]";
	}

	public Order(Long id, Product product, User user, Double price, Integer quantity, String status, String paymentType,
			OrderAddress orderAddress) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.paymentType = paymentType;
		this.orderAddress = orderAddress;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
