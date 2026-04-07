package com.jake.vapefinder.service;

import com.jake.vapefinder.dto.BrandDTO;
import com.jake.vapefinder.dto.ListingDTO;
import com.jake.vapefinder.dto.ProductDTO;
import com.jake.vapefinder.dto.StoreDTO;
import com.jake.vapefinder.model.Listing;
import com.jake.vapefinder.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    private ListingDTO toDto(Listing listing) {
        BrandDTO brandDTO = null;
        if (listing.getProduct().getBrand() != null) {
            brandDTO = new BrandDTO(
                    listing.getProduct().getBrand().getId(),
                    listing.getProduct().getBrand().getName()
            );
        }
        ProductDTO productDTO = new ProductDTO(
                listing.getProduct().getId(),
                listing.getProduct().getName(),
                listing.getProduct().getCategory(),
                brandDTO
        );

        BrandDTO storeBrandDTO = null;
        if (listing.getStore().getBrand() != null) {
            storeBrandDTO = new BrandDTO(
                    listing.getStore().getBrand().getId(),
                    listing.getStore().getBrand().getName()
            );
        }
        StoreDTO storeDTO = new StoreDTO(
                listing.getStore().getId(),
                listing.getStore().getName(),
                storeBrandDTO,
                listing.getStore().getAddress(),
                listing.getStore().getCity(),
                listing.getStore().getPostcode(),
                listing.getStore().getCountry(),
                listing.getStore().getPhone(),
                listing.getStore().getEmail(),
                listing.getStore().getWebsite(),
                listing.getStore().getOpenTime(),
                listing.getStore().getCloseTime()
        );

        return new ListingDTO(
                listing.getId(),
                productDTO,
                storeDTO,
                listing.getStockLeft(),
                listing.getPrice()
        );
    }

    public List<ListingDTO> getAllListings() {
        return listingRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ListingDTO getListingById(Long id) {
        Listing listing = listingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Listing not found"));
        return toDto(listing);
    }

    public ListingDTO createListing(ListingDTO listingDTO) {
        Listing listing = new Listing();
        listing.setStockLeft(listingDTO.getStockLeft());
        listing.setPrice(listingDTO.getPrice());
        return toDto(listingRepository.save(listing));
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }

    public List<ListingDTO> getListingsByProductId(Long productId) {
        return listingRepository.findByProductId(productId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}