package com.spring.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.Services.CategoryService;
import com.spring.project.payloads.ApiResponse;
import com.spring.project.payloads.CategoryDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Long categoryId) {
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getSingleCategory(@PathVariable Long categoryId) {
		CategoryDto singleCategory = this.categoryService.getSingleCategory(categoryId);
		return new ResponseEntity<CategoryDto>(singleCategory, HttpStatus.FOUND);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllCategories() {
		List<CategoryDto> allCategories = this.categoryService.getAllCategories();
		return new ResponseEntity<List<CategoryDto>>(allCategories, HttpStatus.FOUND);
	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deleteSingleCategory(@PathVariable Long categoryId) {
		this.categoryService.deleteSingleCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category has been deleted successfully", true),
				HttpStatus.OK);
	}

	@DeleteMapping("/")
	public ResponseEntity<?> deleteAllCategories() {
		this.categoryService.deleteAllCategories();
		return new ResponseEntity<ApiResponse>(new ApiResponse("All Categories deleted successfully", true),
				HttpStatus.OK);
	}

}
