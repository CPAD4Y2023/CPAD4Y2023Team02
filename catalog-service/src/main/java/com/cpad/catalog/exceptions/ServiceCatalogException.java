package com.cpad.catalog.exceptions;

public class ServiceCatalogException extends Exception {

  public ServiceCatalogException() {
    super();
  }

  public ServiceCatalogException(String message) {
    super(message);
  }

  public ServiceCatalogException(String message, Throwable cause) {
    super(message, cause);
  }

  public ServiceCatalogException(Throwable cause) {
    super(cause);
  }

  protected ServiceCatalogException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
