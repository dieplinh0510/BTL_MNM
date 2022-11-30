package com.hit.base_1.application.service;

import com.hit.base_1.adapter.web.v1.transfer.parameter.auth.AuthenticationRequest;
import com.hit.base_1.application.output.auth.GetAuthenticationOutput;

public interface AuthService {

  GetAuthenticationOutput login(AuthenticationRequest input);

}
