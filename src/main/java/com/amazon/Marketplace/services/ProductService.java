package com.amazon.Marketplace.services;

import com.amazon.Marketplace.dto.ProductDto;

public interface ProductService {
	ProductDto createProduct(ProductDto productdto);

	ProductDto getById(int id);

}
