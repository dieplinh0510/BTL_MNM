package com.hit.base_1.application.service.imp;

import com.hit.base_1.adapter.web.v1.transfer.parameter.auth.AuthenticationRequest;
import com.hit.base_1.application.dai.UserRepository;
import com.hit.base_1.application.output.auth.GetAuthenticationOutput;
import com.hit.base_1.application.service.AuthService;
import com.hit.base_1.application.utils.JwtUtil;
import com.hit.base_1.config.exception.InvalidException;
import com.hit.base_1.domain.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {
  private final JwtUtil jwtUtil;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthServiceImp(JwtUtil jwtUtil, UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.jwtUtil = jwtUtil;
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public GetAuthenticationOutput login(AuthenticationRequest input) {
    User user = userRepository.findByUsername(input.getUsername());

    if (user == null) {
      throw new InvalidException("", "Invalid username");
    }
    if (!passwordEncoder.matches(input.getPassword(), user.getPassword())) {
      throw new InvalidException("", "Invalid password");
    }
    return new GetAuthenticationOutput(jwtUtil.generateToken(user), user.getId());
  }
}
