package com.hit.base_1.application.utils;

import com.hit.base_1.application.constants.AuthorityConstant;
import com.hit.base_1.domain.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {
  @Value("${jwt.secret_key}")
  private String SECRET_KEY;

  @Value("${jwt.time_token_expiration}")
  private Integer TIME_TOKEN_EXPIRATION;

  @Value("${jwt.time_refresh_token_expiration}")
  private Integer TIME_REFRESH_TOKEN_EXPIRATION;

  public Long extractId(String token) {
    return Long.parseLong(Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject());
  }

  public java.util.Date extractExpiration(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
  }

  public Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public Boolean validateToken(String token, User user) {
    final Long id = extractId(token);
    return (id.equals(user.getId()) && !isTokenExpired(token));
  }

  public String generateToken(User user) {
    Map<String, Object> claim = new HashMap<>();
    claim.put(AuthorityConstant.CLAIM_STUDENT_CODE, user.getId());
    return Jwts.builder().setClaims(claim).setSubject(String.valueOf(user.getId()))
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + TIME_TOKEN_EXPIRATION))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }

}