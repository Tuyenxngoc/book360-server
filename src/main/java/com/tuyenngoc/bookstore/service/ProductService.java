package com.tuyenngoc.bookstore.service;

import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationFullRequestDto;
import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationRequestDto;
import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationResponseDto;
import com.tuyenngoc.bookstore.domain.dto.request.CreateProductRequestDto;
import com.tuyenngoc.bookstore.domain.dto.response.CommonResponseDto;
import com.tuyenngoc.bookstore.domain.dto.response.GetProductDetailResponseDto;
import com.tuyenngoc.bookstore.domain.dto.response.GetProductResponseDto;
import com.tuyenngoc.bookstore.domain.entity.Product;
import com.tuyenngoc.bookstore.domain.entity.ProductImage;

import java.util.List;

public interface ProductService {

    PaginationResponseDto<GetProductResponseDto> findProducts(PaginationFullRequestDto requestDto);

    PaginationResponseDto<GetProductResponseDto> getProducts(PaginationFullRequestDto requestDto);

    PaginationResponseDto<GetProductResponseDto> getProductsByCategoryId(int categoryId, PaginationFullRequestDto request);

    PaginationResponseDto<GetProductResponseDto> getProductsByAuthorId(int authorId, PaginationFullRequestDto requestDto);

    List<GetProductResponseDto> getProductsSameAuthor(int productId, PaginationRequestDto request);

    GetProductDetailResponseDto getProductDetail(int productId);

    int getStockQuantityProducts();

    PaginationResponseDto<Product> getProductsForAdmin(PaginationFullRequestDto requestDto, int sellerStockMax, int sellerStockMin, int soldMax, int soldMin, int categoryId);

    ProductImage createProductImage(String image, Product product);

    Product createProduct(CreateProductRequestDto productDto);

    Product getProduct(int productId);

    CommonResponseDto deleteProduct(int productId);
}
