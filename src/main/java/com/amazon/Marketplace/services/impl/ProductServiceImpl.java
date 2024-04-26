package com.amazon.Marketplace.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.Marketplace.dto.ProductDto;
import com.amazon.Marketplace.mapper.ProductMapper;
import com.amazon.Marketplace.models.Product;
import com.amazon.Marketplace.repository.ProductRepository;

import com.amazon.Marketplace.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productrepository;

	@Override
	public ProductDto createProduct(ProductDto productdto) {
	Product toProduct=	ProductMapper.mapToProduct(productdto);
	Product savedProduct=productrepository.save(toProduct);
	return ProductMapper.mapToProductDto(savedProduct);
	
	}

	@Override
	public ProductDto getById(int id) {
		Optional<Product> product = productrepository.findById(id);
				      //    orElseThrow(()->new RuntimeException("product of this id doesnt exist"));
	     ProductDto productdto=	ProductMapper.mapToProductDto(product.get());
	     return productdto;
		
	}
}
