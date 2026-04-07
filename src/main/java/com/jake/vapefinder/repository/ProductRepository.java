package com.jake.vapefinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jake.vapefinder.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  // enables searching for products by name or category using a case-insensitive search
@Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(p.category) LIKE LOWER(CONCAT('%', :search, '%'))")
List<Product> search(@Param("search") String search);
}