package com.OS.api.products.controller;

import com.OS.api.products.dtos.request.RequestCreateBrandDTO;
import com.OS.api.products.service.imp.BrandServiceImp;
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
public class BrandController {

   private final BrandServiceImp brandService;

   @PostMapping("/brands")
   public ResponseEntity <Void> createBrand(@Valid @RequestBody RequestCreateBrandDTO requestCreateBrandDTO) {
      brandService.createBrandDTO(requestCreateBrandDTO);

      return ResponseEntity.status(HttpStatus.CREATED).build();
   }
}
