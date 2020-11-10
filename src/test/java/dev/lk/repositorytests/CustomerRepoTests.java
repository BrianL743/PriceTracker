package dev.lk.repositorytests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import dev.lk.entities.Customer;
import dev.lk.entities.Product;
import dev.lk.repositories.CustomerRepository;

@SpringBootTest
@ContextConfiguration(classes=dev.lk.app.PriceTrackerApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRepoTests {

	@Autowired
	CustomerRepository cr;
	
	@Test
	@Order(1)
	void findByTitleContains() {
		Customer cust = cr.findByUsername("user1");
		//System.out.println(cust.getUsername());
		Assertions.assertEquals("user1", cust.getUsername());
	}	

}
