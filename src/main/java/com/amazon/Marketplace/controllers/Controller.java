package com.amazon.Marketplace.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.Marketplace.dto.ProductDto;
import com.amazon.Marketplace.services.ProductService;

@RestController
@RequestMapping(path = "/api/products")
public class Controller {
	@Autowired
	ProductService productservice;

	@PostMapping
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productdto){
		return new ResponseEntity<>(productservice.createProduct(productdto),
				                    HttpStatus.CREATED);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<ProductDto> getById(@PathVariable(name = "id") int id){
		return productservice.getById(id);
		
	}
	@PutMapping(path = "/{id}/price")
	public ResponseEntity <ProductDto> updateById(@PathVariable(name= "id") int id,
			                                    @RequestBody Map<String,Integer>request){
		double price = request.get("price");
		return new ResponseEntity<>(productservice.updateById(id ,price),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteById(@PathVariable(name = "id") int id){ 
		return new ResponseEntity<>(productservice.deleteById(id) , HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		return new ResponseEntity<>(productservice.getAllProducts() , HttpStatus.OK);
	}
	@PutMapping(path = "/name/{id}")
	public ResponseEntity <ProductDto> updateNameById(@PathVariable (name ="id") int id ,
			                                      @RequestBody Map<String,String>request){
		String name = request.get("productName");
		return new ResponseEntity<>(productservice.updateNameById(id,name) , HttpStatus.OK);
		
		
	}
}
