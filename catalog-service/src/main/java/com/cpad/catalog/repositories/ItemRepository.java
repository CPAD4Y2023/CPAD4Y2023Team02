package com.cpad.catalog.repositories;

import com.cpad.catalog.entities.Item;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

  Optional<Item> findByNameIgnoreCase(String name);

  boolean existsByNameIgnoreCaseAndIdNotIn(String name, Collection<Long> ids);

  boolean existsByNameIgnoreCase(String name);
}
