package com.jake.vapefinder.controller;

import com.jake.vapefinder.dto.BrandDto;
import com.jake.vapefinder.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<BrandDto> getAllBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping
    public BrandDto createBrand(@RequestBody BrandDto dto) {
        return brandService.createBrand(dto);
    }
}