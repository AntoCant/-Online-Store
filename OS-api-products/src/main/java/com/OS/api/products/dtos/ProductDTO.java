package com.OS.api.products.dtos;

import com.OS.api.products.model.BrandModel;
import com.OS.api.products.model.ProductTypeModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDTO {
   private Integer idProduct;
   private String name;
   private String description;
   private LocalDate dateRemoved;
   private BrandModel brand;
   private ProductTypeModel productType;
}

