package org.scoalaonline.api.exceptions;

public class StockInvalidData extends Exception {
  public StockInvalidData(){ }
  public StockInvalidData(String message){
    super(message);
  }
}
