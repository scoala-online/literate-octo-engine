package org.scoalaonline.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="etf_stock")
public class ETFStock {
  @EmbeddedId
  ETFStockKey id;

  @ManyToOne
  @MapsId("etfId")
  @JoinColumn(name = "etf_id")
  ETF etf;

  @ManyToOne
  @MapsId("stockId")
  @JoinColumn(name = "stock_id")
  Stock stock;

  @Column(name="percentage", nullable = false)
  Double percentage;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ETFStock etfStock = (ETFStock) o;
    return Objects.equals(id, etfStock.id) && Objects.equals(etf, etfStock.etf) && Objects.equals(stock, etfStock.stock) && Objects.equals(percentage, etfStock.percentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, etf, stock, percentage);
  }
}
