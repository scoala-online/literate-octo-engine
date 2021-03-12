package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="stocks")
public class Stocks
{
  //region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stock_id")
  private long id;

  @Column(name = "stock_name", nullable = false, length = 20)
  private String stockName;

  @Column(name = "stock_ticker", nullable = false, length = 10)
  private String tickerName;

  public Stock() {
  }
}
