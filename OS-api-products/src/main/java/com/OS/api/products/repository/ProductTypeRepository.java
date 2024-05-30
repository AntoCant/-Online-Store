package com.OS.api.products.repository;

import com.OS.api.products.model.ProductTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductTypeModel, Integer> {
}
