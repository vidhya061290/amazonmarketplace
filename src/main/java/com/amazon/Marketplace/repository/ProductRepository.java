package com.amazon.Marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.Marketplace.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
