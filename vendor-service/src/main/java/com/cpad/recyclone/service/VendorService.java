package com.cpad.recyclone.service;

import com.cpad.recyclone.entity.CategoryDetails;
import com.cpad.recyclone.entity.VendorDetails;
import com.cpad.recyclone.repository.CategoryRepository;
import com.cpad.recyclone.repository.VendorRepository;
import com.cpad.recyclone.dtos.VendorsByCategoryIdsRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<VendorDetails> getAllVendorDetails() {
        return vendorRepository.findAll();
    }

    public VendorDetails getVendorDetails(Long id) {
        return vendorRepository.findById(id).orElseGet(() -> null);
    }

    public VendorDetails addVendorDetails(VendorDetails vendorDetails) {
        //vendors.add(vendorDetails);
        /* vendorDetails.getCategoryDetails().forEach(cat -> {
            cat.setVendorDetails(vendorDetails);
        });
        return vendorRepository.save(vendorDetails);*/

        vendorRepository.save(vendorDetails);
        return vendorDetails;
    }

    public void updateVendorDetails(String id, VendorDetails vendorDetails) {
        vendorRepository.save(vendorDetails);
    }

    public List<VendorDetails> getVendorsByCategoryIds(VendorsByCategoryIdsRequest categoryIds) {
        List<CategoryDetails> categories = categoryRepository.findAllById(categoryIds.getCategoryIds());

        List<VendorDetails> response = new ArrayList<>();

        categories.forEach(cat -> {
            response.add(cat.getVendorDetails());
        });

        return response;
    }
}

