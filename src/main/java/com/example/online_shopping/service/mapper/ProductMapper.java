package com.example.online_shopping.service.mapper;

import org.mapstruct.Mapper;

import com.example.online_shopping.domain.Product;
import com.example.online_shopping.service.dto.ProductDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

	ProductDTO toDto(Product product);

	Product toEntity(ProductDTO productDTO);

	default Product fromId(Long id) {
		if (id == null) {
			return null;
		}
		Product product = new Product();
		product.setId(id);
		return product;
	}
}
