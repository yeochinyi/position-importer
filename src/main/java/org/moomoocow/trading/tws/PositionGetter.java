package org.moomoocow.trading.tws;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

import javax.annotation.PostConstruct;

import org.moomoocow.trading.Instrument;
import org.moomoocow.trading.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ib.client.Contract;

@Service
public class PositionGetter extends EWrapperBlanker {

  private static final Logger LOGGER = LoggerFactory.getLogger(PositionGetter.class);

  private List<Position> positions;

  public PositionGetter() {}

  public List<Position> getPositions() {

    LOGGER.info("getPositions");

    this.positions = new ArrayList<>();

    this.phaser = new Phaser(2);
    this.eclientSocket.reqPositions();

    this.phaser.arriveAndAwaitAdvance();
    return this.positions;
  }

  @PostConstruct
  public void init() {
    this.eWrapHandler.addWrap(this);
  }

  @Override
  public void position(String account, Contract c, int pos, double avgCost) {
    // LOGGER.info("position");
    final Instrument instrument = new Instrument.Builder().id((long) c.m_conId).symbol(c.m_symbol)
        .secType(c.m_secType).expiry(c.m_expiry).strike(c.m_strike).right(c.m_right)
        .multiplier(c.m_multiplier).exchange(c.m_exchange).currency(c.m_currency)
        .localSymbol(c.m_localSymbol).tradingClass(c.m_tradingClass).primaryExch(c.m_primaryExch)
        .includeExpired(c.m_includeExpired).secIdType(c.m_secIdType).secId(c.m_secId).build();

    final Position p = new Position.Builder().avgCost(BigDecimal.valueOf(avgCost))
        .instrument(instrument).position((long) pos).build();
    this.positions.add(p);
  }

  @Override
  public void positionEnd() {
    LOGGER.info("positionEnd");
    this.phaser.arriveAndDeregister();
  }

}
