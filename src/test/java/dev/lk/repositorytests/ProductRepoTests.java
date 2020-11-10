package dev.lk.repositorytests;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import dev.lk.entities.Product;
import dev.lk.repositories.ProductRepository;

@SpringBootTest
@ContextConfiguration(classes=dev.lk.app.PriceTrackerApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductRepoTests {

	@Autowired
	ProductRepository pr;
	
	@Test
	@Order(1)
	void findByTitleContains() {
		List<Product> products = pr.findByTitleContainsIgnoreCase("toaster");
		//System.out.println(products.get(0).getPrices());
		String title = "Elite Gourmet ECT-3100 Maxi-Matic 4 Slice Long Toaster with Extra Wide 1.5\" Slot for Bread, Bagels, Croissants, and Buns, Reheat, Cancel and Defrost, 6 Adjustable Toast Settings, Stainless Steel";
		Assertions.assertEquals(products.get(0).getTitle(), title);
	}
	

}
