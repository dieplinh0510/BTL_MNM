package com.hit.base_1.adapter.web.base;

import com.hit.base_1.application.constants.AuthorityConstant;
import com.hit.base_1.application.constants.UserMessageConstant;
import com.hit.base_1.config.exception.VsException;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Map;

@Component("WebTransferRequestHeader")
public class RequestHeader {
  private final HttpServletRequest httpServletRequest;

  public RequestHeader(HttpServletRequest httpServletRequest) {
    this.httpServletRequest = httpServletRequest;
  }

  /**
   * @return String
   */
  public String getId() {
    String bearerToken = httpServletRequest.getHeader("Authorization");
    if (StringUtils.isEmpty(bearerToken)) {
      return "ANONYMOUS_USER";
    }
    String token = bearerToken.substring(7);
    try {
      SignedJWT decodedJWT = SignedJWT.parse(token);
      Map<String, Object> payload = decodedJWT.getPayload().toJSONObject();
      return (String) payload.get(AuthorityConstant.CLAIM_UUID);
    } catch (ParseException e) {
      throw new VsException(UserMessageConstant.ERR_EXCEPTION_ACCESS_SYSTEM, e.getMessage());
    }
  }

}