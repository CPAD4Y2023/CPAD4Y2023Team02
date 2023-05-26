package com.cpad.catalog.services;

import com.cpad.catalog.dtos.request.CreateCategoryRequest;
import com.cpad.catalog.dtos.request.CreateItemRequest;
import com.cpad.catalog.dtos.request.UpdateCategoryRequest;
import com.cpad.catalog.dtos.request.UpdateItemRequest;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class CategoryService {

  private ItemService itemService;
  private CategoryRepository categoryRepository;

  public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest)
      throws BadRequestException {

    validateCategoryRequest(createCategoryRequest);

    Category category = getCategoryFromRequest(createCategoryRequest);

    final Category savedCategory = categoryRepository.save(category);

    return Commons.mapModel(savedCategory, CategoryResponse.class);
  }

  private void validateCategoryRequest(CreateCategoryRequest createCategoryRequest)
      throws BadRequestException {

    createCategoryRequest.setName(createCategoryRequest.getName().trim());

    if (!StringUtils.hasText(createCategoryRequest.getName()))
      throw new BadRequestException(Constants.CATEGORY_NAME_CAN_NOT_BE_EMPTY_EXCEPTION.getName());

    final Optional<Category> categoryOptional =
        categoryRepository.findByNameIgnoreCase(createCategoryRequest.getName());

    if (categoryOptional.isPresent())
      throw new CategoryAlreadyExistsException(
          String.format(
              Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION.getName(),
              categoryOptional.get().getName()));

    if (!CollectionUtils.isEmpty(createCategoryRequest.getItems())) {
      itemService.validateItemsRequest(createCategoryRequest.getItems());
    }
  }

  private Category getCategoryFromRequest(CreateCategoryRequest createCategoryRequest) {
    Category category = Category.builder().name(createCategoryRequest.getName()).build();

    if (!CollectionUtils.isEmpty(createCategoryRequest.getItems()))
      mapItemsFromRequestToCategory(category, createCategoryRequest.getItems());

    return category;
  }

  private void mapItemsFromRequestToCategory(
      Category category, Set<CreateItemRequest> itemsRequest) {
    final Set<Item> items = new HashSet<>();

    itemsRequest.forEach(
        itemRequest -> {
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

  private Category validateIdAndGetCategoryById(String id)
      throws BadRequestException, NotFoundException {
    Commons.validateNumericId(id);

    final Optional<Category> categoryOptional = categoryRepository.findById(id);

    if (categoryOptional.isEmpty())
      throw new NotFoundException(Constants.CATEGORY_DOES_NOT_EXISTS.getName());

    return categoryOptional.get();
  }

  @Transactional
  public CategoryResponse updateCategory(String id, UpdateCategoryRequest updateCategoryRequest)
      throws BadRequestException, NotFoundException {

    final Category category = validateIdAndGetCategoryById(id);

    validateUpdateRequest(category, updateCategoryRequest);

    // Update category
    category.setName(updateCategoryRequest.getName());

    // Get the existing items of the category
    Set<Item> existingItems = category.getItems();

    Map<Long, UpdateItemRequest> updatedItemsMap =
        getItemIdAndUpdatedItemsRequestMap(updateCategoryRequest.getItems(), category);

    updateExistingItems(existingItems, updatedItemsMap);

    // Delete remaining items that were not updated
    deleteRemainingItems(existingItems, updatedItemsMap);

    final Category response = categoryRepository.save(category);

    return Commons.mapModel(response, CategoryResponse.class);
  }

  private void validateUpdateRequest(Category category, UpdateCategoryRequest updateCategoryRequest)
      throws BadRequestException {

    updateCategoryRequest.setName(updateCategoryRequest.getName().trim());

    final boolean categoryNameAlreadyPresent =
        categoryRepository.existsByNameIgnoreCaseAndIdNotIn(
            updateCategoryRequest.getName(), List.of(category.getId()));
    if (categoryNameAlreadyPresent)
      throw new ItemAlreadyExistsException(
          String.format(
              Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION.getName(),
              updateCategoryRequest.getName()));

    validateItems(category, updateCategoryRequest.getItems());
  }

  private void deleteRemainingItems(
      Set<Item> existingItems, Map<Long, UpdateItemRequest> updatedItemsMap) {
    Set<Item> removedItems = new HashSet<>();
    for (Item existingItem : existingItems) {
      if (existingItem.getId() != null) {
        if (!updatedItemsMap.containsKey(existingItem.getId())) {
          itemService.deleteItemById(existingItem.getId().toString());
          removedItems.add(existingItem);
        }
      }
    }

    existingItems.removeAll(removedItems);
  }

  private static void updateExistingItems(
      Set<Item> existingItems, Map<Long, UpdateItemRequest> updatedItemsMap) {
    // Update existing items with the request
    for (Item existingItem : existingItems) {
      if (existingItem.getId() != null) {
        UpdateItemRequest updatedItem = updatedItemsMap.get(existingItem.getId());
        if (updatedItem != null) {
          existingItem.setName(updatedItem.getName());
        }
      }
    }
  }

  private void validateItems(Category category, List<UpdateItemRequest> itemRequests)
      throws BadRequestException {
    for (UpdateItemRequest itemRequest : itemRequests) {
      if (itemRequest.getId() != null) {
        final Optional<Item> itemOptional =
            category.getItems().stream()
                .filter(item -> Objects.equals(item.getId(), itemRequest.getId()))
                .findFirst();
        if (itemOptional.isEmpty())
          throw new BadRequestException(Constants.ITEM_NOT_FOUND.getName());
      }
    }

    itemService.validateItemsNames(itemRequests);
  }

  private Map<Long, UpdateItemRequest> getItemIdAndUpdatedItemsRequestMap(
      List<UpdateItemRequest> itemRequests, Category category) {

    Map<Long, UpdateItemRequest> updatedItemsMap = new HashMap<>();

    for (UpdateItemRequest itemRequest : itemRequests) {
      if (itemRequest.getId() != null) {
        // Item with an ID, mark it for update
        updatedItemsMap.put(itemRequest.getId(), itemRequest);
      } else {
        // Item without an ID, mark it for creation
        createNewItem(category, itemRequest);
      }
    }
    return updatedItemsMap;
  }

  private void createNewItem(Category category, UpdateItemRequest itemRequest) {
    Item newItem = new Item();
    newItem.setName(itemRequest.getName());
    newItem.setCategory(category);
    category.getItems().add(newItem);
  }
}
