package com.hit.base_1.adapter.web.v1.controller;

import com.hit.base_1.adapter.web.base.RestApiV1;
import com.hit.base_1.adapter.web.base.VsResponseUtil;
import com.hit.base_1.adapter.web.v1.transfer.parameter.auth.AuthenticationRequest;
import com.hit.base_1.application.constants.UrlConstant;
import com.hit.base_1.application.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestApiV1
public class AuthController {
  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping(UrlConstant.Auth.LOGIN)
  public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
    return VsResponseUtil.ok(authService.login(request));
  }

}
