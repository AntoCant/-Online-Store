package com.OS.api.products.mapper;

import com.OS.api.products.dtos.request.RequestProductDTO;
import com.OS.api.products.dtos.response.ResponseProductDTO;
import com.OS.api.products.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BrandMapper.class, ProductTypeMapper.class, ImageMapper.class})
public interface ProductMapper {

   @Mapping(source = "idProduct", target = "idProduct")
   @Mapping(source = "name", target = "name")
   @Mapping(source = "description", target = "description")
   @Mapping(source = "brand", target = "brand")
   @Mapping(source = "productType", target = "productType")
   @Mapping(source = "images", target = "images")
   ResponseProductDTO toResponseGetProductDTO(ProductModel productModel);

   @Mapping(source = "idProduct", target = "idProduct")
   @Mapping(source = "name", target = "name")
   ProductModel toProductModel(RequestProductDTO requestProductDTO);

}
