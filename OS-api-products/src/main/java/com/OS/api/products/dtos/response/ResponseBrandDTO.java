package com.OS.api.products.dtos.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBrandDTO implements Serializable {

   private Integer idBrand;
   private String description;

}
