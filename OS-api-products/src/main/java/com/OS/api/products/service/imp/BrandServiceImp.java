package com.OS.api.products.service.imp;

import com.OS.api.products.dtos.request.RequestCreateBrandDTO;
import com.OS.api.products.dtos.request.RequestUpdateBrandDTO;
import com.OS.api.products.dtos.response.ResponseBrandDTO;
import com.OS.api.products.dtos.response.ResponseGetBrandsDTO;
import com.OS.api.products.errorHandlers.exceptions.IdNotFoundException;
import com.OS.api.products.mapper.BrandMapper;
import com.OS.api.products.model.BrandModel;
import com.OS.api.products.repository.BrandRepository;
import com.OS.api.products.service.BrandService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandServiceImp implements BrandService {

   private final BrandRepository brandRepository;
   private final BrandMapper brandMapper;

   public void createBrandDTO(RequestCreateBrandDTO requestCreateBrandDTO) {
      brandRepository.save(brandMapper.toBrandModel(requestCreateBrandDTO));
   }

   public ResponseGetBrandsDTO getAllBrands() {
      List <BrandModel> brandModels = brandRepository.findByDateRemovedIsNull();
      List <ResponseBrandDTO> responseBrandsDTOS = brandModels.stream()
                                                              .map(brandMapper::toResponseGetBrandsDTO)
                                                              .toList();
      return ResponseGetBrandsDTO.builder().listBrands(responseBrandsDTOS).build();
   }

   public ResponseBrandDTO getProductTypeDTOById(Integer id) {
      BrandModel brandModel = brandRepository.findById(id).orElseThrow(
              () -> IdNotFoundException.builder()
                                       .message("The product with the ID: " + id + " does not exist.")
                                       .build());
      return brandMapper.toResponseGetBrandsDTO(brandModel);
   }

   public void updateBrandDTO(Integer id, RequestUpdateBrandDTO requestUpdateBrandDTO) {
      if (!id.equals(requestUpdateBrandDTO.getIdBrand())) {
         throw new IdNotFoundException("the id in the url must match the body");
      }
      BrandModel brandModel = brandRepository.findById(id).orElseThrow(
              () -> IdNotFoundException.builder()
                                       .message("The product with the ID: " + id + " does not exist.")
                                       .build());
      if (brandModel.getDateRemoved() != null) {
         throw new IdNotFoundException("The product with the ID: " + id + " does not exist.");
      }
      brandModel.setIdBrand(requestUpdateBrandDTO.getIdBrand());
      brandModel.setDescription(requestUpdateBrandDTO.getDescription());
      brandRepository.save(brandModel);
   }
}
