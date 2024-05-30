package com.OS.api.products.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CloudinaryConfig {

   @Value("${cloud_name}")
   private String cloudName;
   @Value("${api_key}")
   private String apiKey;
   @Value("${api_secret}")
   private String apiSecret;

   @Bean
   public Cloudinary cloudinary() {
      return new Cloudinary(ObjectUtils.asMap(
              "cloud_name", cloudName,
              "api_key", apiKey,
              "api_secret", apiSecret
      ));
   }

}
