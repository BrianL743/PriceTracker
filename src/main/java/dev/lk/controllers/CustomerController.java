package dev.lk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.lk.entities.Customer;
import dev.lk.entities.LoginDTO;
import dev.lk.entities.Product;
import dev.lk.services.CustomerService;

@Component
@CrossOrigin("*")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@PostMapping(value = "/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return cs.createCustomer(customer);
	}
	
	@GetMapping(value = "/customers/{cid}")
	public Customer getCustomerById(@PathVariable Integer cid) {
		return cs.getCustomerById(cid);
	}
	
	@PutMapping(value = "/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return cs.updateCustomer(customer);
	}
	
	@DeleteMapping(value = "/customers/{cid}")
	public boolean deleteCustomer(@PathVariable Integer cid) {
		return cs.deleteCustomerById(cid);
	}
	
	@GetMapping(value = "/customers/{cid}/products")
	public List<Product> getCustomerSavedProducts(@PathVariable Integer cid) {
		return cs.getProductsByCustomer(cid);
	}
	
	@PostMapping(value = "/login") 
	public Customer loginCustomer(@RequestBody LoginDTO loginInfo) {
		return cs.logInCustomer(loginInfo.getUsername(), loginInfo.getPassword());
	}

}
