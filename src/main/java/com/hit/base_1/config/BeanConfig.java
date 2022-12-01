package com.hit.base_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {

  @Bean
  public PasswordEncoder createBeanPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
