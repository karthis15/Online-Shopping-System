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

import com.example.online_shopping.service.OrderService;
import com.example.online_shopping.service.dto.OrderDTO;

@RestController
@RequestMapping("/api")
public class OrderResource {
	
	private final Logger log = LoggerFactory.getLogger(OrderResource.class);

	@Autowired
	OrderService orderService;

	@PostMapping("/Order-create")
	public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
		log.debug("REST request to save Order : {}", orderDTO);
		OrderDTO result = orderService.save(orderDTO);
		return result;
	}

	@PutMapping("/Order-update")
	public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
		log.debug("REST request to update Order : {}", orderDTO);

		OrderDTO result = orderService.save(orderDTO);
		return result;
	}

	@GetMapping("/Order-getAll")
	public List<OrderDTO> getAllOrder() {
		log.debug("REST request to get all Order");
		return orderService.findAll();
	}

	@GetMapping("/Order-getid/{id}")
	public OrderDTO getOrder(@PathVariable Long id) {
		log.debug("REST request to get Order : {}", id);
		return orderService.findOne(id);
	}

	@DeleteMapping("/Order-delete/{id}")
	public void deleteOrder(@PathVariable Long id) {
		log.debug("REST request to delete Order : {}", id);
		orderService.delete(id);

	}

}
