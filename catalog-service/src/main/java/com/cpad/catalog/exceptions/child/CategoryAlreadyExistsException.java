package com.cpad.catalog.exceptions.child;

import com.cpad.catalog.exceptions.parent.BadRequestException;

public class CategoryAlreadyExistsException extends BadRequestException {

  public CategoryAlreadyExistsException() {}

  public CategoryAlreadyExistsException(String s) {
    super(s);
  }

  public CategoryAlreadyExistsException(String message, Throwable cause) {
    super(message, cause);
  }

  public CategoryAlreadyExistsException(Throwable cause) {
    super(cause);
  }

  public CategoryAlreadyExistsException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
