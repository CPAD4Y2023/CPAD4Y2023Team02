package com.cpad.catalog.exceptions.parent;

import com.cpad.catalog.exceptions.ServiceCatalogException;

public class NotFoundException extends ServiceCatalogException {
  public NotFoundException() {}

  public NotFoundException(String s) {
    super(s);
  }

  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotFoundException(Throwable cause) {
    super(cause);
  }

  public NotFoundException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
