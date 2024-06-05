package com.OS.api.products.service.imp;

import static java.lang.Integer.parseInt;

import com.OS.api.products.dtos.request.RequestFavoriteProductDTO;
import com.OS.api.products.mapper.ProductMapper;
import com.OS.api.products.model.UserFavoriteProductModel;
import com.OS.api.products.repository.UserFavoriteProductRepository;
import com.OS.api.products.service.UserFavoriteProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFavoriteProductServiceImp implements UserFavoriteProductService {

   private final UserFavoriteProductRepository userFavoriteProductRepository;
   private final ProductMapper productMapper;

   @Override
   public void addFavoriteProduct(RequestFavoriteProductDTO requestFavoriteProductDTO) {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (!(authentication instanceof UsernamePasswordAuthenticationToken)) {
         throw new IllegalStateException("Unexpected authentication type");
      }
      User user = (User) authentication.getPrincipal();
      String userId = user.getUsername();

      if (requestFavoriteProductDTO.isFavorite()) {
         UserFavoriteProductModel userFavoriteProductModel = UserFavoriteProductModel
                 .builder()
                 .idUser(parseInt(userId))
                 .productModel(productMapper.toProductModel(requestFavoriteProductDTO.getProduct()))
                 .build();

         userFavoriteProductRepository.save(userFavoriteProductModel);
      }
   }

   @Override
   public void removeFavoriteProduct(Integer productId) {

   }
}
