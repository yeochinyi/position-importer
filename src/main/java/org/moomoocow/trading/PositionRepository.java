package org.moomoocow.trading;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Position entity.
 */
public interface PositionRepository extends JpaRepository<Position,Long> {
	
}
