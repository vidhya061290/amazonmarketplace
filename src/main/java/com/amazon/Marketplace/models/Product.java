package com.amazon.Marketplace.models;
	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import lombok.AllArgsConstructor;
	import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Table(name="product")
	public class Product {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column(name="product_name")
		private String productName;
		@Column(name="price")
		private double price;
		@Column(name="description")
		private String description;
		
		

	}



