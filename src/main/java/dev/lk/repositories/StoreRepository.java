package dev.lk.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.lk.entities.Store;

@Component
@Repository
public interface StoreRepository extends CrudRepository<Store, Integer>{

}
