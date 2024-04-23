package com.amazon.Marketplace.mapper;

import com.amazon.Marketplace.dto.ProductDto;
import com.amazon.Marketplace.models.Product;

public class ProductMapper {
	public static Product mapToProduct(ProductDto productdto) {
		Product product = new Product(productdto.getId(),productdto.getProductName(),
				                      productdto.getPrice(),productdto.getDescription());
		return product;
	}

	public static ProductDto mapToProductDto(Product product) {
		ProductDto productdto = new ProductDto(product.getId(),product.getProductName(),
				                               product.getPrice(),product.getDescription());
		return productdto;
	}
}
