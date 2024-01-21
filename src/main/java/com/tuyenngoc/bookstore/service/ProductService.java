package com.tuyenngoc.bookstore.service;

import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationFullRequestDto;
import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationRequestDto;
import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationResponseDto;
import com.tuyenngoc.bookstore.domain.dto.response.GetProductDetailResponseDto;
import com.tuyenngoc.bookstore.domain.dto.response.GetProductsResponseDto;
import com.tuyenngoc.bookstore.domain.entity.Product;

import java.util.List;

public interface ProductService {

    PaginationResponseDto<GetProductsResponseDto> findProduct(PaginationFullRequestDto requestDto);

    PaginationResponseDto<GetProductsResponseDto> getProducts(PaginationFullRequestDto requestDto);

    PaginationResponseDto<GetProductsResponseDto> getProductsByCategoryId(int categoryId, PaginationFullRequestDto request);

    GetProductDetailResponseDto getProductDetail(int productId);

    List<GetProductsResponseDto> getProductsSameAuthor(int productId, PaginationRequestDto request);

    PaginationResponseDto<GetProductsResponseDto> getProductByAuthorId(int authorId, PaginationFullRequestDto requestDto);

    int getQuantityProducts();

    PaginationResponseDto<Product> getProductsForAdmin(PaginationFullRequestDto requestDto);
}
