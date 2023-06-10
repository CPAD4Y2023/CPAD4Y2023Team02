package com.cpad.recyclone.controller;

import com.cpad.recyclone.entity.VendorDetails;
import com.cpad.recyclone.service.VendorService;
import com.cpad.recyclone.dtos.VendorsByCategoryIdsRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendor")
@AllArgsConstructor
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("")
    public List<VendorDetails> getAllVendorDetails() {
        return vendorService.getAllVendorDetails();
    }

    @GetMapping("/{id}")
    public VendorDetails getVendorDetails(@PathVariable Long id) {
        return vendorService.getVendorDetails(id);
    }

    @PostMapping()
    public ResponseEntity<VendorDetails> addVendorDetails(@RequestBody VendorDetails vendorDetails) {
        VendorDetails response = vendorService.addVendorDetails(vendorDetails);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/category")
    public ResponseEntity<List<VendorDetails>> getVendorsByCategoryIds
            (@RequestBody VendorsByCategoryIdsRequest categoryIds) {
        List<VendorDetails> response = vendorService.getVendorsByCategoryIds(categoryIds);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public void updateVendorDetails(@RequestBody VendorDetails vendorDetails, @PathVariable String id) {
        vendorService.updateVendorDetails(id, vendorDetails);
    }
}
