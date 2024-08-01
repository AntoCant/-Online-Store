package com.OS.api.products.repository;

import com.OS.api.products.model.UserFavoriteProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavoriteProductRepository extends JpaRepository <UserFavoriteProductModel, Integer> {

   UserFavoriteProductModel findByIdUser(Integer idUser);
}
