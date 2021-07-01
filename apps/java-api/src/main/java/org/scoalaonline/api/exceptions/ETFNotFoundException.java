package org.scoalaonline.api.exceptions;

public class ETFNotFoundException extends Exception {
  public ETFNotFoundException(){ }
  public ETFNotFoundException(String message){
    super(message);
  }
}
