package com.OS.api.products.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductTypeDTO {
   private Integer IdProductType;
   private String description;
   private LocalDate dateRemoved;
}
