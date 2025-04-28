package com.example.online_shopping.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.online_shopping.service.ProductService;
import com.example.online_shopping.service.dto.ProductDTO;

@RestController
@RequestMapping("/api")
public class ProductResource {

	private final Logger log = LoggerFactory.getLogger(ProductResource.class);

	@Autowired
	ProductService productService;

	@PostMapping("/product-create")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		log.debug("REST request to save Product : {}", productDTO);
		ProductDTO result = productService.save(productDTO);
		return result;
	}

	@PutMapping("/product-update")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		log.debug("REST request to update Product : {}", productDTO);

		ProductDTO result = productService.save(productDTO);
		return result;
	}

	@GetMapping("/product-getAll")
	public List<ProductDTO> getAllProduct() {
		log.debug("REST request to get all Product");
		return productService.findAll();
	}

	@GetMapping("/product-getid/{id}")
	public ProductDTO getProduct(@PathVariable Long id) {
		log.debug("REST request to get Product : {}", id);
		return productService.findOne(id);
	}

	@DeleteMapping("/product-delete/{id}")
	public void deleteProduct(@PathVariable Long id) {
		log.debug("REST request to delete Product : {}", id);
		productService.delete(id);

	}
	
	  @PostMapping("/create")
	    public ResponseEntity<ProductDTO> createProduct(
	            @RequestPart("product") ProductDTO productDTO,
	            @RequestPart("image") MultipartFile imageFile) throws Exception {

	        ProductDTO savedProduct = productService.saveProductWithImage(productDTO, imageFile);
	        return ResponseEntity.ok(savedProduct);
	    }

}
