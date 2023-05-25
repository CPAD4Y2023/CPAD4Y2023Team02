package com.cpad.catalog.utils;

import lombok.Getter;

@Getter
public enum Constants {
    CATEGORY_ALREADY_EXISTS_EXCEPTION("The category already exists"),
    ITEM_ALREADY_EXISTS_EXCEPTION("Item already exists"),
    CATEGORY_NAME_CAN_NOT_BE_EMPTY_EXCEPTION("Category name can not be empty"),
    ITEM_NAME_CAN_NOT_BE_EMPTY_EXCEPTION("Item name can not be empty");

    private final String name;

    Constants(String label) {
        this.name = label;
    }
}
