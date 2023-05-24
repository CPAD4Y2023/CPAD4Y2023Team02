package com.cpad.catalog.services;

import com.cpad.catalog.dtos.common.CreateCategoryDTO;
import com.cpad.catalog.dtos.common.CreateItemDTO;
import com.cpad.catalog.entities.Category;
import com.cpad.catalog.entities.Item;
import com.cpad.catalog.exceptions.child.CategoryAlreadyExistsException;
import com.cpad.catalog.exceptions.child.ItemAlreadyExistsException;
import com.cpad.catalog.repositories.CategoryRepository;
import com.cpad.catalog.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryService {

    private ItemService itemService;
    private CategoryRepository categoryRepository;

    public void createCategory(CreateCategoryDTO createCategoryRequest) throws CategoryAlreadyExistsException, ItemAlreadyExistsException {

        validateCategoryRequest(createCategoryRequest);

        Category category = getCategoryFromRequest(createCategoryRequest);

        categoryRepository.save(category);
    }

    private void validateCategoryRequest(CreateCategoryDTO createCategoryRequest) throws CategoryAlreadyExistsException, ItemAlreadyExistsException {

        createCategoryRequest.setName(createCategoryRequest.getName().trim());

        final Optional<Category> categoryOptional = categoryRepository
                .findByNameIgnoreCase(createCategoryRequest.getName());

        if (categoryOptional.isPresent()) {
            throw new CategoryAlreadyExistsException(Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION.getName());
        }

        if (!CollectionUtils.isEmpty(createCategoryRequest.getItems())) {
            boolean areValidItems = itemService.validateItemsRequest(createCategoryRequest.getItems());
            if (!areValidItems)
                throw new ItemAlreadyExistsException(Constants.ITEM_ALREADY_EXISTS_EXCEPTION.getName());
        }
    }

    private Category getCategoryFromRequest(CreateCategoryDTO createCategoryRequest) {
        Category category = Category.builder()
                .name(createCategoryRequest.getName())
                .build();

        if (!CollectionUtils.isEmpty(createCategoryRequest.getItems())) {
            mapItemsFromRequestToCategory(category, createCategoryRequest.getItems());
        }

        return category;
    }

    private void mapItemsFromRequestToCategory(Category category, Set<CreateItemDTO> itemsRequest) {
        final Set<Item> items = new HashSet<>();
        itemsRequest.forEach(itemRequest -> items.add(itemService.getItemFromItemRequest(itemRequest)));

        category.setItems(items);
    }
}
