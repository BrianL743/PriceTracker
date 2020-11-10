package dev.lk.services;

import java.util.List;

import dev.lk.entities.Customer;


public interface CustomerService {

	//CREATE
	public Customer createCustomer(Customer c);

	//READ
	public Customer getCustomerById(int id);
	public Customer getCustomerByUsername(String username);
	public List<Customer> getCustomers();
	public Customer login(String username, String password);
	
	//UPDATE
	public Customer updateCustomer(Customer c);
	
	//DELETE
	public boolean deleteCustomer(Customer c);
}
