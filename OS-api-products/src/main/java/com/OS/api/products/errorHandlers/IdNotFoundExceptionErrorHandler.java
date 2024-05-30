package com.OS.api.products.errorHandlers;

import com.OS.api.products.dtos.response.ErrorDTO;
import com.OS.api.products.enums.ApiOnlineStoreError;
import com.OS.api.products.errorHandlers.exceptions.IdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class IdNotFoundExceptionErrorHandler {
   @ExceptionHandler(IdNotFoundException.class)
   public ResponseEntity<ErrorDTO> handleIdNotFoundException(IdNotFoundException idNotFoundException) {
      log.error("ID not found" + idNotFoundException);
      ErrorDTO errorDTO = ErrorDTO
              .builder()
              .code(ApiOnlineStoreError.EMMR_0001.name())
              .message(ApiOnlineStoreError.EMMR_0001.getDescription())
              .status(HttpStatus.NOT_FOUND.value())
              .build();
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
   }
}