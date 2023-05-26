package com.cpad.catalog.repositories;

import com.cpad.catalog.entities.Category;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

  Optional<Category> findByNameIgnoreCase(String name);

  boolean existsByNameIgnoreCaseAndIdNotIn(String name, Collection<Long> ids);
}
