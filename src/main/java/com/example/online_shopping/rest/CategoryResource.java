package com.example.online_shopping.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_shopping.service.CategoryService;
import com.example.online_shopping.service.dto.CategoryDTO;


@RestController
@RequestMapping("/api")
public class CategoryResource {
	
	private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

	@Autowired
	CategoryService categoryService;

	@PostMapping("/Category-create")
	public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
		log.debug("REST request to save Category : {}", categoryDTO);
		CategoryDTO result = categoryService.save(categoryDTO);
		return result;
	}

	@PutMapping("/Category-update")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
		log.debug("REST request to update Category : {}", categoryDTO);

		CategoryDTO result = categoryService.save(categoryDTO);
		return result;
	}

	@GetMapping("/Category-getAll")
	public List<CategoryDTO> getAllCategory() {
		log.debug("REST request to get all Category");
		return categoryService.findAll();
	}

	@GetMapping("/Category-getid/{id}")
	public CategoryDTO getCategory(@PathVariable Long id) {
		log.debug("REST request to get Category : {}", id);
		return categoryService.findOne(id);
	}

	@DeleteMapping("/Category-delete/{id}")
	public void deleteCategory(@PathVariable Long id) {
		log.debug("REST request to delete Category : {}", id);
		categoryService.delete(id);

	}

}
