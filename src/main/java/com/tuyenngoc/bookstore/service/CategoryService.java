package com.tuyenngoc.bookstore.service;

import com.tuyenngoc.bookstore.domain.dto.CategoryDto;
import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationFullRequestDto;
import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationResponseDto;
import com.tuyenngoc.bookstore.domain.dto.response.CommonResponseDto;
import com.tuyenngoc.bookstore.domain.dto.response.GetCategoriesResponseDto;

public interface CategoryService {

    //User
    PaginationResponseDto<CategoryDto> getCategories(PaginationFullRequestDto requestDto);

    //Admin
    CategoryDto getCategory(int categoryId);

    PaginationResponseDto<GetCategoriesResponseDto> getAllCategories(PaginationFullRequestDto requestDto);

    CategoryDto createCategory(CategoryDto categoryDto);

    CommonResponseDto deleteCategory(int categoryId);

}
