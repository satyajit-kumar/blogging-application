package com.spring.project.Services;

import java.util.List;

import com.spring.project.payloads.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

	CategoryDto getSingleCategory(Long categoryId);

	List<CategoryDto> getAllCategories();

	void deleteSingleCategory(Long categoryId);

	void deleteAllCategories();

}
