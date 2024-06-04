package com.OS.api.products.service;

import com.OS.api.products.dtos.request.RequestCreateProductDTO;
import com.OS.api.products.dtos.response.ResponsePageProductDTO;
import com.OS.api.products.dtos.response.ResposeCreateProdutDTO;

public interface ProductService {

   ResponsePageProductDTO getAllProductDTO(int page, int recordsPage, String name, String description);

   ResposeCreateProdutDTO createProductDTO(RequestCreateProductDTO requestCreateProductDTO);

}
