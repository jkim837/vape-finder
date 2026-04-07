package com.jake.vapefinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jake.vapefinder.model.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
  // enables searching for listings by product ID, this is when user clicks searched product 
  // and we want to show all listings for that product
  List<Listing> findByProductId(Long productId);
}