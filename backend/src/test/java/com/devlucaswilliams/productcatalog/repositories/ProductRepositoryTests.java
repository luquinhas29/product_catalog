package com.devlucaswilliams.productcatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.devlucaswilliams.productcatalog.entities.Product;

@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repository;
	
	@Test
	public void deleteShouldeDeleteObjectWhenIdExists() {
		long exintingId = 1L;
		
		repository.deleteById(exintingId);
		
		Optional<Product> result = repository.findById(exintingId);
		Assertions.assertFalse(result.isPresent());
	}
}
