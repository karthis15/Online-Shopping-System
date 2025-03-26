package com.example.online_shopping.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.domain.Cart;
import com.example.online_shopping.repository.CartRepository;
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

}
