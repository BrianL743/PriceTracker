package dev.lk.services;

import java.util.List;

import dev.lk.entities.Customer;
import dev.lk.entities.Product;

public interface CustomerService {

	//CRUD
	Customer createCustomer(Customer customer);
	Customer getCustomerById(int id);
	Customer updateCustomer(Customer customer);
	boolean deleteCustomerById(int id);
	
	List<Product> getProductsByCustomer(int id);
	Customer logInCustomer(String username, String password);
	
}
