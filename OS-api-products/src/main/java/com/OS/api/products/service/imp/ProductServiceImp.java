package com.OS.api.products.service.imp;

import com.OS.api.products.dtos.request.RequestCreateProductDTO;
import com.OS.api.products.dtos.response.ResponseImageDTO;
import com.OS.api.products.dtos.response.ResponsePageProductDTO;
import com.OS.api.products.dtos.response.ResponseProductDTO;
import com.OS.api.products.dtos.response.ResposeCreateProdutDTO;
import com.OS.api.products.enums.ApiOnlineStoreError;
import com.OS.api.products.errorHandlers.exceptions.IdNotFoundException;
import com.OS.api.products.mapper.BrandMapper;
import com.OS.api.products.mapper.ImageMapper;
import com.OS.api.products.mapper.ProductMapper;
import com.OS.api.products.mapper.ProductTypeMapper;
import com.OS.api.products.model.BrandModel;
import com.OS.api.products.model.ImageModel;
import com.OS.api.products.model.ProductModel;
import com.OS.api.products.model.ProductTypeModel;
import com.OS.api.products.repository.BrandRepository;
import com.OS.api.products.repository.ImageRepository;
import com.OS.api.products.repository.ProductRepository;
import com.OS.api.products.repository.ProductTypeRepository;
import com.OS.api.products.repository.imp.ImageCloudRepositoryImp;
import com.OS.api.products.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

   private final ProductRepository productRepository;
   private final BrandRepository brandRepository;
   private final ProductTypeRepository productTypeRepository;
   private final ImageMapper imageMapper;
   private final ImageRepository imageRepository;
   private final ProductMapper productMapper;
   private final ProductTypeMapper productTypeMapper;
   private final BrandMapper brandMapper;
   private final ImageCloudRepositoryImp imageCloudRepositoryImp;

   @Override
   public ResponsePageProductDTO getAllProductDTO(int page, int recordsPage, String name, String description) {
      Pageable pageable = PageRequest.of(page - 1, recordsPage);
      Page <ProductModel> productPage;

      productPage = productRepository.findAllByParams(name, description, pageable);
      List <ResponseProductDTO> pageProductDTOS = productPage.stream().map(productMapper::toResponseGetProductDTO).toList();

      return ResponsePageProductDTO
              .builder()
              .products(pageProductDTOS)
              .totalPages(productPage.getTotalPages())
              .totalItems(productPage.getTotalElements())
              .recordsPage(recordsPage)
              .page(page)
              .build();
   }

   public ResposeCreateProdutDTO createProductDTO(
           RequestCreateProductDTO requestCreateProductDTO) {

      BrandModel brandModel = brandRepository.findById(requestCreateProductDTO.getBrand())
                                             .orElseThrow(() -> IdNotFoundException
                                                     .builder()
                                                     .message(ApiOnlineStoreError.EMMR_0001.getDescription())
                                                     .build());
      ProductTypeModel productTypeModel = productTypeRepository
              .findById(requestCreateProductDTO.getProductType())
              .orElseThrow(() -> IdNotFoundException.builder()
                                                    .message(ApiOnlineStoreError.EMMR_0001.getDescription())
                                                    .build());

      if (brandModel.getDateRemoved() != null || productTypeModel.getDateRemoved() != null) {
         throw new IdNotFoundException(ApiOnlineStoreError.EMMR_0001.getDescription());
      }

      ProductModel productModel = ProductModel
              .builder()
              .name(requestCreateProductDTO.getName())
              .description(requestCreateProductDTO.getDescription())
              .brand(brandModel)
              .productType(productTypeModel)
              .images(requestCreateProductDTO.getImages().stream().map(imageMapper::toImageModel).toList())
              .build();

      List <ImageModel> imageModels = new ArrayList <>();
      for (ResponseImageDTO imageDTO : requestCreateProductDTO.getImages()) {
         ImageModel imageModel = ImageModel
                 .builder()
                 .productModel(productModel)
                 .url(imageCloudRepositoryImp.uploadImage(imageDTO.getUrl()))
                 .build();
         imageModels.add(imageModel);
      }
      productModel.setImages(imageModels);
      productRepository.save(productModel);
      imageRepository.saveAll(imageModels);

      return ResposeCreateProdutDTO
              .builder()
              .idProduct(productModel.getIdProduct())
              .name(productModel.getName())
              .description(productModel.getDescription())
              .brand(brandMapper.toResponseGetBrandsDTO(brandModel))
              .productType(productTypeMapper.toResponseGetProductTypeDTO(productTypeModel))
              .images(productModel.getImages().stream().map(imageMapper::toResponseImageDTO).toList())
              .build();
   }
}
