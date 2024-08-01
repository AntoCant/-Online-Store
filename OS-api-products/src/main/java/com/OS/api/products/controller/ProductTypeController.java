package com.OS.api.products.controller;

import com.OS.api.products.dtos.request.RequestCreateProductTypeDTO;
import com.OS.api.products.service.imp.ProductTypeServiceImp;
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
public class ProductTypeController {

   private final ProductTypeServiceImp productTypeService;

   @PostMapping("/product-types")
   public ResponseEntity <Void> createProductType(@RequestBody RequestCreateProductTypeDTO requestCreateProductTypeDTO) {
      productTypeService.createProductTypeDTO(requestCreateProductTypeDTO);

      return ResponseEntity.status(HttpStatus.CREATED).build();
   }
}
