package com.OS.api.products.enums;

import lombok.Getter;

@Getter
public enum ApiOnlineStoreError {

   EMMR_0001("Error ID", "Error: ID not found in the database."),
   EMMR_0002("integrity error DB ", "Database integrity error: integrity violation detected."),
   EMMR_0003("validation error", "error in validation of parameter fields"),
   EMMR_0004("invalid match id ", "Invalid match ID. This occurs when the request id does not match."),
   EMMR_0005("Error uploading image ", "Error uploading image.");

   private final String useCase;
   private final String description;

   ApiOnlineStoreError(String useCase, String description) {
      this.useCase = useCase;
      this.description = description;
   }
}
