package dev.lk.services;

import java.util.List;

import dev.lk.entities.Price;
import dev.lk.entities.Product;

public interface ProductService {

	//CREATE
	public Product addProduct(Product p);
	public Product addProduct(int cid, String url);
	public Price updatePrice(Product p);
	
	//READ
	public Product getProductById(int id);
	public List<Product> getProductsByTitle(String title);
	public List<Product> getProducts();
	
	//UPDATE
	public Product updateProduct(Product p);
	
	//DELETE
	public boolean deleteProduct(Product p);
	
}
