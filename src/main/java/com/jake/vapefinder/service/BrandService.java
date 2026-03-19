package com.jake.vapefinder.service;

import com.jake.vapefinder.dto.BrandDto;
import com.jake.vapefinder.model.Brand;
import com.jake.vapefinder.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDto> getAllBrands() {
        // TODO: load from repo and map to DTOs
        return List.of();
    }

    public BrandDto createBrand(BrandDto dto) {
        // TODO: map dto -> entity, save, map back to dto
        return null;
    }

    // Helper methods for mapping between Brand and BrandDto will go here.
}