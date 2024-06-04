package com.OS.api.products.controller;

import com.OS.api.products.dtos.request.RequestCreateProductDTO;
import com.OS.api.products.dtos.response.ResponsePageProductDTO;
import com.OS.api.products.dtos.response.ResposeCreateProdutDTO;
import com.OS.api.products.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@Validated
@RequiredArgsConstructor
@Tag(name = "Product Controller", description = "controller for online store products")
public class ProductController {

   private final ProductService productService;

   @GetMapping("/products")
   @Operation(summary = "returns products",
           description = "returns all paginated products allowing the use of filter by name or description")
   public ResponseEntity <ResponsePageProductDTO> getAllProduct(@Valid @RequestParam(defaultValue = "1") int page,
                                                                @Valid @RequestParam(defaultValue = "10") int recordsPage,
                                                                @Valid @RequestParam(required = false) String name,
                                                                @Valid @RequestParam(required = false) String description) {

      ResponsePageProductDTO responsePageDTO = productService.getAllProductDTO(page, recordsPage, name, description);

      return ResponseEntity.status(HttpStatus.OK).body(responsePageDTO);
   }

   @PostMapping("/products")
   @Operation(summary = "create product", description = "creates a new product")
   public ResponseEntity <ResposeCreateProdutDTO> createProduct(@Valid @RequestBody RequestCreateProductDTO requestCreateProductDTO) {

      return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProductDTO(requestCreateProductDTO));
   }
}
