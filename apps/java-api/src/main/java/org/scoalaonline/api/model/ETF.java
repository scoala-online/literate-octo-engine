package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Map;

@Entity
@Table(name = "etf")
public class ETF
{

  //--------------- Fields ---------------
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "etf_id")
  private long id;

  @Column(name = "etf_name", nullable = false, length = 50)
  private String name;

  @Column(name = "etf_ticker", nullable = false, length = 10)
  private String ticker;

  @Column(name = "stock_1", nullable = false)
  private Map<String, Double> stock_1;

  @Column(name = "stock_2", nullable = false)
  private Map<String, Double> stock_2;

  @Column(name = "stock_3", nullable = true)
  private Map<String, Double> stock_3;

  @Column(name = "stock_4", nullable = true)
  private Map<String, Double> stock_4;

  public ETF(){
  }
  //--------------- Getters ---------------
  public long getId(){
    return id;
  }

  public String getEtfName(){
    return name;
  }

  public String getEtfTicker(){
    return ticker;
  }

  public Map<String, Double> getStock1(){
    return stock_1;
  }

  public Map<String, Double> getStock2(){
    return stock_2;
  }

  public Map<String, Double> getStock_3(){
    return stock_3;
  }

  public Map<String, Double> getStock_4(){
    return stock_4;
  }

  //--------------- Setters ---------------
  public void setId(long id) {
    this.id = id;
  }

  public void setEtfName (String name){
    this.name = name;
  }
  public void setEtfTicker (String ticker){
    this.ticker = ticker;
  }

  public void setEtfStock1 (String stock_ticker, Double stock_value){
    this.stock_1 = new HashMap<String, Double>(stock_ticker, stock_value);
  }

  public void setEtfStock1 (String stock_ticker, Double stock_value){
    this.stock_2 = new HashMap<String, Double>(stock_ticker, stock_value);
  }

  public void setEtfStock1 (String stock_ticker, Double stock_value){
    this.stock_3 = new HashMap<String, Double>(stock_ticker, stock_value);
  }

  public void setEtfStock1 (String stock_ticker, Double stock_value){
    this.stock_4 = new HashMap<String, Double>(stock_ticker, stock_value);
  }

  //--------------- Equals & Hashcode ---------------

}
