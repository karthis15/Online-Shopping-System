package com.example.online_shopping.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.online_shopping.domain.Category;
import com.example.online_shopping.service.dto.CategoryDTO;

public interface CategoryService {

	CategoryDTO save(CategoryDTO categoryDTO);

	List<CategoryDTO> findAll();

	CategoryDTO findOne(Long id);

	void delete(Long id);

	List<CategoryDTO> getAllActiveCategory();

	Page<Category> getAllCategorPagination(Integer pageNo, Integer pageSize);

	Boolean existCategory(String name);

	Boolean deleteCategory(Long id);

}
