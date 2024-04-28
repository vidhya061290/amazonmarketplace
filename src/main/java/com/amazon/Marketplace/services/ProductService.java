package com.amazon.Marketplace.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.amazon.Marketplace.dto.ProductDto;

public interface ProductService {
	ProductDto createProduct(ProductDto productdto);

	ResponseEntity <ProductDto> getById(int id);

    ProductDto updateById(int id, double price);

	String deleteById(int id);

	List<ProductDto> getAllProducts();

	ProductDto updateNameById(int id, String name);

}
