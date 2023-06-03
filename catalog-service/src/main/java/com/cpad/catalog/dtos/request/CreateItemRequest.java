package com.cpad.catalog.dtos.request;

import jakarta.validation.constraints.NotBlank;
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
public class CreateItemRequest {

  @NotBlank(message = "Item name can not be empty")
  private String name;

  @NotBlank(message = "Item image location can not be empty")
  private String imageLocation;

  @NotBlank(message = "Item metric can not be empty")
  private String metric;

  @NotBlank(message = "Item description name can not be empty")
  private String description;
}
