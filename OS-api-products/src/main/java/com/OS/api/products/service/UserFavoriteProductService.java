package com.OS.api.products.service;

import com.OS.api.products.dtos.request.RequestFavoriteProductDTO;

public interface UserFavoriteProductService {

   void addFavoriteProduct(RequestFavoriteProductDTO requestFavoriteProductDTO);

   void removeFavoriteProduct(Integer productId);

}
