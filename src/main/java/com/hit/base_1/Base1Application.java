package com.hit.base_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Base1Application {

  public static void main(String[] args) {
    SpringApplication.run(Base1Application.class, args);
    System.out.println(new BCryptPasswordEncoder().encode("admin"));

  }

}
