package com.example.online_shopping.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.online_shopping.domain.Cart;
import com.example.online_shopping.domain.Product;
import com.example.online_shopping.domain.User;
import com.example.online_shopping.repository.CartRepository;
import com.example.online_shopping.repository.ProductRepository;
import com.example.online_shopping.repository.UserRepository;
import com.example.online_shopping.service.CartService;
import com.example.online_shopping.service.dto.CartDTO;
import com.example.online_shopping.service.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService  {

	private final Logger log = LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartMapper cartMapper;
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public CartDTO save(CartDTO cartDTO) {
		log.debug("Request to save Cart : {}", cartDTO);
		Cart cart = cartMapper.toEntity(cartDTO);
		cart = cartRepository.save(cart);
		CartDTO result = cartMapper.toDto(cart);
		return result;
	}

	@Override
	public List<CartDTO> findAll() {
		log.debug("Request to get all Carts");
		return cartRepository.findAll().stream().map(cartMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Optional<CartDTO> findOne(Long id) {
		log.debug("Request to get TCart : {}", id);
		return cartRepository.findById(id).map(cartMapper::toDto);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete Cart : {}", id);
		cartRepository.deleteById(id);
	}

	@Override
	public Integer getCountCart(String userId) {
		
		Integer countByUserId = cartRepository.countByUserId(userId);
		return countByUserId;
	}
	

	@Override
	public Cart saveCart(Long productId, String userId) {
		User userDtls = userRepository.findById(userId).get();
		Product product = productRepository.findById(productId).get();

		Cart cartStatus = cartRepository.findByProductIdAndUserId(productId, userId);

		Cart cart = null;

		if (ObjectUtils.isEmpty(cartStatus)) {
			cart = new Cart();
			cart.setProduct(product);
			cart.setUser(userDtls);
			cart.setQuantity(1);
			cart.setTotalPrice(1 * product.getDiscountPrice());
		} else {
			cart = cartStatus;
			cart.setQuantity(cart.getQuantity() + 1);
			cart.setTotalPrice(cart.getQuantity() * cart.getProduct().getDiscountPrice());
		}
		Cart saveCart = cartRepository.save(cart);

		return saveCart;
	}

	@Override
	public List<Cart> getCartsByUser(String userId) {
		List<Cart> carts = cartRepository.findByUserId(userId);

		Double totalOrderPrice = 0.0;
		List<Cart> updateCarts = new ArrayList<>();
		for (Cart c : carts) {
			Double totalPrice = (c.getProduct().getDiscountPrice() * c.getQuantity());
			c.setTotalPrice(totalPrice);
			totalOrderPrice = totalOrderPrice + totalPrice;
			c.setTotalOrderPrice(totalOrderPrice);
			updateCarts.add(c);
		}

		return updateCarts;
	}

	@Override
	public void updateQuantity(String sy, Long cid) {
		Cart cart = cartRepository.findById(cid).get();
		int updateQuantity;

		if (sy.equalsIgnoreCase("de")) {
			updateQuantity = cart.getQuantity() - 1;

			if (updateQuantity <= 0) {
				cartRepository.delete(cart);
			} else {
				cart.setQuantity(updateQuantity);
				cartRepository.save(cart);
			}

		} else {
			updateQuantity = cart.getQuantity() + 1;
			cart.setQuantity(updateQuantity);
			cartRepository.save(cart);
		}

		
	}

}
