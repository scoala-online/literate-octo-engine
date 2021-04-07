package org.scoalaonline.api.repo;

import org.scoalaonline.api.model.ETF;
import org.scoalaonline.api.model.ETFStock;
import org.scoalaonline.api.model.ETFStockKey;
import org.scoalaonline.api.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ETFStockRepo extends JpaRepository<ETFStock, ETFStockKey> {
  List<ETFStock> findETFStocksByEtf(ETF etf);
  List<ETFStock> findETFStocksByStock(Stock stock);
}
