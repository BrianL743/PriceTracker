package dev.lk.services;

import dev.lk.entities.Store;
import dev.lk.entities.Product;

public interface StoreService {
	
	//Crud
	Store createStore(Store store);
	Store getStoreById(int id);
	Store getStoreByProduct(Product product);

}
