package com.OS.api.products.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
   List<ResponseImageDTO> images;


}
