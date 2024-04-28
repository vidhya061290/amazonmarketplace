package com.amazon.Marketplace.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ProductDto> getById(int id) {
		try {
		Optional<Product> product = productrepository.findById(id);
				      //    orElseThrow(()->new RuntimeException("product of this id doesnt exist"));
	     ProductDto productdto=	ProductMapper.mapToProductDto(product.get());
	     return new ResponseEntity<> ( productdto , HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<> (null, HttpStatus.NOT_FOUND); 
			 
		
	}
	
	@Override
	public ProductDto updateById(int id , double price) {
	Optional <Product> product = productrepository.findById(id);
	product.get().setPrice(price);
	Product savedProduct = productrepository.save(product.get());
	return ProductMapper.mapToProductDto(savedProduct);
	}

	@Override
	public String deleteById(int id) {
       if (productrepository.existsById(id)) {
           productrepository.deleteById(id);  
           return " Successfully deleted the id : " + id;
       } else
    	   return " invalid id " ;
}

	@Override
	public List<ProductDto> getAllProducts() {
	List<Product> products = productrepository.findAll();
	//List<ProductDto> productdtos =new ArrayList<>();
/*	for(Product product : products) {
		productdtos.add(ProductMapper.mapToProductDto(product));
	}
	return productdtos;
		
	}*/
	List<ProductDto> productdtos =  products.stream()
                                    .map(ProductMapper :: mapToProductDto)
                                    .collect(Collectors.toList());
	return productdtos;
	}

	@Override
	public ProductDto updateNameById(int id, String name) {
	Optional<Product> product = productrepository.findById(id);
	product.get().setProductName(name);
	Product savedProduct = productrepository.save(product.get());
	return ProductMapper.mapToProductDto(savedProduct);
	}
	
}

