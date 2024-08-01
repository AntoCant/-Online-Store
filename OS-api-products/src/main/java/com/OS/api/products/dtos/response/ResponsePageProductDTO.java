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
public class ResponsePageProductDTO implements Serializable {

   private int page;
   private int recordsPage;
   private int totalPages;
   private long totalItems;
   private List <ResponseProductDTO> products;

}
