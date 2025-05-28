package com.devlucaswilliams.productcatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devlucaswilliams.productcatalog.entities.Product;
import com.devlucaswilliams.productcatalog.tests.Factory;

@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repository;
	
	private long exintingId;
	//private long nonExistingId;
	private long countTotalProduct;
	
	@BeforeEach
	void setup() throws Exception {
		exintingId = 1L;
		//nonExistingId = 1000L;
		countTotalProduct = 25L;
	}
	
	@Test
	public void saveSholdPersistWithAutoincrementWhenIdIsNull() {
		
		Product product = Factory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProduct + 1, product.getId());
	}
	
	@Test
	public void deleteShouldeDeleteObjectWhenIdExists() {		
		
		repository.deleteById(exintingId);
		
		Optional<Product> result = repository.findById(exintingId);
		Assertions.assertFalse(result.isPresent());
	}
	
	/*@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenDoesNotExist() {
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}*/
}
