package OSapiuser.service.imp;

import OSapiuser.dtos.request.UserRequestDTO;
import OSapiuser.dtos.response.TokenResponseDTO;
import OSapiuser.model.SystemUserModel;
import OSapiuser.model.SystemUserRoleModel;
import OSapiuser.repository.SystemUserRepository;
import OSapiuser.repository.SystemUserRolRepository;
import OSapiuser.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

   @Value("${jwt.secret}")
   private String secret;

   private final SystemUserRolRepository systemUserRoleRepository;
   private final SystemUserRepository systemUserRepository;

   @Override
   public TokenResponseDTO register(UserRequestDTO request) {
      if (systemUserRepository.findByUsername(request.getUsername()) != null) {
         throw new RuntimeException();
      }

      SystemUserRoleModel role = systemUserRoleRepository.findById(1).orElseThrow();
      SystemUserModel newUser = SystemUserModel.builder()
              .username(request.getUsername())
              .userPassword(request.getPassword())
              .systemUserRole(role)
              .build();

      newUser = systemUserRepository.save(newUser);

      return getTokenResponseDTO(newUser.getIdSystemUser());
   }

   @Override
   public TokenResponseDTO login(UserRequestDTO request) {
      SystemUserModel user = systemUserRepository.findByUsername(request.getUsername());
      if (user == null) {
         throw new RuntimeException();
      }
      if (!user.getUserPassword().equals(request.getPassword())) {
         throw new RuntimeException();
      }

      return getTokenResponseDTO(user.getIdSystemUser());
   }

   @Override
   public TokenResponseDTO getTokenResponseDTO(Integer userId) {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      String jwtToken = JWT.create()
              .withIssuer("Api Users")
              .withSubject("Api Users Subject")
              .withClaim("userId", userId)
              .withIssuedAt(new Date())
              .withJWTId(UUID.randomUUID().toString())
              .sign(algorithm);
      return TokenResponseDTO.builder()
              .token(jwtToken)
              .build();
   }
}

