package com.jake.vapefinder.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ListingDTO {

    private Long id;
    private ProductDTO product;
    private StoreDTO store;
    private int stockLeft;
    private BigDecimal price;
}
