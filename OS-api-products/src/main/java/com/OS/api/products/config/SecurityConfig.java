package com.OS.api.products.config;

import com.OS.api.products.filter.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

   private final JwtFilter jwtFilter;

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.csrf(AbstractHttpConfigurer::disable)
          .cors(AbstractHttpConfigurer::disable)
          .formLogin(AbstractHttpConfigurer::disable)
          .authorizeHttpRequests(config -> config.requestMatchers("/api/v1/**")
                                                 .authenticated()
                                                 .anyRequest()
                                                 .permitAll())
          .sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
          .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
      return http.build();
   }
}
