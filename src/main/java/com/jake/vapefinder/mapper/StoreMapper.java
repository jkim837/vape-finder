package com.jake.vapefinder.mapper;

import org.mapstruct.Mapper;

import com.jake.vapefinder.dto.StoreDTO;
import com.jake.vapefinder.model.Store;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    StoreDTO toDto(Store store);
    Store toEntity(StoreDTO storeDTO);
}