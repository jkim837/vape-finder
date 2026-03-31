package com.jake.vapefinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
  
    private Long id;
    private String name;
    private BrandDTO brand;
    private String address;
    private String city;
    private String postcode;
    private String country;
    private String phone;
    private String email;
    private String website;
    private String openTime;
    private String closeTime;
}
