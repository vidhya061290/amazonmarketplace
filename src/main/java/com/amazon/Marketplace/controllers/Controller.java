package com.amazon.Marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.Marketplace.dto.ProductDto;
import com.amazon.Marketplace.services.ProductService;

@RestController
@RequestMapping(path="/api/products")
public class Controller {
	@Autowired
	ProductService productservice;

	@PostMapping
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productdto){
		return new ResponseEntity<>(productservice.createProduct(productdto),
				                    HttpStatus.CREATED);
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<ProductDto> getById(@PathVariable(name = "id") int id){
		return new ResponseEntity<>(productservice.getById(id), HttpStatus.OK);
		
		
	}
}
