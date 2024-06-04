package OSapiuser.controller;

import OSapiuser.dtos.request.UserRequestDTO;
import OSapiuser.dtos.response.TokenResponseDTO;
import OSapiuser.service.imp.UserServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Validated
public class UserController {

   private final UserServiceImp userService;

   @PostMapping("/auth/register")
   public TokenResponseDTO register(@Valid @RequestBody UserRequestDTO request) {
      return userService.register(request);
   }

   @PostMapping("/auth/login")
   public TokenResponseDTO login(@Valid @RequestBody UserRequestDTO request) {
      return userService.login(request);
   }
}
