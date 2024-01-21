package com.tuyenngoc.bookstore.domain.dto;

import com.tuyenngoc.bookstore.constant.ErrorMessage;
import com.tuyenngoc.bookstore.domain.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Integer id;

    @NotBlank(message = ErrorMessage.INVALID_NOT_BLANK_FIELD)
    private String name;

    @NotBlank(message = ErrorMessage.INVALID_NOT_BLANK_FIELD)
    private String image;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.image = category.getImage();
    }
}