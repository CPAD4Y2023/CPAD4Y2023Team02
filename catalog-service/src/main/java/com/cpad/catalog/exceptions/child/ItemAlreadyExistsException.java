package com.cpad.catalog.exceptions.child;

import com.cpad.catalog.exceptions.parent.BadRequestException;

public class ItemAlreadyExistsException extends BadRequestException {

  public ItemAlreadyExistsException() {}

  public ItemAlreadyExistsException(String s) {
    super(s);
  }

  public ItemAlreadyExistsException(String message, Throwable cause) {
    super(message, cause);
  }

  public ItemAlreadyExistsException(Throwable cause) {
    super(cause);
  }

  public ItemAlreadyExistsException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
