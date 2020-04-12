package com.unified.resource.common.validators;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
  private String serviceName;
  private String methodName;

  public ServiceException(String message) {
    super(message);
  }

  public ServiceException(Throwable cause, String serviceName, String methodName) {
    super(cause);
    this.serviceName = serviceName;
    this.methodName = methodName;
  }
}
