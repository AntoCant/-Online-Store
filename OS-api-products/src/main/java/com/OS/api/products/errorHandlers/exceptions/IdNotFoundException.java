package com.OS.api.products.errorHandlers.exceptions;

import lombok.Builder;

public class IdNotFoundException extends RuntimeException {

   @Builder
   public IdNotFoundException(String message) {
      super(message);
   }
}
