package com.cpad.catalog.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {

  @NotBlank(message = "Category name can not be empty")
  private String name;

  @NotBlank(message = "Image location can not be empty")
  private String imageLocation;

  @Valid
  @NotNull(message = "Items are required")
  private Set<CreateItemRequest> items;
}
