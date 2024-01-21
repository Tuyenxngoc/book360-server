package com.tuyenngoc.bookstore.repository;

import com.tuyenngoc.bookstore.domain.dto.response.GetProductDetailResponseDto;
import com.tuyenngoc.bookstore.domain.dto.response.GetProductsResponseDto;
import com.tuyenngoc.bookstore.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new com.tuyenngoc.bookstore.domain.dto.response.GetProductsResponseDto(p) FROM Product p")
    Page<GetProductsResponseDto> getProducts(Pageable pageable);

    @Query("SELECT new com.tuyenngoc.bookstore.domain.dto.response.GetProductsResponseDto(p) FROM Product p WHERE (p.name LIKE %:keyword%) OR (p.category.name LIKE %:keyword%)")
    Page<GetProductsResponseDto> getProducts(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT new com.tuyenngoc.bookstore.domain.dto.response.GetProductsResponseDto(p) FROM Product p WHERE p.category.id= :categoryId")
    Page<GetProductsResponseDto> getProductsByCategoryId(@Param("categoryId") int categoryId, Pageable pageable);

    @Query("SELECT new com.tuyenngoc.bookstore.domain.dto.response.GetProductDetailResponseDto(p) FROM  Product p WHERE  p.id= :productId")
    Optional<GetProductDetailResponseDto> getProductDetail(@Param("productId") Integer productId);

    @Query("SELECT new com.tuyenngoc.bookstore.domain.dto.response.GetProductsResponseDto(p) FROM Product p JOIN p.authors a WHERE a IN (SELECT a FROM Product p2 JOIN p2.authors a WHERE p2.id = :productId) AND p.id <> :productId")
    Page<GetProductsResponseDto> getProductsSameAuthor(@Param("productId") Integer productId, Pageable pageable);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.stockQuantity = 0")
    int getCountProductSoldOut();

    @Query("SELECT new com.tuyenngoc.bookstore.domain.dto.response.GetProductsResponseDto(p) FROM Product p JOIN p.authors a WHERE a.id = :authorId")
    Page<GetProductsResponseDto> getProductsByAuthorId(@Param("authorId") int authorId, Pageable pageable);

    @Query("SELECT SUM(p.stockQuantity) FROM Product p")
    int getQuantityProducts();

    @Query("SELECT p FROM Product p WHERE (p.name LIKE %:keyword%) OR (p.category.name LIKE %:keyword%)")
    Page<Product> getProductsForAdmin(@Param("keyword") String keyword, Pageable pageable);

}