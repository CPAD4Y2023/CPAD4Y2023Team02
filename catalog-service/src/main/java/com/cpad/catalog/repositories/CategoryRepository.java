package com.cpad.catalog.repositories;

import com.cpad.catalog.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {


    Optional<Category> findByNameIgnoreCase(String name);
}
