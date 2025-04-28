package com.example.online_shopping.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.online_shopping.domain.Order;
import com.example.online_shopping.service.dto.OrderDTO;
import com.example.online_shopping.service.dto.OrderRequestDTO;

public interface OrderService {

	OrderDTO save(OrderDTO orderDTO);

	List<OrderDTO> findAll();

	OrderDTO findOne(Long id);

	void delete(Long id);

	void saveOrder(String userid, OrderRequestDTO orderRequest) throws Exception;

	List<Order> getOrdersByUser(String userId);

	Order updateOrderStatus(Long id, String status);

	Page<Order> getAllOrdersPagination(Integer pageNo, Integer pageSize);

	Order getOrdersByOrderId(String orderId);

}
