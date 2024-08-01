package com.OS.api.products.controller;

import com.OS.api.products.dtos.request.RequestFavoriteProductDTO;
import com.OS.api.products.service.imp.UserFavoriteProductServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserFavoriteProductController {

   private final UserFavoriteProductServiceImp userFavoriteProductServiceImp;

   @PostMapping("/favorites")
   public ResponseEntity <Void> addFavoriteProduct(@Valid @RequestBody RequestFavoriteProductDTO requestFavoriteProductDTO) {
      userFavoriteProductServiceImp.addFavoriteProduct(requestFavoriteProductDTO);
      return ResponseEntity.status(HttpStatus.CREATED).build();
   }
}
