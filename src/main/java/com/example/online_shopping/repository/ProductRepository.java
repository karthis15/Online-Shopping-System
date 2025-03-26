package com.example.online_shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.online_shopping.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
