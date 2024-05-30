package com.OS.api.products.repository;

import com.OS.api.products.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

   @Query("SELECT p FROM ProductModel p " +
          "WHERE (:name IS NULL OR p.name = :name) " +
          "AND (:description IS NULL OR p.description = :description) " +
          "AND p.dateRemoved IS NULL")
   Page<ProductModel> findAllByParams(
           @Param("name") String name,
           @Param("description")
           String description, Pageable pageable);
}
