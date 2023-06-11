package com.cpad.recyclone.repository;

import com.cpad.recyclone.entity.VendorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<VendorDetails, Long> {
}
