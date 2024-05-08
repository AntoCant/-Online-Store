package com.OS.api.products.repository;

import com.OS.api.products.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
}