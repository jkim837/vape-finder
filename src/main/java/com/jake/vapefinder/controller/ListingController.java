package com.jake.vapefinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jake.vapefinder.dto.ListingDTO;
import com.jake.vapefinder.service.ListingService;


@RestController
@RequestMapping("/api/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping
    public List<ListingDTO> getAllListings() {
        return listingService.getAllListings();
    }

    @GetMapping("/{id}")
    public ListingDTO getListingById(@PathVariable Long id) {
        return listingService.getListingById(id);
    }

    @PostMapping
    public ListingDTO createListing(@RequestBody ListingDTO listingDTO) {
        return listingService.createListing(listingDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
    }

    @GetMapping("/search/{productId}") // New endpoint for searching listings by product ID
    public List<ListingDTO> getListingsByProductId(@PathVariable Long productId) {
        return listingService.getListingsByProductId(productId);
    }
    
}