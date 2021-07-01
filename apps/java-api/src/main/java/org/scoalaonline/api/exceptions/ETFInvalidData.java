package org.scoalaonline.api.exceptions;

public class ETFInvalidData extends Exception {
  public ETFInvalidData(){ }
  public ETFInvalidData(String message){
    super(message);
  }
}
