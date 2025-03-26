package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import com.example.online_shopping.service.dto.CartDTO;

public interface CartService {

	CartDTO save(CartDTO cartDTO);

	List<CartDTO> findAll();

	Optional<CartDTO> findOne(Long id);

	void delete(Long id);

}
