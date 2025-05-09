package com.devlucaswilliams.productcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devlucaswilliams.productcatalog.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
