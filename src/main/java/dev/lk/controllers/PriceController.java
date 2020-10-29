package dev.lk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.lk.entities.Price;
import dev.lk.services.PriceService;

@Component
@CrossOrigin("*")
@RestController
public class PriceController {

	@Autowired
	private PriceService ps;
	
	@PostMapping(value = "/price")
	public Price createPrice(@RequestBody Price price) {
		return ps.createPrice(price);
	}
}
