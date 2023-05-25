package com.cpad.catalog.services;

import com.cpad.catalog.dtos.request.CreateCategoryRequest;
import com.cpad.catalog.dtos.request.CreateItemRequest;
import com.cpad.catalog.dtos.response.CategoryResponse;
import com.cpad.catalog.entities.Category;
import com.cpad.catalog.entities.Item;
import com.cpad.catalog.exceptions.child.CategoryAlreadyExistsException;
import com.cpad.catalog.exceptions.child.ItemAlreadyExistsException;
import com.cpad.catalog.exceptions.parent.BadRequestException;
import com.cpad.catalog.exceptions.parent.NotFoundException;
import com.cpad.catalog.repositories.CategoryRepository;
import com.cpad.catalog.utils.Commons;
import com.cpad.catalog.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryService {

    private ItemService itemService;
    private CategoryRepository categoryRepository;

    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) throws BadRequestException {

        validateCategoryRequest(createCategoryRequest);

        Category category = getCategoryFromRequest(createCategoryRequest);

        final Category savedCategory = categoryRepository.save(category);

        return Commons.mapModel(savedCategory, CategoryResponse.class);
    }

    private void validateCategoryRequest(CreateCategoryRequest createCategoryRequest) throws BadRequestException {

        createCategoryRequest.setName(createCategoryRequest.getName().trim());

        if (!StringUtils.hasText(createCategoryRequest.getName()))
            throw new BadRequestException(Constants.CATEGORY_NAME_CAN_NOT_BE_EMPTY_EXCEPTION.getName());

        final Optional<Category> categoryOptional = categoryRepository
                .findByNameIgnoreCase(createCategoryRequest.getName());

        if (categoryOptional.isPresent())
            throw new CategoryAlreadyExistsException(Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION.getName());

        if (!CollectionUtils.isEmpty(createCategoryRequest.getItems())) {
            boolean areValidItems = itemService.validateItemsRequest(createCategoryRequest.getItems());
            if (!areValidItems)
                throw new ItemAlreadyExistsException(Constants.ITEM_ALREADY_EXISTS_EXCEPTION.getName());
        }
    }

    private Category getCategoryFromRequest(CreateCategoryRequest createCategoryRequest) {
        Category category = Category.builder()
                .name(createCategoryRequest.getName())
                .build();

        if (!CollectionUtils.isEmpty(createCategoryRequest.getItems()))
            mapItemsFromRequestToCategory(category, createCategoryRequest.getItems());

        return category;
    }

    private void mapItemsFromRequestToCategory(Category category, Set<CreateItemRequest> itemsRequest) {
        final Set<Item> items = new HashSet<>();

        itemsRequest.forEach(itemRequest -> {
            final Item item = itemService.getItemFromItemRequest(itemRequest);
            item.setCategory(category);
            items.add(item);
        });

        category.setItems(items);
    }

    public List<CategoryResponse> getAllCategories() {
        final List<Category> categories = categoryRepository.findAll();

        return Commons.mapModels(categories, CategoryResponse.class);
    }

    public CategoryResponse getCategoryById(String id) throws NotFoundException, BadRequestException {

        final Category category = validateIdAndGetCategoryById(id);

        return Commons.mapModel(category, CategoryResponse.class);
    }

    public void deleteCategoryById(String id) throws BadRequestException {

        Commons.validateNumericId(id);

        categoryRepository.deleteById(id);
    }

    private Category validateIdAndGetCategoryById(String id) throws BadRequestException, NotFoundException {
        Commons.validateNumericId(id);

        final Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty())
            throw new NotFoundException(Constants.CATEGORY_NOT_FOUND.getName());

        return categoryOptional.get();
    }
}
