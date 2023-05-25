package com.cpad.catalog.exceptions.parent;

import com.cpad.catalog.exceptions.ServiceCatalogException;

public class UnauthorizedException extends ServiceCatalogException {
  public UnauthorizedException(String s) {
    super(s);
  }

  public UnauthorizedException() {}

  public UnauthorizedException(String message, Throwable cause) {
    super(message, cause);
  }

  public UnauthorizedException(Throwable cause) {
    super(cause);
  }

  public UnauthorizedException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
