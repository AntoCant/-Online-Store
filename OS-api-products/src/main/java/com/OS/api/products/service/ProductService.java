package com.OS.api.products.service;

import com.OS.api.products.dtos.response.ResponsePageProductDTO;

public interface ProductService {

   ResponsePageProductDTO getAllProductDTO(int page, int recordsPage, String name, String description);

}
