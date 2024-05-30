package com.OS.api.products.repository;

import com.OS.api.products.errorHandlers.exceptions.ImageUploadException;

public interface ImageCloudRepository {

   String uploadImage(String base64Image) throws ImageUploadException;

}
