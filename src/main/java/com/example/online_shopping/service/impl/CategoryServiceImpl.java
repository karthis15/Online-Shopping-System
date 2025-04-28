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
import org.springframework.util.ObjectUtils;

import com.example.online_shopping.domain.Category;
import com.example.online_shopping.repository.CategoryRepository;
import com.example.online_shopping.service.CategoryService;
import com.example.online_shopping.service.dto.CategoryDTO;
import com.example.online_shopping.service.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		log.debug("Request to save Category : {}", categoryDTO);
		Category category = categoryMapper.toEntity(categoryDTO);
		category = categoryRepository.save(category);
		CategoryDTO result = categoryMapper.toDto(category);
		return result;
	}

	@Override
	public List<CategoryDTO> findAll() {
		log.debug("Request to get all Category");
		return categoryRepository.findAll().stream().map(categoryMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public CategoryDTO findOne(Long id) {
		log.debug("Request to get Category : {}", id);
		return categoryRepository.findById(id).map(categoryMapper::toDto).orElse(null);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete Category : {}", id);
		categoryRepository.deleteById(id);
	}

	@Override
	public List<CategoryDTO> getAllActiveCategory() {
		return categoryRepository.findByIsActiveTrue().stream().map(categoryMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Page<Category> getAllCategorPagination(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Boolean existCategory(String name) {
		return categoryRepository.existsByName(name);
	}

	@Override
	public Boolean deleteCategory(Long id) {
		Category category = categoryRepository.findById(id).orElse(null);

		if (!ObjectUtils.isEmpty(category)) {
			categoryRepository.delete(category);
			return true;
		}
		return false;
	}

}
