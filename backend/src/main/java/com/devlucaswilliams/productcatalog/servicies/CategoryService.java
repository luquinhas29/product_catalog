package com.devlucaswilliams.productcatalog.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devlucaswilliams.productcatalog.entities.Category;
import com.devlucaswilliams.productcatalog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		List<Category> list = repository.findAll();
		return list;
	}
}
