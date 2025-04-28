package com.example.online_shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online_shopping.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	public Boolean existsByName(String name);

	public List<Category> findByIsActiveTrue();

}
