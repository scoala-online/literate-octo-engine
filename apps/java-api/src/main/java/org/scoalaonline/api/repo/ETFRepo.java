package org.scoalaonline.api.repo;

import org.scoalaonline.api.model.ETF;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ETFRepo extends JpaRepository<ETF, Long> {
}
