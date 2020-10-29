package dev.lk.services;

import dev.lk.entities.Product;

public interface ProductService {
	
	//CRUD
	Product createProduct(Product product);
	Product getProductById(int id);
	Product updateProduct(Product product);
	boolean deleteProductById(int id);
	

}
