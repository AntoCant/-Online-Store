package com.OS.api.products.service.imp;

import com.OS.api.products.dtos.request.RequestCreateProductTypeDTO;
import com.OS.api.products.model.ProductTypeModel;
import com.OS.api.products.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductTypeServiceImp {

   private final ProductTypeRepository productTypeRepository;

   public void createProductTypeDTO(RequestCreateProductTypeDTO requestCreateProductTypeDTO) {
      productTypeRepository.save(ProductTypeModel
                                         .builder()
                                         .description(requestCreateProductTypeDTO.getDescription())
                                         .build());
   }
}
