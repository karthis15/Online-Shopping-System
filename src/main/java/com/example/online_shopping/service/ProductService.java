package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import com.example.online_shopping.service.dto.ProductDTO;

public interface ProductService {

	ProductDTO save(ProductDTO productDTO);

	List<ProductDTO> findAll();

	Optional<ProductDTO> findOne(Long id);

	void delete(Long id);

}
