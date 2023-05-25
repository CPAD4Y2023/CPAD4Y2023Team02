package com.cpad.catalog.controllers;

import com.cpad.catalog.dtos.common.CreateCategoryDTO;
import com.cpad.catalog.dtos.response.CatalogServiceResponse;
import com.cpad.catalog.exceptions.parent.BadRequestException;
import com.cpad.catalog.services.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CatalogServiceResponse<CreateCategoryDTO>> createCategory(@Valid @RequestBody CreateCategoryDTO createCategoryRequest) throws BadRequestException {

        categoryService.createCategory(createCategoryRequest);

        return CatalogServiceResponse.created(createCategoryRequest, "Category Created Successfully");
    }
}
