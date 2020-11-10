package dev.lk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.lk.entities.Price;
import dev.lk.repositories.PriceRepository;

@Component
@Service
public class PriceServiceImpl implements PriceService{

	@Autowired
	PriceRepository pr;
	
	@Override
	public Price addPrice(Price c) {
		return pr.save(c);
	}

}
