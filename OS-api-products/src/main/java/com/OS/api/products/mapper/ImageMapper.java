package com.OS.api.products.mapper;

import com.OS.api.products.dtos.response.ResponseImageDTO;
import com.OS.api.products.model.ImageModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {

   @Mapping(source = "idImage", target = "idImage")
   @Mapping(source = "url", target = "url")
   ResponseImageDTO toResponseImageDTO(ImageModel imageModel);

   @Mapping(source = "idImage", target = "idImage")
   @Mapping(source = "url", target = "url")
   ImageModel toImageModel(ResponseImageDTO responseImageDTO);

   @Mapping(source = "url", target = "url")
   ImageModel toRequestImageModel(ResponseImageDTO requestImageDTO);
}
