package com.example.online_shopping.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_shopping.service.CartService;
import com.example.online_shopping.service.dto.CartDTO;

@RestController
@RequestMapping("/api")
public class CartResource {

	private final Logger log = LoggerFactory.getLogger(CartResource.class);

	@Autowired
	CartService cartService;

	@PostMapping("/cart")
	public CartDTO createCart(@RequestBody CartDTO cartDTO) {
		log.debug("REST request to save Cart : {}", cartDTO);
		CartDTO result = cartService.save(cartDTO);
		return result;
	}

	@PutMapping("/cart")
	public CartDTO updateCart(@RequestBody CartDTO cartDTO) {
		log.debug("REST request to update Cart : {}", cartDTO);

		CartDTO result = cartService.save(cartDTO);
		return result;
	}

	@GetMapping("/cart")
	public List<CartDTO> getAllCarts() {
		log.debug("REST request to get all Orders");
		return cartService.findAll();
	}

	@GetMapping("/cart/{id}")
	public Optional<CartDTO> getCart(@PathVariable Long id) {
		log.debug("REST request to get Cart : {}", id);
		return cartService.findOne(id);
	}

	@DeleteMapping("/cart/{id}")
	public void deleteCart(@PathVariable Long id) {
		log.debug("REST request to delete Cart : {}", id);
		cartService.delete(id);

	}
}