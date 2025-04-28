package com.example.online_shopping.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "product")
public class Product extends AbstractAuditingEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "category")
	private String category;

	@Column(name = "price")
	private Double price;

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "image")
	private String image;

	@Column(name = "discount")
	private Integer discount;
	
	@Column(name = "discountPrice")
	private Double discountPrice;
	
	@Column(name = "isActive")
	private Boolean isActive;
	
	@Column(name = "purchaseCount")
	private Integer purchaseCount = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getPurchaseCount() {
		return purchaseCount;
	}

	public void setPurchaseCount(Integer purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", stock=" + stock + ", image=" + image + ", discount=" + discount
				+ ", discountPrice=" + discountPrice + ", isActive=" + isActive + ", purchaseCount=" + purchaseCount
				+ "]";
	}

	public Product(Long id, String title, String description, String category, Double price, Integer stock,
			String image, Integer discount, Double discountPrice, Boolean isActive, Integer purchaseCount) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.discount = discount;
		this.discountPrice = discountPrice;
		this.isActive = isActive;
		this.purchaseCount = purchaseCount;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
