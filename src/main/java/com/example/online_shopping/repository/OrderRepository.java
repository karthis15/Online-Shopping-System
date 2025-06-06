package com.example.online_shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online_shopping.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUserId(String userId);

//	Order findByOrderId(Long orderId);

	Order findByOrderId(String orderId);


}
