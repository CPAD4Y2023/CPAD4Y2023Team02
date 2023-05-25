package com.cpad.catalog.controllers;

import com.cpad.catalog.dtos.request.CreateCategoryRequest;
import com.cpad.catalog.dtos.response.CatalogServiceResponse;
import com.cpad.catalog.dtos.response.CategoryResponse;
import com.cpad.catalog.exceptions.parent.BadRequestException;
import com.cpad.catalog.exceptions.parent.NotFoundException;
import com.cpad.catalog.services.CategoryService;
import com.cpad.catalog.utils.Constants;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<CatalogServiceResponse<CategoryResponse>> createCategory(
      @RequestBody @Valid CreateCategoryRequest createCategoryRequest) throws BadRequestException {

    final CategoryResponse response = categoryService.createCategory(createCategoryRequest);

    return CatalogServiceResponse.created(
        response, Constants.CATEGORY_CREATED_SUCCESSFULLY.getName());
  }

  @GetMapping
  public ResponseEntity<CatalogServiceResponse<List<CategoryResponse>>> getAllCategories() {

    final List<CategoryResponse> allCategories = categoryService.getAllCategories();

    return CatalogServiceResponse.ok(allCategories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CatalogServiceResponse<CategoryResponse>> getCategoryById(
      @PathVariable String id) throws NotFoundException, BadRequestException {

    final CategoryResponse category = categoryService.getCategoryById(id);

    return CatalogServiceResponse.ok(category);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CatalogServiceResponse<String>> deleteCategoryById(@PathVariable String id)
      throws BadRequestException {

    categoryService.deleteCategoryById(id);

    return CatalogServiceResponse.noContent();
  }
}
