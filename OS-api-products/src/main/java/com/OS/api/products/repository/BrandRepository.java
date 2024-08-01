package com.OS.api.products.repository;

import com.OS.api.products.model.BrandModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository <BrandModel, Integer> {

   List<BrandModel> findByDateRemovedIsNull();

}
