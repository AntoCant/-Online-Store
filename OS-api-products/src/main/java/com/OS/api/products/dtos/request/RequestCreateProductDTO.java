package com.OS.api.products.dtos.request;

import com.OS.api.products.dtos.response.ResponseImageDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateProductDTO {

   @NotBlank
   private String name;
   @NotBlank
   private String description;
   @NotNull
   @Min(1)
   private Integer idBrand;
   @NotNull
   @Min(1)
   private Integer idProductType;
   @NotNull
   private List<ResponseImageDTO> images;

}
