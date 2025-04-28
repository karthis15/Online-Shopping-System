package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import com.example.online_shopping.domain.Cart;
import com.example.online_shopping.service.dto.CartDTO;

public interface CartService {

	CartDTO save(CartDTO cartDTO);

	List<CartDTO> findAll();

	Optional<CartDTO> findOne(Long id);

	void delete(Long id);

	Integer getCountCart(String id);

	List<Cart> getCartsByUser(String id);

	void updateQuantity(String sy, Long cid);

	Cart saveCart(Long productId, String userId);

}
