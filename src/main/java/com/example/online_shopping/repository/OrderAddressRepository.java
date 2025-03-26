package com.example.online_shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_shopping.domain.OrderAddress;

public interface OrderAddressRepository extends JpaRepository<OrderAddress, Long> {

}
