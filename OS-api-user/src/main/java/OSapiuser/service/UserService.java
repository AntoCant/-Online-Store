package OSapiuser.service;

import OSapiuser.dtos.request.UserRequestDTO;
import OSapiuser.dtos.response.TokenResponseDTO;

public interface UserService {

   TokenResponseDTO register(UserRequestDTO request);

   TokenResponseDTO login(UserRequestDTO request);

   TokenResponseDTO getTokenResponseDTO(Integer userId);
}
