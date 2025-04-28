package com.example.online_shopping.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.online_shopping.domain.Cart;
import com.example.online_shopping.domain.Order;
import com.example.online_shopping.domain.OrderAddress;
import com.example.online_shopping.enums.OrderStatus;
import com.example.online_shopping.repository.CartRepository;
import com.example.online_shopping.repository.OrderRepository;
import com.example.online_shopping.service.OrderService;
import com.example.online_shopping.service.dto.OrderDTO;
import com.example.online_shopping.service.dto.OrderRequestDTO;
import com.example.online_shopping.service.mapper.OrderMapper;
import com.example.online_shopping.util.CommonUtil;

@Service
public class OrderServiceImpl implements OrderService {

	private final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderMapper orderMapper;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CommonUtil commonUtil;

	@Override
	public OrderDTO save(OrderDTO orderDTO) {
		log.debug("Request to save Order : {}", orderDTO);
		Order order = orderMapper.toEntity(orderDTO);
		order = orderRepository.save(order);
		OrderDTO result = orderMapper.toDto(order);
		return result;
	}

	@Override
	public List<OrderDTO> findAll() {
		log.debug("Request to get all Order");
		return orderRepository.findAll().stream().map(orderMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public OrderDTO findOne(Long id) {
		log.debug("Request to get Order : {}", id);
		return orderRepository.findById(id).map(orderMapper::toDto).orElse(null);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete Order : {}", id);
		orderRepository.deleteById(id);
	}

	@Override
	public void saveOrder(String userid, OrderRequestDTO orderRequest) throws Exception {

		List<Cart> carts = cartRepository.findByUserId(userid);

		for (Cart cart : carts) {

			Order order = new Order();

			// order.setOrderId(UUID.randomUUID().toString());
			// order.setOrderDate(LocalDate.now());

			order.setProduct(cart.getProduct());
			order.setPrice(cart.getProduct().getDiscountPrice());

			order.setQuantity(cart.getQuantity());
			order.setUser(cart.getUser());

			order.setStatus(OrderStatus.IN_PROGRESS.getName());
			order.setPaymentType(orderRequest.getPaymentType());

			OrderAddress address = new OrderAddress();
			address.setFirstName(orderRequest.getFirstName());
			address.setLastName(orderRequest.getLastName());
			address.setEmail(orderRequest.getEmail());
			address.setMobileNo(orderRequest.getMobileNo());
			address.setAddress(orderRequest.getAddress());
			address.setCity(orderRequest.getCity());
			address.setState(orderRequest.getState());
			address.setPincode(orderRequest.getPincode());

			order.setOrderAddress(address);

			Order saveOrder = orderRepository.save(order);
			commonUtil.sendMailForProductOrder(saveOrder, "success");
		}
	}

	@Override
	public List<Order> getOrdersByUser(String userId) {
		List<Order> orders = orderRepository.findByUserId(userId);
		return orders;
	}

	@Override
	public Order updateOrderStatus(Long id, String status) {
		Order findById = orderRepository.findById(id).orElse(null);
		if (findById != null) {
			// Order productOrder = findById.get();
			findById.setStatus(status);
			Order updateOrder = orderRepository.save(findById);
			return updateOrder;
		}
		return null;
	}

	@Override
	public Page<Order> getAllOrdersPagination(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return orderRepository.findAll(pageable);

	}

	@Override
	public Order getOrdersByOrderId(String orderId) {
		return orderRepository.findByOrderId(orderId);
	}

}
