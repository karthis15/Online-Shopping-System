package com.example.online_shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online_shopping.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	public Cart findByProductIdAndUserId(Long productId, String userId);

	public Integer countByUserId(String userId);

	public List<Cart> findByUserId(String userId);


}
