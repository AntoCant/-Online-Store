package com.OS.api.products.repository.imp;

import com.OS.api.products.errorHandlers.exceptions.ImageUploadException;
import com.OS.api.products.repository.ImageCloudRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ImageCloudRepositoryImp implements ImageCloudRepository {

   private final Cloudinary cloudinary;

   @Override
   public String uploadImage(String base64Image) throws ImageUploadException {
      try {
         byte[] imageBytes = Base64.getDecoder().decode(base64Image);
         Map uploadResult = cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());
         return uploadResult.get("url").toString();
      } catch (IOException e) {
         throw new ImageUploadException("Error uploading image");
      }
   }
}

