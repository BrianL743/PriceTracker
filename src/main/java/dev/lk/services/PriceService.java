package dev.lk.services;

import dev.lk.entities.Price;
import dev.lk.entities.Product;

public interface PriceService {
	
	//Crud
	Price createPrice(Price price);
	Price getPriceById(int id);
	Price getPriceByProduct(Product product);

}
