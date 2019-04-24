package com.shomari.springdemo.rest;


public class CustomerErrorResponse {
  private String message;
  private int status;
  private long timeStampe;

  public CustomerErrorResponse(){}

  public CustomerErrorResponse(String message, int status, long timeStampe) {
    this.message = message;
    this.status = status;
    this.timeStampe = timeStampe;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public long getTimeStampe() {
    return timeStampe;
  }

  public void setTimeStampe(long timeStampe) {
    this.timeStampe = timeStampe;
  }
}
