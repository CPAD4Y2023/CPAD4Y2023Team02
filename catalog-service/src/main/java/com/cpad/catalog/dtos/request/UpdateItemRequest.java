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
public class UpdateItemRequest {

  private Long id;

  @NotBlank(message = "Item name can not be empty")
  private String name;

  @NotBlank(message = "Image location can not be empty")
  private String imageLocation;

  @NotBlank(message = "Metric location can not be empty")
  private String metric;

  @NotBlank(message = "Description name can not be empty")
  private String description;
}
