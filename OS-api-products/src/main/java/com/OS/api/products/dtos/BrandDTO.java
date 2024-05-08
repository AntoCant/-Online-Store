package com.OS.api.products.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BrandDTO {
   private Integer idBrand;
   private String description;
   private LocalDate dateRemoved;
}
