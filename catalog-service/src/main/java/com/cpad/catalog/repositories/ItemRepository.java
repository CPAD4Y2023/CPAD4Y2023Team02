package com.cpad.catalog.repositories;

import com.cpad.catalog.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, String> {

    Optional<Item> findByNameIgnoreCase(String name);
}
