package com.jake.vapefinder.service;

import com.jake.vapefinder.model.Listing;
import com.jake.vapefinder.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    public Listing getListingById(Long id) {
        return listingRepository.findById(id).orElseThrow(() -> new RuntimeException("Listing not found"));
    }

    public Listing createListing(Listing listing) {
        return listingRepository.save(listing);
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }
}