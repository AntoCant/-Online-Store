package com.OS.api.products.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePageProductDTO implements Serializable {

   private int page;
   private int recordsPage;
   private int totalPages;
   private long totalItems;
   private List<ResponseProductDTO> products;

}
