package org.scoalaonline.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ETFStockKey implements Serializable {
  @Column(name = "etf_id")
  long etfId;

  @Column(name = "stock_id")
  long stockId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ETFStockKey that = (ETFStockKey) o;
    return etfId == that.etfId && stockId == that.stockId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(etfId, stockId);
  }
}
