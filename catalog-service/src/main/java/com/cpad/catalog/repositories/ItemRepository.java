package com.cpad.catalog.repositories;

import com.cpad.catalog.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    Optional<Item> findByNameIgnoreCase(String name);
}
