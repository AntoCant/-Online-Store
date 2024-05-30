package com.OS.api.products.errorHandlers;

import com.OS.api.products.dtos.response.ErrorDTO;
import com.OS.api.products.enums.ApiOnlineStoreError;
import com.OS.api.products.errorHandlers.exceptions.ImageUploadException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ImageUploadExceptionErrorHandler {
   @ExceptionHandler(ImageUploadException.class)
   public ResponseEntity<ErrorDTO> ImageUploadExceptionErrorHandler(ImageUploadException imageUploadException) {
      log.error("Error uploading image" + imageUploadException);
      ErrorDTO errorDTO = ErrorDTO
              .builder()
              .code(ApiOnlineStoreError.EMMR_0001.name())
              .message(ApiOnlineStoreError.EMMR_0001.getDescription())
              .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
              .build();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
   }
}
