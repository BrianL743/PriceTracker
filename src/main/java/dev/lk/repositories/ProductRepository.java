package dev.lk.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.lk.entities.Product;

@Component
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findByTitleContainsIgnoreCase(String Title);
	
	
}
