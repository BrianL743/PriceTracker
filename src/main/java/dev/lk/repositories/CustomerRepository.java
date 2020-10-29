package dev.lk.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.lk.entities.Customer;

@Component
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	List<Customer> findByUsername(String username);
	
}
