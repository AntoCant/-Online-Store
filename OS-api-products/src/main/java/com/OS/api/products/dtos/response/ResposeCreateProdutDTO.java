package com.OS.api.products.dtos.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResposeCreateProdutDTO {

   Integer idProduct;
   String name;
   String description;
   ResponseProductTypeDTO productType;
   ResponseBrandDTO brand;
   List <ResponseImageDTO> images;


}
