package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Map;

@Entity
@Table(name = "etf")
public class ETF
{

  //region Fields
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
}
