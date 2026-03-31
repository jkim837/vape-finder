package com.jake.vapefinder.mapper;

import org.mapstruct.Mapper;

import com.jake.vapefinder.dto.BrandDTO;
import com.jake.vapefinder.model.Brand;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandDTO toDto(Brand brand);
    Brand toEntity(BrandDTO brandDTO);
}