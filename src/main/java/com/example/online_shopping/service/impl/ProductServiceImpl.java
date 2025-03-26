package com.example.online_shopping.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.domain.Product;
import com.example.online_shopping.repository.ProductRepository;
import com.example.online_shopping.service.ProductService;
import com.example.online_shopping.service.dto.ProductDTO;
import com.example.online_shopping.service.mapper.ProductMapper;


@Service
public class ProductServiceImpl implements ProductService {
	private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper;

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		log.debug("Request to save TblTimeZone : {}", productDTO);
		Product product = productMapper.toEntity(productDTO);
		product = productRepository.save(product);
		ProductDTO result = productMapper.toDto(product);
		return result;
	}

	@Override
	public List<ProductDTO> findAll() {
		log.debug("Request to get all TblTimeZone");
		return productRepository.findAll().stream().map(productMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Optional<ProductDTO> findOne(Long id) {
		log.debug("Request to get TblTimeZone : {}", id);
		return productRepository.findById(id).map(productMapper::toDto);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete TblTimeZone : {}", id);
		productRepository.deleteById(id);
	}

}
