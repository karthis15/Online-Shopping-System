package com.example.online_shopping.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

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

	@Autowired
	private GoogleDriveServiceImpl googleDriveServiceImpl;

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
	public ProductDTO findOne(Long id) {
		log.debug("Request to get TblTimeZone : {}", id);
		return productRepository.findById(id).map(productMapper::toDto).orElse(null);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete TblTimeZone : {}", id);
		productRepository.deleteById(id);
	}

	@Override
	public ProductDTO saveProductWithImage(ProductDTO productDTO, MultipartFile imageFile) throws Exception {
		String imageUrl = googleDriveServiceImpl.uploadImageToDrive(imageFile); // Upload image to Google Drive
		productDTO.setImage(imageUrl); // Set Google Drive URL in DTO

		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);

		Product savedProduct = productRepository.save(product);

		ProductDTO resultDTO = new ProductDTO();
		BeanUtils.copyProperties(savedProduct, resultDTO);
		return resultDTO;
	}

	@Override
	public Page<Product> searchProductPagination(Integer pageNo, Integer pageSize, String ch) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return productRepository.findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(ch, ch, pageable);
	}

	@Override
	public Page<Product> getAllProductsPagination(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return productRepository.findAll(pageable);
	}

	@Override
	public Boolean deleteProduct(Long id) {
		Product product = productRepository.findById(id).orElse(null);

		if (!ObjectUtils.isEmpty(product)) {
			productRepository.delete(product);
			return true;
		}
		return false;
	}

	@Override
	public Collection<ProductDTO> getAllActiveProducts(String category) {
		List<ProductDTO> products = null;
		List<Product> product = null;
		if (ObjectUtils.isEmpty(category)) {
			product = productRepository.findByIsActiveTrue();
			products = productMapper.toDto(product);

		} else {
			product = productRepository.findByCategory(category);
			products = productMapper.toDto(product);
		}

		return products;
	}

	@Override
	public Page<Product> getAllActiveProductPagination(Integer pageNo, Integer pageSize, String category) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Product> pageProduct = null;

		if (ObjectUtils.isEmpty(category)) {
			pageProduct = productRepository.findByIsActiveTrue(pageable);
		} else {
			pageProduct = productRepository.findByCategory(pageable, category);
		}
		return pageProduct;
	}

	@Override
	public Page<Product> searchActiveProductPagination(Integer pageNo, Integer pageSize, String category, String ch) {
		Page<Product> pageProduct = null;
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		pageProduct = productRepository.findByisActiveTrueAndTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(ch,
				ch, pageable);

//		if (ObjectUtils.isEmpty(category)) {
//			pageProduct = productRepository.findByIsActiveTrue(pageable);
//		} else {
//			pageProduct = productRepository.findByCategory(pageable, category);
//		}
		return pageProduct;
	}

	@Override
	public List<Product> searchProduct(String ch) {
		return productRepository.findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(ch, ch);
	}

	@Override
	public Product updateProduct(Product product, MultipartFile image) {
		ProductDTO dbProduct = findOne(product.getId());

		String imageName = image.isEmpty() ? dbProduct.getImage() : image.getOriginalFilename();

		dbProduct.setTitle(product.getTitle());
		dbProduct.setDescription(product.getDescription());
		dbProduct.setCategory(product.getCategory());
		dbProduct.setPrice(product.getPrice());
		dbProduct.setStock(product.getStock());
		dbProduct.setImage(imageName);
		dbProduct.setIsActive(product.getIsActive());
		dbProduct.setDiscount(product.getDiscount());

		// 5=100*(5/100); 100-5=95
		Double disocunt = product.getPrice() * (product.getDiscount() / 100.0);
		Double discountPrice = product.getPrice() - disocunt;
		dbProduct.setDiscountPrice(discountPrice);

		Product updateProduct = productRepository.save(productMapper.toEntity(dbProduct));

		if (!ObjectUtils.isEmpty(updateProduct)) {

			if (!image.isEmpty()) {

				try {
					File saveFile = new ClassPathResource("static/img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "product_img" + File.separator
							+ image.getOriginalFilename());
					Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return product;
		}
		return null;
	}

}
