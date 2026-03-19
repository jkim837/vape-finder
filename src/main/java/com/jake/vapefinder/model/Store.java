package com.jake.vapefinder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zip;

    @Column(nullable = false)
    private String country;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String website;

    @Column(nullable = false)
    private String openTime;

    @Column(nullable = false)
    private String closeTime;
}