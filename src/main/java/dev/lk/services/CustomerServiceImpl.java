package dev.lk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.lk.entities.Customer;
import dev.lk.repositories.CustomerRepository;

@Component
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository cr;

	@Override
	public Customer createCustomer(Customer c) {
		return cr.save(c);
	}

	@Override
	public Customer getCustomerById(int id) {
		return cr.findById(id).orElse(null);
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		return cr.findByUsername(username);
	}

	@Override
	public List<Customer> getCustomers() {
		return (List<Customer>) cr.findAll();
	}

	@Override
	public Customer updateCustomer(Customer c) {
		return cr.save(c);
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		cr.delete(c);
		return true;
	}

	@Override
	public Customer login(String username, String password) {
		Customer cust = cr.findByUsername(username);
		if(cust.equals(null)) {
			return null;
		}else if(cust.getPassword().equals(password)) {
			return cust;
		}else {
			return null;
		}
	}
}
