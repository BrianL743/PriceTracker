package dev.lk.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.lk.entities.Price;

@Component
@Repository
public interface PriceRepository extends CrudRepository<Price, Integer>{

}
