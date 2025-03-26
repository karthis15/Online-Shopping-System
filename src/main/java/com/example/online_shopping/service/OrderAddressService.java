package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import com.example.online_shopping.service.dto.OrderAddressDTO;

public interface OrderAddressService {
	
	OrderAddressDTO save(OrderAddressDTO orderAddressDTO);

	List<OrderAddressDTO> findAll();

	Optional<OrderAddressDTO> findOne(Long id);

	void delete(Long id);

}
