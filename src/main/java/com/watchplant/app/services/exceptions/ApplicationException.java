package com.watchplant.app.services.exceptions;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {
  private final HttpStatus statusCode;

  public ApplicationException(String message) {
    this(message, HttpStatus.BAD_REQUEST);
  }

  public ApplicationException(String message, HttpStatus statusCode) {
    super(message);
    this.statusCode = statusCode;
  }

  public HttpStatus getStatusCode() {
    return statusCode;
  }
}
