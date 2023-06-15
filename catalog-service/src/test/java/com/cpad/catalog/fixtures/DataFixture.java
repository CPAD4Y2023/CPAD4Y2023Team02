package com.cpad.catalog.fixtures;

import com.cpad.catalog.dtos.request.CreateCategoryRequest;
import com.cpad.catalog.dtos.request.CreateItemRequest;
import com.cpad.catalog.dtos.request.UpdateCategoryRequest;
import com.cpad.catalog.dtos.request.UpdateItemRequest;
import com.cpad.catalog.entities.Category;
import com.cpad.catalog.entities.Item;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataFixture {

  public static CreateCategoryRequest getCreateCategoryRequestWithNoItems() {
    return CreateCategoryRequest.builder()
        .name("Papers")
        .imageLocation("images/papers.png")
        .build();
  }

  public static CreateCategoryRequest getCreateCategoryRequest() {
    return CreateCategoryRequest.builder()
        .name("Papers")
        .imageLocation("images/papers.png")
        .items(getCreateItemRequests())
        .build();
  }

  public static CreateItemRequest getCreateItemRequest() {
    return CreateItemRequest.builder()
        .name("Newspaper")
        .description("Newspaper")
        .metric("kg")
        .imageLocation("images/newspaper.png")
        .build();
  }

  public static CreateItemRequest getCreateItemRequest2() {
    return CreateItemRequest.builder()
        .name("Cardboard")
        .description("Cardboard")
        .metric("oz")
        .imageLocation("images/cardboard.png")
        .build();
  }

  public static Set<CreateItemRequest> getCreateItemRequests() {
    return new HashSet<>(Set.of(getCreateItemRequest(), getCreateItemRequest2()));
  }

  public static Category getCategory() {
    return Category.builder()
        .id(1L)
        .name("Papers")
        .imageLocation("images/papers.png")
        .items(new HashSet<>(Set.of(getItem(), getItem2())))
        .build();
  }

  public static Item getItem() {
    return Item.builder()
        .id(1L)
        .name("Newspaper")
        .description("Newspaper")
        .imageLocation("images/newspaper.png")
        .metric("kg")
        .build();
  }

  public static Item getItem2() {
    return Item.builder()
        .id(2L)
        .name("Cardboard")
        .description("Cardboard")
        .imageLocation("images/cardboard.png")
        .metric("oz")
        .build();
  }

  public static UpdateCategoryRequest getUpdateCategoryRequest() {
    return UpdateCategoryRequest.builder()
        .name("Paper")
        .imageLocation("image/paper.svg")
        .items(getUpdateItemRequests())
        .build();
  }

  public static UpdateItemRequest getUpdateItemRequest() {
    return UpdateItemRequest.builder()
        .id(1L)
        .name("Newspaper")
        .description("Newspaper")
        .imageLocation("images/newspaper.svg")
        .metric("kgs")
        .build();
  }

  public static UpdateItemRequest getUpdateItemRequest2() {
    return UpdateItemRequest.builder()
        .name("Cardboard")
        .description("Cardboard")
        .imageLocation("images/cardboard.svg")
        .metric("oz")
        .build();
  }

  public static List<UpdateItemRequest> getUpdateItemRequests() {
    return new ArrayList<>(List.of(getUpdateItemRequest(), getUpdateItemRequest2()));
  }
}
