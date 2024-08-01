package com.OS.api.products.dtos.response;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductDTO implements Serializable {

   private Integer idProduct;
   private String name;
   private String description;
   private ResponseBrandDTO brand;
   private ResponseProductTypeDTO productType;
   private List <ResponseImageDTO> images;

}
