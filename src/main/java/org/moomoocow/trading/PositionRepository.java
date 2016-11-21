package org.moomoocow.trading;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Position entity.
 */
public interface PositionRepository extends JpaRepository<Position,Long> {
	
	public Position findOneByInstrumentAndDate(Instrument i, Date date);
	
}
