package com.cpad.catalog.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {

    @NotBlank(message = "Category name can not be empty")
    private String name;

    private Set<CreateItemRequest> items;
}