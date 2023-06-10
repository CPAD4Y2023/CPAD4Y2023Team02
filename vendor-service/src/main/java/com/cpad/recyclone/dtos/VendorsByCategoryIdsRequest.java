package com.cpad.recyclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorsByCategoryIdsRequest {
    List<Long> categoryIds;
}
