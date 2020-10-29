package dev.lk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.lk.entities.Store;
import dev.lk.services.StoreService;

@Component
@CrossOrigin("*")
@RestController
public class StoreController {
	
	@Autowired
	private StoreService sts;
	
	@PostMapping(value = "/stores")
	public Store createStore(@RequestBody Store store) {
		return sts.createStore(store);
	}

}
