package com.cpad.catalog.exceptions.parent;

import com.cpad.catalog.exceptions.ServiceCatalogException;

public class InternalServerException extends ServiceCatalogException {
  public InternalServerException(String s) {
    super(s);
  }

  public InternalServerException() {}

  public InternalServerException(String message, Throwable cause) {
    super(message, cause);
  }

  public InternalServerException(Throwable cause) {
    super(cause);
  }

  public InternalServerException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
