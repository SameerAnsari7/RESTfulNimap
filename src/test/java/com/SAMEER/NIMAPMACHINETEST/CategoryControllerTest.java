package com.SAMEER.NIMAPMACHINETEST;

import com.SAMEER.NIMAPMACHINETEST.model.Category;
import com.SAMEER.NIMAPMACHINETEST.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        categoryRepository.deleteAll();
    }

    @Test
    public void testCreateCategory() throws Exception {
        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Category\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateCategory() throws Exception {
        // Create a category first
        Category savedCategory = categoryRepository.save(new Category(null, "Old Name"));

        mockMvc.perform(put("/api/categories/" + savedCategory.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Name\"}"))
                .andExpect(status().isOk());

        // Verify the update
        mockMvc.perform(get("/api/categories/" + savedCategory.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

    @Test
    public void testDeleteCategory() throws Exception {
        // Create a category to delete
        Category savedCategory = categoryRepository.save(new Category(null, "To Be Deleted"));

        mockMvc.perform(delete("/api/categories/" + savedCategory.getId()))
                .andExpect(status().isNoContent());

        // Verify the category is deleted
        mockMvc.perform(get("/api/categories/" + savedCategory.getId()))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetCategory_NotFound() throws Exception {
        mockMvc.perform(get("/api/categories/999"))
                .andExpect(status().isNotFound());
    }

    // Additional Test Cases

    @Test
    public void testGetAllCategories_Empty() throws Exception {
        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isEmpty()); // Change here to check content
    }

    @Test
    public void testUpdateCategory_NotFound() throws Exception {
        mockMvc.perform(put("/api/categories/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Name\"}"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteCategory_NotFound() throws Exception {
        mockMvc.perform(delete("/api/categories/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetCategoryById() throws Exception {
        // Create a category first
        Category savedCategory = categoryRepository.save(new Category(null, "Category A"));

        mockMvc.perform(get("/api/categories/" + savedCategory.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Category A"));
    }

    @Test
    public void testUpdateCategory_Valid() throws Exception {
        // Create a category first
        Category savedCategory = categoryRepository.save(new Category(null, "Old Name"));

        mockMvc.perform(put("/api/categories/" + savedCategory.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Name\"}"))
                .andExpect(status().isOk());

        // Verify the update
        mockMvc.perform(get("/api/categories/" + savedCategory.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }
}
