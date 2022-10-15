package com.hit.base_1.application.constants;

public class UrlConstant {

  private UrlConstant() {
  }

  public static final class User {
    private User() {
    }

    private static final String PREFIX = "/users";
    public static final String GET_USER_DATA = PREFIX;
    public static final String GET_USER_ID_DATA = PREFIX + "/{id}";
    public static final String CREATE_USER = PREFIX;
  }

}
