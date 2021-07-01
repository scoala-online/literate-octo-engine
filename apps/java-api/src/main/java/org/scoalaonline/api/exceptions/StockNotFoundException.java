package org.scoalaonline.api.exceptions;

public class StockNotFoundException extends Exception{
  public StockNotFoundException(){ }
  public StockNotFoundException(String message) {
    super(message);
  }
}
