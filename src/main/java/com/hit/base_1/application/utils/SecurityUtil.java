package com.hit.base_1.application.utils;


import com.hit.base_1.adapter.web.base.RequestHeader;

/**
 * Utility class for Spring Security.
 */
public final class SecurityUtil {

  private SecurityUtil() {
  }

  public static String getCurrentUserLogin() {
    RequestHeader requestHeader = BeanUtil.getBean(RequestHeader.class);
    return requestHeader.getId();
  }

}
