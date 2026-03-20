package com.jake.vapefinder.controller;

import com.jake.vapefinder.model.Listing;
import com.jake.vapefinder.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping
    public List<Listing> getAllListings() {
        return listingService.getAllListings();
    }

    @GetMapping("/{id}")
    public Listing getListingById(@PathVariable Long id) {
        return listingService.getListingById(id);
    }

    @PostMapping
    public Listing createListing(@RequestBody Listing listing) {
        return listingService.createListing(listing);
    }

    @DeleteMapping("/{id}")
    public void deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
    }
}