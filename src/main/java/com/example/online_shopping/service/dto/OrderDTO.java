package com.example.online_shopping.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class OrderDTO {

	private Long id;

	private Long productId;

	private String userId;

	private Double price;

	private Integer quantity;

	private String status;

	private String paymentType;

	private Long orderAddressId;

}
