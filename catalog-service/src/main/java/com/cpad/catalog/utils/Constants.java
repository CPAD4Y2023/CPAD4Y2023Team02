package com.cpad.catalog.utils;

import lombok.Getter;

@Getter
public enum Constants {
    CATEGORY_ALREADY_EXISTS_EXCEPTION("The category already exists"),
    ITEM_ALREADY_EXISTS_EXCEPTION("Item already exists");

    private final String name;

    Constants(String label) {
        this.name = label;
    }
}
