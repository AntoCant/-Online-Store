package com.OS.api.products.mapper;

import com.OS.api.products.dtos.request.RequestCreateBrandDTO;
import com.OS.api.products.dtos.response.ResponseBrandDTO;
import com.OS.api.products.model.BrandModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandMapper {

   @Mapping(source = "description", target = "description")
   BrandModel toBrandModel(RequestCreateBrandDTO requestDTO);

   @Mapping(source = "idBrand", target = "idBrand")
   @Mapping(source = "description", target = "description")
   ResponseBrandDTO toResponseGetBrandsDTO(BrandModel brandModel);

}
