package com.example.online_shopping.service.mapper;

import org.mapstruct.Mapper;

import com.example.online_shopping.domain.Category;
import com.example.online_shopping.service.dto.CategoryDTO;


@Mapper(componentModel = "spring", uses = {})
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
	
	CategoryDTO toDto(Category category);

	Category toEntity(CategoryDTO categoryDTO);

	default Category fromId(Long id) {
		if (id == null) {
			return null;
		}
		Category category = new Category();
		category.setId(id);
		return category;
	}

}
