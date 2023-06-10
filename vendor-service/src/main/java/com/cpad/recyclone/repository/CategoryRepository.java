package com.cpad.recyclone.repository;

import com.cpad.recyclone.entity.CategoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryDetails, Long> {
}
