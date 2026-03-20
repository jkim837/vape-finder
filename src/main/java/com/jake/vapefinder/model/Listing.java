package com.jake.vapefinder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "listing")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "product_id")
     private Product product;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "store_id")
     private Store store;

    private int stockLeft;
    private BigDecimal price;
}