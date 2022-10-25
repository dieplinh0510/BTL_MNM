package com.hit.base_1.application.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
  private DateTimeUtil() {
  }

  public static String convertLocalDateToString(LocalDate localDate, String format) {
    if (localDate != null) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
      return localDate.format(formatter);
    }
    return null;
  }

  public static LocalDate convertStringToLocalDate(String date, String format) {
    if (StringUtils.isNotEmpty(date)) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
      return LocalDate.parse(date, formatter);
    }
    return null;
  }

}
