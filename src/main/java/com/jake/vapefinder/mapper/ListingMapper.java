package com.jake.vapefinder.mapper;

import org.mapstruct.Mapper;

import com.jake.vapefinder.dto.ListingDTO;
import com.jake.vapefinder.model.Listing;

@Mapper(componentModel = "spring")
public interface ListingMapper {
    ListingDTO toDto(Listing listing);
    Listing toEntity(ListingDTO listingDTO);
}