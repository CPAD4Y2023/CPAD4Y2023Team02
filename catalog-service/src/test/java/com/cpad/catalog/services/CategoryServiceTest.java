package com.cpad.catalog.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cpad.catalog.dtos.request.CreateCategoryRequest;
import com.cpad.catalog.dtos.request.CreateItemRequest;
import com.cpad.catalog.dtos.request.UpdateCategoryRequest;
import com.cpad.catalog.dtos.response.CategoryResponse;
import com.cpad.catalog.entities.Category;
import com.cpad.catalog.entities.Item;
import com.cpad.catalog.exceptions.child.CategoryAlreadyExistsException;
import com.cpad.catalog.exceptions.parent.BadRequestException;
import com.cpad.catalog.exceptions.parent.NotFoundException;
import com.cpad.catalog.fixtures.DataFixture;
import com.cpad.catalog.repositories.CategoryRepository;
import com.cpad.catalog.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

  @Mock private ItemService mockItemService;
  @Mock private CategoryRepository mockCategoryRepository;

  private CategoryService categoryService;

  @BeforeEach
  void setUp() {
    categoryService = new CategoryService(mockItemService, mockCategoryRepository);
  }

  @Test
  void whenValidRequestShouldCreateCategoryWithItem() throws Exception {
    // Setup
    final CreateCategoryRequest createCategoryRequest = DataFixture.getCreateCategoryRequest();
    final Category category = DataFixture.getCategory();
    final Item item = DataFixture.getItem();
    when(mockCategoryRepository.findByNameIgnoreCase(anyString())).thenReturn(Optional.empty());
    when(mockItemService.getItemFromItemRequest(any(CreateItemRequest.class))).thenReturn(item);
    when(mockCategoryRepository.save(any(Category.class))).thenReturn(category);

    // Run the test
    final CategoryResponse result = categoryService.createCategory(createCategoryRequest);

    // Verify the results
    assertThat(result.getName()).isEqualTo(createCategoryRequest.getName());
    assertThat(result.getImageLocation()).isEqualTo(createCategoryRequest.getImageLocation());
    assertThat(result.getItems().isEmpty()).isFalse();
    assertThat(result.getItems().size()).isEqualTo(2);
  }

  @Test
  void whenCategoryWithNameAlreadyPresentThenCreateCategoryThrowException() {
    // Setup
    final CreateCategoryRequest createCategoryRequest = DataFixture.getCreateCategoryRequest();
    final Category category = DataFixture.getCategory();

    when(mockCategoryRepository.findByNameIgnoreCase(anyString()))
        .thenReturn(Optional.of(category));

    // Run and Verify the test
    assertThatThrownBy(() -> categoryService.createCategory(createCategoryRequest))
        .isInstanceOf(CategoryAlreadyExistsException.class)
        .hasMessage(
            String.format(
                Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION.getName(), category.getName()));
  }

  @Test
  void whenCategoryNameInRequestIsEmptyThenCreateCategoryThrowException() {
    // Setup
    final CreateCategoryRequest createCategoryRequest = DataFixture.getCreateCategoryRequest();
    createCategoryRequest.setName("");
    final Category category = DataFixture.getCategory();

    // Run and Verify the test
    assertThatThrownBy(() -> categoryService.createCategory(createCategoryRequest))
        .isInstanceOf(BadRequestException.class)
        .hasMessage(Constants.CATEGORY_NAME_CAN_NOT_BE_EMPTY_EXCEPTION.getName());
  }

  @Test
  void shouldReturnAllCategories() {
    // Setup
    final Category category = DataFixture.getCategory();
    when(mockCategoryRepository.findAll()).thenReturn(List.of(category));

    // Run the test
    final List<CategoryResponse> allCategories = categoryService.getAllCategories();

    // Verify the results
    assertThat(allCategories.get(0).getName()).isEqualTo(category.getName());
    assertThat(allCategories.get(0).getImageLocation()).isEqualTo(category.getImageLocation());
    assertThat(allCategories.get(0).getItems().isEmpty()).isFalse();
    assertThat(allCategories.get(0).getItems().size()).isEqualTo(2);
    assertThat(allCategories.get(0).getItems().get(0).getName())
        .isEqualTo(category.getItems().stream().toList().get(0).getName());
    assertThat(allCategories.get(0).getItems().get(0).getImageLocation())
        .isEqualTo(category.getItems().stream().toList().get(0).getImageLocation());
    assertThat(allCategories.get(0).getItems().get(0).getMetric())
        .isEqualTo(category.getItems().stream().toList().get(0).getMetric());
    assertThat(allCategories.get(0).getItems().get(0).getDescription())
        .isEqualTo(category.getItems().stream().toList().get(0).getDescription());
  }

  @Test
  void shouldReturnEmptyCategories() {
    // Setup
    final Category category = DataFixture.getCategory();
    when(mockCategoryRepository.findAll()).thenReturn(new ArrayList<>());

    // Run the test
    final List<CategoryResponse> allCategories = categoryService.getAllCategories();

    // Verify the results
    assertThat(allCategories.isEmpty()).isTrue();
  }

  @Test
  void shouldReturnCategoryById() throws NotFoundException, BadRequestException {
    // Setup
    final Category category = DataFixture.getCategory();
    when(mockCategoryRepository.findById(anyString())).thenReturn(Optional.of(category));

    // Run the test
    final CategoryResponse result = categoryService.getCategoryById("1");

    // Verify the results
    assertThat(result.getId()).isEqualTo(category.getId().toString());
    assertThat(result.getName()).isEqualTo(category.getName());
    assertThat(result.getImageLocation()).isEqualTo(category.getImageLocation());
    assertThat(result.getItems().isEmpty()).isFalse();
    assertThat(result.getItems().size()).isEqualTo(2);
    assertThat(result.getItems().get(0).getName())
        .isEqualTo(category.getItems().stream().toList().get(0).getName());
    assertThat(result.getItems().get(0).getImageLocation())
        .isEqualTo(category.getItems().stream().toList().get(0).getImageLocation());
    assertThat(result.getItems().get(0).getMetric())
        .isEqualTo(category.getItems().stream().toList().get(0).getMetric());
    assertThat(result.getItems().get(0).getDescription())
        .isEqualTo(category.getItems().stream().toList().get(0).getDescription());
  }

  @Test
  void whenInvalidIDThenGetCategoryByIdShouldThrowException() {
    // Setup
    final Category category = DataFixture.getCategory();

    // Run and Verify the test
    assertThatThrownBy(() -> categoryService.getCategoryById("One"))
        .isInstanceOf(BadRequestException.class)
        .hasMessage(Constants.INVALID_ID.getName());
  }

  @Test
  void whenInvalidIDThenGetCategoryByIdShouldThrowException2() {
    // Setup
    final Category category = DataFixture.getCategory();

    // Run and Verify the test
    assertThatThrownBy(() -> categoryService.getCategoryById(""))
        .isInstanceOf(BadRequestException.class)
        .hasMessage(Constants.ID_CAN_NOT_BE_EMPTY.getName());
  }

  @Test
  void whenCategoryDoesNotExistsThenGetCategoryByIdShouldThrowException() {
    // Setup
    when(mockCategoryRepository.findById(anyString())).thenReturn(Optional.empty());

    // Run and Verify the test
    assertThatThrownBy(() -> categoryService.getCategoryById("1"))
        .isInstanceOf(NotFoundException.class)
        .hasMessage(Constants.CATEGORY_DOES_NOT_EXISTS.getName());
  }

  @Test
  void testDeleteCategoryById() throws BadRequestException {
    // Setup
    doNothing().when(mockCategoryRepository).deleteById(anyString());

    // Run the test
    categoryService.deleteCategoryById("1");

    // Verify the results
    verify(mockCategoryRepository, times(1)).deleteById(anyString());
  }

  @Test
  void whenCategoryIdIsInvalidThenDeleteCategoryShouldThrowException() {
    // Run and Verify the test
    assertThatThrownBy(() -> categoryService.deleteCategoryById("One"))
        .isInstanceOf(BadRequestException.class)
        .hasMessage(Constants.INVALID_ID.getName());
  }

  @Test
  void whenCategoryIdIsInvalidThenDeleteCategoryShouldThrowException2() {
    // Run and Verify the test
    assertThatThrownBy(() -> categoryService.deleteCategoryById(""))
        .isInstanceOf(BadRequestException.class)
        .hasMessage("Id can not be empty");
  }

  // -- Test Part 2

  @Test
  void whenValidUpdateRequestThenShouldUpdateCategory()
      throws BadRequestException, NotFoundException {
    // Setup
    final UpdateCategoryRequest updateCategoryRequest = DataFixture.getUpdateCategoryRequest();
    final Category category = DataFixture.getCategory();
    when(mockCategoryRepository.findById(anyString())).thenReturn(Optional.of(category));
    when(mockCategoryRepository.existsByNameIgnoreCaseAndIdNotIn(anyString(), anyList()))
        .thenReturn(false);
    when(mockCategoryRepository.save(any(Category.class))).thenReturn(category);

    // Run the test
    final CategoryResponse result = categoryService.updateCategory("1", updateCategoryRequest);

    // Verify the results
    assertThat(result.getId()).isEqualTo(category.getId().toString());
    assertThat(result.getName()).isEqualTo(category.getName());
    assertThat(result.getImageLocation()).isEqualTo(category.getImageLocation());
    assertThat(result.getItems().isEmpty()).isFalse();
    assertThat(result.getItems().size()).isEqualTo(2);
    assertThat(result.getItems().get(0).getName())
        .isEqualTo(category.getItems().stream().toList().get(0).getName());
    assertThat(result.getItems().get(0).getImageLocation())
        .isEqualTo(category.getItems().stream().toList().get(0).getImageLocation());
    assertThat(result.getItems().get(0).getMetric())
        .isEqualTo(category.getItems().stream().toList().get(0).getMetric());
    assertThat(result.getItems().get(0).getDescription())
        .isEqualTo(category.getItems().stream().toList().get(0).getDescription());
  }

  @Test
  void whenInvalidUpdateRequestThenShouldThrowException() {
    // Setup
    final UpdateCategoryRequest updateCategoryRequest = DataFixture.getUpdateCategoryRequest();
    updateCategoryRequest.getItems().get(0).setId(3L);
    final Category category = DataFixture.getCategory();
    when(mockCategoryRepository.findById(anyString())).thenReturn(Optional.of(category));
    when(mockCategoryRepository.existsByNameIgnoreCaseAndIdNotIn(anyString(), anyList()))
        .thenReturn(false);

    // Run and Verify the test
    assertThatThrownBy(() -> categoryService.updateCategory("1", updateCategoryRequest))
        .isInstanceOf(BadRequestException.class)
        .hasMessage("Item not found.");
  }

  @Test
  void whenInvalidUpdateRequestThenShouldThrowException2() {
    // Setup
    final UpdateCategoryRequest updateCategoryRequest = DataFixture.getUpdateCategoryRequest();
    updateCategoryRequest.setName("Papers");
    final Category category = DataFixture.getCategory();
    when(mockCategoryRepository.findById(anyString())).thenReturn(Optional.of(category));
    when(mockCategoryRepository.existsByNameIgnoreCaseAndIdNotIn(anyString(), anyList()))
        .thenReturn(true);

    // Run and Verify the test
    assertThatThrownBy(() -> categoryService.updateCategory("1", updateCategoryRequest))
        .isInstanceOf(CategoryAlreadyExistsException.class)
        .hasMessage(
            String.format(
                Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION.getName(),
                updateCategoryRequest.getName()));
  }
}
