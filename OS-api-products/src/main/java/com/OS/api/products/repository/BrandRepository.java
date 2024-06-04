package com.OS.api.products.repository;

import com.OS.api.products.model.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository <BrandModel, Integer> {

}
