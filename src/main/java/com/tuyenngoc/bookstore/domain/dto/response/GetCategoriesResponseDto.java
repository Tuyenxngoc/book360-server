package com.tuyenngoc.bookstore.domain.dto.response;

import com.tuyenngoc.bookstore.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoriesResponseDto {

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    private Integer id;

    private String name;

    private String image;

    private Integer totalProducts;

    public GetCategoriesResponseDto(Category category) {
        this.createdDate = category.getCreatedDate();
        this.lastModifiedDate = category.getLastModifiedDate();
        this.id = category.getId();
        this.name = category.getName();
        this.image = category.getImage();
        this.totalProducts = category.getProducts().size();
    }
}
