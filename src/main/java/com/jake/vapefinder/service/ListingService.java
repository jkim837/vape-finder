package com.jake.vapefinder.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jake.vapefinder.dto.ListingDTO;
import com.jake.vapefinder.mapper.ListingMapper;
import com.jake.vapefinder.model.Listing;
import com.jake.vapefinder.repository.ListingRepository;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private ListingMapper listingMapper;

    public List<ListingDTO> getAllListings() {
        return listingRepository.findAll()
                .stream()
                .map(listingMapper::toDto)
                .collect(Collectors.toList());
    }

    public ListingDTO getListingById(Long id) {
        Listing listing = listingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Listing not found"));
        return listingMapper.toDto(listing);
    }

    public ListingDTO createListing(ListingDTO listingDTO) {
        Listing listing = listingMapper.toEntity(listingDTO);
        return listingMapper.toDto(listingRepository.save(listing));
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }
}