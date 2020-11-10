package dev.lk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.lk.entities.Customer;
import dev.lk.services.CustomerService;

@Component
@CrossOrigin("*")
@RestController
public class CustomerController {

	@Autowired
	CustomerService cs;
	
	@PostMapping(value = "/login")
	public Customer login(@RequestParam String username, @RequestParam String password) {
		return cs.login(username, password);
	}
	
}
