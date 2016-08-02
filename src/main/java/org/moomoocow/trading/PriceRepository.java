package org.moomoocow.trading;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Price entity.
 */
public interface PriceRepository extends JpaRepository<Price,Long> {

}
