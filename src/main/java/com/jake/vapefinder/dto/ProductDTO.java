package com.jake.vapefinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
  
    private Long id;
    private String name;
    private String category;
    private BrandDTO brand;
}
