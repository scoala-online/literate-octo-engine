package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="stocks")
public class Stock
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

  @Column(name = "stock_price", nullable = false, precision = 2)
  private Double stockPrice;

  @Column(name = "stock_median_price", nullable = false, precision = 2)
  private Double stockMedianPrice;
  // de facut o lista care sa primeasca inputs de la useri pe ultimele 3 luni
  // pentru pretul stock ului

  @ManyToOne
  private ETF etf;
  //endregion

  public Stock() {
  }

  //region Getters
  public long getId() { return id; }

  public String getStockName() { return stockName; }

  public String getTickerName() { return tickerName; }

  public Double getStockPrice() { return stockPrice; }

  public Double getStockMedianPrice() { return stockMedianPrice; }

  public ETF getETF() { return etf; }
  //endregion

  //region Setters
  public void setId(long id) { this.id = id; }

  public void setStockName(String stockName) { this.stockName = stockName; }

  public void setTickerName(String tickerName) { this.tickerName = tickerName; }

  public void setStockPrice(Double stockPrice) { this.stockPrice = stockPrice; }

  public void setStockMedianPrice(Double stockMedianPrice) { this.stockMedianPrice = stockMedianPrice; }

  public void setETF(ETF etf) { this.etf = etf; }
  //endregion

  //region Equals & HashCode
  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null | getClass() != o.getClass()) return false;
    Stock stock = (Stock) o;
    return id == stock.id &&
        etf == stock.etf &&
        stockName.equals(stock.stockName) &&
        tickerName.equals(stock.tickerName) &&
        stockPrice.equals(stock.stockPrice) &&
        stockMedianPrice.equals(stock.stockMedianPrice)
  }

  @Override
  public int hashCode()
  {
      return Objects.hash(id, stockName, stockPrice, stockMedianPrice, etf);
  }
  //endregion
}






















