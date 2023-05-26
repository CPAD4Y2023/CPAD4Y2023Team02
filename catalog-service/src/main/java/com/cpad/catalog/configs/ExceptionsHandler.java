package com.cpad.catalog.configs;

import com.cpad.catalog.dtos.response.CatalogServiceResponse;
import com.cpad.catalog.exceptions.ServiceCatalogException;
import com.cpad.catalog.exceptions.parent.BadRequestException;
import com.cpad.catalog.exceptions.parent.ForbiddenException;
import com.cpad.catalog.exceptions.parent.InternalServerException;
import com.cpad.catalog.exceptions.parent.NotFoundException;
import com.cpad.catalog.exceptions.parent.PermissionException;
import com.cpad.catalog.exceptions.parent.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ExceptionsHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ResponseEntity<CatalogServiceResponse<String>> handleAllExceptions(
      MethodArgumentNotValidException ex) {
    BindingResult bindingResult = ex.getBindingResult();
    String message;
    if (bindingResult.hasFieldErrors()) {
      FieldError fieldError = bindingResult.getFieldErrors().get(0);
      message = String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage());
    } else {
      ObjectError objectError = bindingResult.getAllErrors().get(0);
      message = String.format("%s %s", objectError, objectError.getDefaultMessage());
    }
    return CatalogServiceResponse.badRequest(null, message);
  }

  @ExceptionHandler(PermissionException.class)
  @ResponseStatus(code = HttpStatus.FORBIDDEN)
  public ResponseEntity<CatalogServiceResponse<String>> handleAllExceptions(
      PermissionException ex, WebRequest request) {
    return CatalogServiceResponse.forbidden(ex.getMessage());
  }

  @ExceptionHandler(ForbiddenException.class)
  @ResponseStatus(code = HttpStatus.FORBIDDEN)
  public ResponseEntity<CatalogServiceResponse<String>> handleAllExceptions(
      ForbiddenException ex, WebRequest request) {
    return CatalogServiceResponse.forbidden(ex.getMessage());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public ResponseEntity<CatalogServiceResponse<String>> handleAllExceptions(
      NotFoundException ex, WebRequest request) {
    return CatalogServiceResponse.notFound(ex.getMessage());
  }

  @ExceptionHandler(UnauthorizedException.class)
  @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public ResponseEntity<CatalogServiceResponse<String>> handleAllExceptions(
      UnauthorizedException ex, WebRequest request) {
    return CatalogServiceResponse.unauthorized(ex.getMessage());
  }

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ResponseEntity<CatalogServiceResponse<String>> handleAllExceptions(
      BadRequestException ex, WebRequest request) {
    return CatalogServiceResponse.badRequest(ex.getMessage());
  }

  @ExceptionHandler(InternalServerException.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<CatalogServiceResponse<String>> handleAllExceptions(
      InternalServerException ex, WebRequest request) {
    return CatalogServiceResponse.internalServerError(ex.getMessage());
  }

  @ExceptionHandler(ServiceCatalogException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ResponseEntity<CatalogServiceResponse<String>> handleAllExceptions(
      ServiceCatalogException ex, WebRequest request) {
    return CatalogServiceResponse.badRequest(ex.getMessage());
  }
}
