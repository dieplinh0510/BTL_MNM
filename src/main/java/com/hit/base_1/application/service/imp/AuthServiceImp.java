package com.hit.base_1.application.service.imp;

import com.hit.base_1.adapter.web.v1.transfer.parameter.auth.AuthenticationRequest;
import com.hit.base_1.application.output.auth.GetAuthenticationOutput;
import com.hit.base_1.application.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {
  @Override
  public GetAuthenticationOutput login(AuthenticationRequest input) {
    return null;
  }
}
