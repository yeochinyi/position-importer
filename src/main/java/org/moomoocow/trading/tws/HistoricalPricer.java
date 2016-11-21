package org.moomoocow.trading.tws;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Phaser;

import javax.annotation.PostConstruct;

import org.moomoocow.trading.Instrument;
import org.moomoocow.trading.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ib.client.Contract;

@Service
public class HistoricalPricer extends EWrapperBlanker {

  private static final Logger LOGGER = LoggerFactory.getLogger(HistoricalPricer.class);

  private int counter = 0;

  // 20160519 21:30:00
  private final DateFormat dataDateFormat = new SimpleDateFormat("yyyyMMdd  hh:mm:ss");

  private final List<Price> prices;

  private final DateTimeFormatter requestDateFormatter =
      DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

  private Map<Integer, Instrument> tickerContractMap;


  public HistoricalPricer() {
    this.prices = new ArrayList<>();
  }

  public List<Price> getHistoricalData(Instrument instrument) {
    LOGGER.info("getHistoricalData");

    final int current = this.counter++;

    this.tickerContractMap = new HashMap<>();

    this.phaser = new Phaser(2);

    instrument.setExchange("Smart");

    final String nowDateString = this.requestDateFormatter.format(LocalDateTime.now());

    // final int tickerId = this.tickerCounter.getAndIncrement();
    this.tickerContractMap.put(current, instrument);
    final Contract c = ContractGetter.getContract(instrument);

    // https://www.interactivebrokers.com/en/software/api/apiguide/java/reqhistoricaldata.htm //
    // TRADES // MIDPOINT // BID // ASK // BID_ASK //HISTORICAL_VOLATILITY //
    // OPTION_IMPLIED_VOLATILITY
    // void reqHistoricalData (int id, Contract contract, String endDateTime, String durationStr,
    // String barSizeSetting,
    // String whatToShow, int useRTH, int formatDate, List<TagValue> chartOptions)
    this.eclientSocket.reqHistoricalData(current, c, nowDateString, "1 M", "8 hours", "BID_ASK", 0,
        1, null);

    this.phaser.arriveAndAwaitAdvance();

    return this.prices;
  }


  @Override
  public void historicalData(int reqId, String date, double open, double high, double low,
      double close, int volume, int count, double wap, boolean hasGaps) {
    LOGGER.info("historicalData date={}", date);
    Date parsedDate = null;
    try {
      parsedDate = this.dataDateFormat.parse(date);
    } catch (final ParseException e) {
      LOGGER.warn("can't parse {}", date);
    }

    final Instrument instrument = this.tickerContractMap.get(reqId);

    final Price h = new Price.Builder().instrument(instrument).date(parsedDate)
        .open(BigDecimal.valueOf(open)).high(BigDecimal.valueOf(high)).low(BigDecimal.valueOf(low))
        .close(BigDecimal.valueOf(close)).average(BigDecimal.valueOf(wap)).volume(volume)
        .numTrades(count).hasGaps(hasGaps).build();

    if (h.getClose().signum() == -1) {
      this.phaser.arriveAndDeregister();
      return;
    }

    this.prices.add(h);

    // this.callbackHistorical.accept(h);
  }

  @PostConstruct
  public void init() {
    this.eWrapHandler.addWrap(this);
  }



}
