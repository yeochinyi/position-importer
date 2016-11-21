package org.moomoocow.trading;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.moomoocow.trading.tws.EWrapHandler;
import org.moomoocow.trading.tws.HistoricalPricer;
import org.moomoocow.trading.tws.PositionGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Autowired
  private HistoricalPricer historicalPricer;

  @Autowired
  private InstrumentRepository instrumentRepository;

  @Autowired
  private PositionGetter positionGetter;

  @Autowired
  private PositionRepository positionRepository;

  @Autowired
  private PriceRepository priceRepository;

  @Bean
  public EClientSocket eClientSocket(EWrapHandler eWrapHandler) {

    final EWrapper ewrap = (EWrapper) Proxy.newProxyInstance(EWrapper.class.getClassLoader(),
        new Class[] {EWrapper.class}, eWrapHandler);

    final EClientSocket eclient = new EClientSocket(ewrap);
    eclient.eConnect("127.0.0.1", 7496, 0);
    LOGGER.info("connected=" + eclient.isConnected());
    return eclient;

  }

  @Override
  public void run(String... arg0) throws Exception {

    final List<Position> positions = this.positionGetter.getPositions();


    // Date now = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    // positions.stream().forEach(p->p.setDate(now));
    //
    this.savePositions(positions);
    //
    positions.stream().forEach(p -> {
      this.historicalPricer.getHistoricalData(p.getInstrument());
    });

    // System.exit(0);
    // while (true) {
    // Thread.sleep(10000);
    // }
  }


  private Ops savePosition(Position pos) {
    // LOGGER.info("Saving new pos {}", pos);
    final Position existingPos =
        this.positionRepository.findOneByInstrumentAndDate(pos.getInstrument(), pos.getDate());
    if (existingPos != null) {
      // existingPos.setAvgCost(pos.getAvgCost());
      // existingPos.setPosition(pos.getPosition());
      // this.positionRepository.save(existingPos);
      // LOGGER.info("Re-saved existing pos {}", existingPos);
      return Ops.NONE;
    } else {
      this.positionRepository.save(pos);
      // LOGGER.info("Saved new pos {}", pos);
      return Ops.CREATE;
    }
  }

  private Map<Ops, Long> savePositions(List<Position> ps) {
    // ps.stream().filter(p -> p != null).forEach(this::savePosition);
    return ps.stream().map(p -> this.savePosition(p))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  private Ops savePrice(Price pos) {
    final Price existingPos =
        this.priceRepository.findOneByInstrumentAndDate(pos.getInstrument(), pos.getDate());
    if (existingPos != null) {
      return Ops.NONE;
      // LOGGER.info("Saved new pos {}", pos);
    } else {
      this.priceRepository.save(pos);
      return Ops.CREATE;
      // LOGGER.warn("Not saving price.");
    }
  }

  private Map<Ops, Long> savePrices(List<Price> l) {
    // prices.forEach(this::savePrice);

    return l.stream().map(p -> this.savePrice(p))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

  }

  public enum Ops {
    CREATE, DELETE, NONE, UPDATE
  };
}
