package com.cpad.catalog.dtos.request;

import jakarta.validation.constraints.NotBlank;
import java.util.List;
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
public class UpdateCategoryRequest {

  @NotBlank(message = "Category name can not be empty")
  private String name;

  private List<UpdateItemRequest> items;
}
