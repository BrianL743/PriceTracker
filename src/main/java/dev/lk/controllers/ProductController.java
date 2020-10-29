package dev.lk.controllers;

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

import dev.lk.entities.Product;
import dev.lk.services.ProductService;

@Component
@CrossOrigin("*")
@RestController
public class ProductController {

	@Autowired
	private ProductService cs;

	@PostMapping(value = "/products")
	public Product createProduct(@RequestBody Product product) {
		return cs.createProduct(product);
	}

	@GetMapping(value = "/products/{cid}")
	public Product getProductById(@PathVariable Integer cid) {
		return cs.getProductById(cid);
	}

	@PutMapping(value = "/products")
	public Product updateProduct(@RequestBody Product product) {
		return cs.updateProduct(product);
	}

	@DeleteMapping(value = "/products/{cid}")
	public boolean deleteProduct(@PathVariable Integer cid) {
		return cs.deleteProductById(cid);
	}
}
