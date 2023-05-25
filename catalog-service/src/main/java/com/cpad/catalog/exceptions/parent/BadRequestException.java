package com.cpad.catalog.exceptions.parent;

import com.cpad.catalog.exceptions.ServiceCatalogException;

public class BadRequestException extends ServiceCatalogException {
  public BadRequestException() {}

  public BadRequestException(String s) {
    super(s);
  }

  public BadRequestException(String message, Throwable cause) {
    super(message, cause);
  }

  public BadRequestException(Throwable cause) {
    super(cause);
  }

  public BadRequestException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
