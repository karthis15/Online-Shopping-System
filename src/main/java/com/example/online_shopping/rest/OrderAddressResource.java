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

import com.example.online_shopping.service.OrderAddressService;
import com.example.online_shopping.service.dto.OrderAddressDTO;

@RestController
@RequestMapping("/api")
public class OrderAddressResource {
	
	private final Logger log = LoggerFactory.getLogger(OrderAddressResource.class);

	@Autowired
	OrderAddressService orderAddressService;

	@PostMapping("/OrderAddress-create")
	public OrderAddressDTO createOrderAddress(@RequestBody OrderAddressDTO orderAddressDTO) {
		log.debug("REST request to save OrderAddress : {}", orderAddressDTO);
		OrderAddressDTO result = orderAddressService.save(orderAddressDTO);
		return result;
	}

	@PutMapping("/OrderAddress-update")
	public OrderAddressDTO updateOrderAddress(@RequestBody OrderAddressDTO orderAddressDTO) {
		log.debug("REST request to update OrderAddress : {}", orderAddressDTO);

		OrderAddressDTO result = orderAddressService.save(orderAddressDTO);
		return result;
	}

	@GetMapping("/OrderAddress-getAll")
	public List<OrderAddressDTO> getAllOrderAddress() {
		log.debug("REST request to get all OrderAddress");
		return orderAddressService.findAll();
	}

	@GetMapping("/OrderAddress-getid/{id}")
	public Optional<OrderAddressDTO> getOrderAddress(@PathVariable Long id) {
		log.debug("REST request to get OrderAddress : {}", id);
		return orderAddressService.findOne(id);
	}

	@DeleteMapping("/OrderAddress-delete/{id}")
	public void deleteOrderAddress(@PathVariable Long id) {
		log.debug("REST request to delete OrderAddress : {}", id);
		orderAddressService.delete(id);

	}


}
