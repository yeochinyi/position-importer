package org.moomoocow.trading;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Price entity.
 */
public interface PriceRepository extends JpaRepository<Price, Long> {
  public Price findOneByInstrumentAndDate(Instrument i, Date date);
}
