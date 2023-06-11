package com.cpad.recyclone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String metric;
    private String price;

    @ManyToOne
    @JoinColumn(name = "vendor", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private VendorDetails vendorDetails;
}








