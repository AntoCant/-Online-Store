package com.OS.api.products.mapper;

import com.OS.api.products.dtos.response.ResponseProductTypeDTO;
import com.OS.api.products.model.ProductTypeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductTypeMapper {

   @Mapping(source = "idProductType", target = "idProductType")
   @Mapping(source = "description", target = "description")
   ResponseProductTypeDTO toResponseGetProductTypeDTO(ProductTypeModel productTypeModel);

   @Mapping(source = "idProductType", target = "idProductType")
   @Mapping(source = "description", target = "description")
   ProductTypeModel toProductTypeModel(ResponseProductTypeDTO responseProductTypeDTO);
}
