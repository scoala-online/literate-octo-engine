package org.scoalaonline.api.repo;

import org.scoalaonline.api.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Long> {

}
