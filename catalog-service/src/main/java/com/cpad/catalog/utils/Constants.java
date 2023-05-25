package com.cpad.catalog.utils;

import lombok.Getter;

@Getter
public enum Constants {
  CATEGORY_ALREADY_EXISTS_EXCEPTION("The category already exists."),
  ITEM_ALREADY_EXISTS_EXCEPTION("The item already exists."),
  CATEGORY_NAME_CAN_NOT_BE_EMPTY_EXCEPTION("Category name can not be empty."),
  ITEM_NAME_CAN_NOT_BE_EMPTY_EXCEPTION("Item name can not be empty."),
  CATEGORY_NOT_FOUND("Category not found."),
  CATEGORY_CREATED_SUCCESSFULLY("Category created successfully."),
  ID_CAN_NOT_BE_EMPTY("Id can not be empty"),
  INVALID_ID("The id is invalid");

  private final String name;

  Constants(String label) {
    this.name = label;
  }
}
