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
    public static final String CURRENT_LOGIN = PREFIX + "/current-login";
  }

  public static final class Auth {
    private Auth() {
    }

    private static final String PREFIX = "/auth";
    public static final String LOGIN = PREFIX + "/login";
  }

  public static final class Subject {
    private Subject() {
    }

    private static final String PREFIX = "/subjects";
    public static final String LIST = PREFIX;
    public static final String TIME_TABLE = PREFIX + "/time-table";
    public static final String TIME_TABLE_DETAIL = PREFIX + "/time-table-detail/{subjectId}";
    public static final String LIST_STUDENT = PREFIX + "/students";
    public static final String LIST_STUDENT_IN_SUBJECT = PREFIX + "/students/{subjectId}";
    public static final String DETAIL_STUDENT = PREFIX + "/students/{subjectId}/{studentCode}";
  }

  public static final class Log {
    private Log() {
    }

    private static final String PREFIX = "/logs";
    public static final String SAVE = PREFIX;
  }

}
