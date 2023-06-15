package com.cpad.catalog.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.cpad.catalog.dtos.request.CreateCategoryRequest;
import com.cpad.catalog.dtos.response.CategoryResponse;
import com.cpad.catalog.dtos.response.ItemResponse;
import com.cpad.catalog.exceptions.parent.BadRequestException;
import com.cpad.catalog.services.CategoryService;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@Disabled
@ExtendWith(SpringExtension.class)
@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private CategoryService mockCategoryService;

  @Test
  void testCreateCategory() throws Exception {
    // Setup
    when(mockCategoryService.createCategory(any(CreateCategoryRequest.class)))
        .thenReturn(
            CategoryResponse.builder()
                .id("1")
                .name("Paper")
                .imageLocation("image/categories/Papers.jpg")
                .items(
                    List.of(
                        ItemResponse.builder()
                            .id("1")
                            .name("Cardboards")
                            .imageLocation("image/categories/Cardboards.jpg")
                            .metric("oz")
                            .description("Cardboards are papers")
                            .build(),
                        ItemResponse.builder()
                            .id("2")
                            .name("Newspapers")
                            .imageLocation("image/categories/Newspapers.jpg")
                            .metric("kg")
                            .description("Newspapers are papers")
                            .build()))
                .build());

    // Run the test
    final MockHttpServletResponse response =
        mockMvc
            .perform(
                post("/api/v1/categories")
                    .content(
                        "{\n"
                            + "    \"name\": \"Paper\",\n"
                            + "    \"imageLocation\": \"image/categories/Papers.jpg\",\n"
                            + "    \"items\": [\n"
                            + "        {\n"
                            + "            \"name\": \"Newspapers\",\n"
                            + "            \"imageLocation\": \"image/categories/Newspapers.jpg\",\n"
                            + "            \"description\": \"Newspapers are papers\",\n"
                            + "            \"metric\": \"kg\"\n"
                            + "        },\n"
                            + "        {\n"
                            + "            \"name\": \"Cardboards\",\n"
                            + "            \"imageLocation\": \"image/categories/Cardboards.jpg\",\n"
                            + "            \"description\": \"Cardboards are papers\",\n"
                            + "            \"metric\": \"oz\"\n"
                            + "        }\n"
                            + "    ]\n"
                            + "}")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    // Verify the results
    assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    JSONAssert.assertEquals(
        "{\n"
            + "    \"data\": {\n"
            + "        \"id\": \"1\",\n"
            + "        \"name\": \"Paper\",\n"
            + "        \"imageLocation\": \"image/categories/Papers.jpg\",\n"
            + "        \"items\": [\n"
            + "            {\n"
            + "                \"id\": \"1\",\n"
            + "                \"name\": \"Cardboards\",\n"
            + "                \"imageLocation\": \"image/categories/Cardboards.jpg\",\n"
            + "                \"metric\": \"oz\",\n"
            + "                \"description\": \"Cardboards are papers\"\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": \"2\",\n"
            + "                \"name\": \"Newspapers\",\n"
            + "                \"imageLocation\": \"image/categories/Newspapers.jpg\",\n"
            + "                \"metric\": \"kg\",\n"
            + "                \"description\": \"Newspapers are papers\"\n"
            + "            }\n"
            + "        ]\n"
            + "    },\n"
            + "    \"message\": \"Category created successfully.\"\n"
            + "}",
        response.getContentAsString(),
        false);
  }

  @Test
  void testCreateCategory_CategoryServiceThrowsBadRequestException() throws Exception {
    // Setup
    when(mockCategoryService.createCategory(any(CreateCategoryRequest.class)))
        .thenThrow(BadRequestException.class);

    // Run the test
    final MockHttpServletResponse response =
        mockMvc
            .perform(
                post("/api/v1/categories")
                    .content(
                        "{\n"
                            + "    \"data\": {\n"
                            + "        \"id\": \"1\",\n"
                            + "        \"name\": \"Paper\",\n"
                            + "        \"imageLocation\": \"image/categories/Papers.jpg\",\n"
                            + "        \"items\": [\n"
                            + "            {\n"
                            + "                \"id\": \"1\",\n"
                            + "                \"name\": \"Cardboards\",\n"
                            + "                \"imageLocation\": \"image/categories/Cardboards.jpg\",\n"
                            + "                \"metric\": \"oz\",\n"
                            + "                \"description\": \"Cardboards are papers\"\n"
                            + "            },\n"
                            + "            {\n"
                            + "                \"id\": \"2\",\n"
                            + "                \"name\": \"Newspapers\",\n"
                            + "                \"imageLocation\": \"image/categories/Newspapers.jpg\",\n"
                            + "                \"metric\": \"kg\",\n"
                            + "                \"description\": \"Newspapers are papers\"\n"
                            + "            }\n"
                            + "        ]\n"
                            + "    },\n"
                            + "    \"message\": \"Category created successfully.\"\n"
                            + "}")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    // Verify the results
    assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    //        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  }

  //  @Test
  //  void testGetAllCategories() throws Exception {
  //    // Setup
  //    // Configure CategoryService.getAllCategories(...).
  //    final List<CategoryResponse> categoryResponses =
  // List.of(CategoryResponse.builder().build());
  //    when(mockCategoryService.getAllCategories()).thenReturn(categoryResponses);
  //
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(get("/api/v1/categories").accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
  //    assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  //  }
  //
  //  @Test
  //  void testGetAllCategories_CategoryServiceReturnsNoItems() throws Exception {
  //    // Setup
  //    when(mockCategoryService.getAllCategories()).thenReturn(Collections.emptyList());
  //
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(get("/api/v1/categories").accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
  //    assertThat(response.getContentAsString()).isEqualTo("[]");
  //  }
  //
  //  @Test
  //  void testGetCategoryById() throws Exception {
  //    // Setup
  //
  // when(mockCategoryService.getCategoryById("id")).thenReturn(CategoryResponse.builder().build());
  //
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(get("/api/v1/categories/{id}", "id").accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
  //    assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  //  }
  //
  //  @Test
  //  void testGetCategoryById_CategoryServiceThrowsNotFoundException() throws Exception {
  //    // Setup
  //    when(mockCategoryService.getCategoryById("id")).thenThrow(NotFoundException.class);
  //
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(get("/api/v1/categories/{id}", "id").accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
  //    assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  //  }
  //
  //  @Test
  //  void testGetCategoryById_CategoryServiceThrowsBadRequestException() throws Exception {
  //    // Setup
  //    when(mockCategoryService.getCategoryById("id")).thenThrow(BadRequestException.class);
  //
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(get("/api/v1/categories/{id}", "id").accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
  //    assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  //  }
  //
  //  @Test
  //  void testUpdateCategory() throws Exception {
  //    // Setup
  //    when(mockCategoryService.updateCategory(eq("id"), any(UpdateCategoryRequest.class)))
  //        .thenReturn(CategoryResponse.builder().build());
  //
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(
  //                put("/api/v1/categories/{id}", "id")
  //                    .content(
  //                        "{\n"
  //                            + "    \"name\": \"Paper\",\n"
  //                            + "    \"imageLocation\": \"image/categories/Papers.jpg\",\n"
  //                            + "    \"items\": [\n"
  //                            + "        {\n"
  //                            + "            \"id\": \"1\",\n"
  //                            + "            \"name\": \"Newspapers\",\n"
  //                            + "            \"imageLocation\":
  // \"image/categories/Newspapers.jpg\",\n"
  //                            + "            \"description\": \"Newspapers are papers\",\n"
  //                            + "            \"metric\": \"kg\"\n"
  //                            + "        },\n"
  //                            + "        {\n"
  //                            + "            \"id\": \"2\",\n"
  //                            + "            \"name\": \"Cardboards\",\n"
  //                            + "            \"imageLocation\":
  // \"image/categories/Cardboards.jpg\",\n"
  //                            + "            \"description\": \"Cardboards are papers\",\n"
  //                            + "            \"metric\": \"oz\"\n"
  //                            + "        }\n"
  //                            + "    ]\n"
  //                            + "}")
  //                    .contentType(MediaType.APPLICATION_JSON)
  //                    .accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
  //    assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  //  }
  //
  //  @Test
  //  void testUpdateCategory_CategoryServiceThrowsBadRequestException() throws Exception {
  //    // Setup
  //    when(mockCategoryService.updateCategory(eq("id"), any(UpdateCategoryRequest.class)))
  //        .thenThrow(BadRequestException.class);
  //
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(
  //                put("/api/v1/categories/{id}", "id")
  //                    .content(
  //                        "{\n"
  //                            + "    \"name\": \"Paper\",\n"
  //                            + "    \"imageLocation\": \"image/categories/Papers.jpg\",\n"
  //                            + "    \"items\": [\n"
  //                            + "        {\n"
  //                            + "            \"id\": \"1\",\n"
  //                            + "            \"name\": \"Newspapers\",\n"
  //                            + "            \"imageLocation\":
  // \"image/categories/Newspapers.jpg\",\n"
  //                            + "            \"description\": \"Newspapers are papers\",\n"
  //                            + "            \"metric\": \"kg\"\n"
  //                            + "        },\n"
  //                            + "        {\n"
  //                            + "            \"id\": \"2\",\n"
  //                            + "            \"name\": \"Cardboards\",\n"
  //                            + "            \"imageLocation\":
  // \"image/categories/Cardboards.jpg\",\n"
  //                            + "            \"description\": \"Cardboards are papers\",\n"
  //                            + "            \"metric\": \"oz\"\n"
  //                            + "        }\n"
  //                            + "    ]\n"
  //                            + "}")
  //                    .contentType(MediaType.APPLICATION_JSON)
  //                    .accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
  //    assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  //  }
  //
  //  @Test
  //  void testUpdateCategory_CategoryServiceThrowsNotFoundException() throws Exception {
  //    // Setup
  //    when(mockCategoryService.updateCategory(eq("id"), any(UpdateCategoryRequest.class)))
  //        .thenThrow(NotFoundException.class);
  //
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(
  //                put("/api/v1/categories/{id}", "id")
  //                    .content(
  //                        "{\n"
  //                            + "    \"name\": \"Paper\",\n"
  //                            + "    \"imageLocation\": \"image/categories/Papers.jpg\",\n"
  //                            + "    \"items\": [\n"
  //                            + "        {\n"
  //                            + "            \"id\": \"1\",\n"
  //                            + "            \"name\": \"Newspapers\",\n"
  //                            + "            \"imageLocation\":
  // \"image/categories/Newspapers.jpg\",\n"
  //                            + "            \"description\": \"Newspapers are papers\",\n"
  //                            + "            \"metric\": \"kg\"\n"
  //                            + "        },\n"
  //                            + "        {\n"
  //                            + "            \"id\": \"2\",\n"
  //                            + "            \"name\": \"Cardboards\",\n"
  //                            + "            \"imageLocation\":
  // \"image/categories/Cardboards.jpg\",\n"
  //                            + "            \"description\": \"Cardboards are papers\",\n"
  //                            + "            \"metric\": \"oz\"\n"
  //                            + "        }\n"
  //                            + "    ]\n"
  //                            + "}")
  //                    .contentType(MediaType.APPLICATION_JSON)
  //                    .accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
  //    assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  //  }
  //
  //  @Test
  //  void testDeleteCategoryById() throws Exception {
  //    // Setup
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(delete("/api/v1/categories/{id}", "id").accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
  //    assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  //    verify(mockCategoryService).deleteCategoryById("id");
  //  }
  //
  //  @Test
  //  void testDeleteCategoryById_CategoryServiceThrowsBadRequestException() throws Exception {
  //    // Setup
  //    doThrow(BadRequestException.class).when(mockCategoryService).deleteCategoryById("id");
  //
  //    // Run the test
  //    final MockHttpServletResponse response =
  //        mockMvc
  //            .perform(delete("/api/v1/categories/{id}", "id").accept(MediaType.APPLICATION_JSON))
  //            .andReturn()
  //            .getResponse();
  //
  //    // Verify the results
  //    assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
  //    assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
  //  }
}
