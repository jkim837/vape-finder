package com.jake.vapefinder.mapper;

import org.mapstruct.Mapper;

import com.jake.vapefinder.dto.ProductDTO;
import com.jake.vapefinder.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product product);
    Product toEntity(ProductDTO productDTO);
}