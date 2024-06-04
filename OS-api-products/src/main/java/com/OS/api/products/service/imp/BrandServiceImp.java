package com.OS.api.products.service.imp;

import com.OS.api.products.dtos.request.RequestCreateBrandDTO;
import com.OS.api.products.mapper.BrandMapper;
import com.OS.api.products.repository.BrandRepository;
import com.OS.api.products.service.BrandService;
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
}
