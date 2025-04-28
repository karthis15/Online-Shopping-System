package com.example.online_shopping.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.example.online_shopping.domain.Category;
import com.example.online_shopping.domain.Product;
import com.example.online_shopping.service.dto.ProductDTO;

public interface ProductService {

	ProductDTO save(ProductDTO productDTO);

	List<ProductDTO> findAll();

	ProductDTO findOne(Long id);

	void delete(Long id);

	ProductDTO saveProductWithImage(ProductDTO productDTO, MultipartFile imageFile) throws Exception;


	Page<Product> searchProductPagination(Integer pageNo, Integer pageSize, String ch);

	Page<Product> getAllProductsPagination(Integer pageNo, Integer pageSize);

	Collection<ProductDTO> getAllActiveProducts(String string);

	Page<Product> getAllActiveProductPagination(Integer pageNo, Integer pageSize, String category);

	Page<Product> searchActiveProductPagination(Integer pageNo, Integer pageSize, String category, String ch);

	List<Product> searchProduct(String ch);

	Product updateProduct(Product product, MultipartFile image);

	Boolean deleteProduct(Long id);

}
