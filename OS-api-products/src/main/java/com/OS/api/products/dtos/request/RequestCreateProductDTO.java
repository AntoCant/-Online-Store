package com.OS.api.products.dtos.request;

import com.OS.api.products.dtos.response.ResponseImageDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
   private Integer brand;
   @NotNull
   @Min(1)
   private Integer productType;
   @NotNull
   private List <ResponseImageDTO> images;

}
