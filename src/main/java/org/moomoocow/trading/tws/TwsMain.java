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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.moomoocow.trading.Instrument;
import org.moomoocow.trading.Position;
import org.moomoocow.trading.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.UnderComp;

/**
 * Main Tws Interface
 * 
 * @author Chris
 *
 */
public class TwsMain implements EWrapper {

	private static final Logger LOG = LoggerFactory.getLogger(TwsMain.class);
	// 20160519 21:30:00
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd  hh:mm:ss");

	private CyclicBarrier barrier = new CyclicBarrier(2);

	private Consumer<Price> callbackHistorical;

	private DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

	private EClientSocket eclient;

	private List<Position> positions;

	private int tickerCounter;

	private Map<Integer, Instrument> tickerContractMap;

	/**
	 * Main
	 */
	public TwsMain() {
		reset();
	}

	/**
	 * Return historical data
	 * 
	 * @param c
	 * @return
	 */

	public List<Price> getHistoricalData(Instrument myContract, Contract c) {
		LOG.info("getHistoricalData");
		c.m_exchange = "Smart";
		List<Price> l = new ArrayList<>();
		CountDownLatch latch = new CountDownLatch(1);
		subscribeHistorical(myContract, c, (hd) -> {
			if (hd.getClose().signum() == -1) {
				latch.countDown();
			} else {
				l.add(hd);
			}
		});

		try {
			latch.await();
		} catch (InterruptedException e) {
			LOG.warn("Interrupted!", e);
			Thread.currentThread().interrupt();
		}
		return l;
	}

	/**
	 * // https://www.interactivebrokers.com/en/software/api/apiguide/java/
	 * reqhistoricaldata.htm // TRADES // MIDPOINT // BID // ASK // BID_ASK //
	 * HISTORICAL_VOLATILITY // OPTION_IMPLIED_VOLATILITY
	 * 
	 * @param contract
	 * @param callback
	 */
	public void subscribeHistorical(Instrument myContract, Contract contract, Consumer<Price> callback) {
		LOG.info("subscribeHistorical contract={}", myContract);

		LocalDateTime d = LocalDateTime.now();

		String df = dtFormatter.format(d);
		callbackHistorical = callback;

		int tickerId = this.tickerCounter++;
		this.tickerContractMap.put(tickerId, myContract);
		// Contract contract = new Contract(
		// myContract.getId(),
		// myContract.getSymbol(),
		// myContract.getSecType(),
		// myContract.getExpiry(),
		// myContract.getStrike(),
		// myContract.getRight(),
		// myContract.getMultiplier(),
		// myContract.getExchange(),
		// myContract.getCurrency(),
		// myContract.getLocalSymbol(),
		// myContract.getTradingClass(),
		// myContract.getComboLegs(),
		// myContract.getPrimaryExch(),
		// myContract.getIncludeExpired(),
		// myContract.getSecIdType(),
		// myContract.getSecId());
		eclient.reqHistoricalData(tickerId, contract, df, "1 M", "8 hours", "BID_ASK", 0, 1, null);

	}

	public List<Position> getPositions() {
		LOG.info("getPositions");
		this.positions = new ArrayList<>();
		eclient.reqPositions();
		try {
			this.barrier.await(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			LOG.error("Barrier exception.", e);
			this.barrier.reset();
		}
		return positions;
	}

	@Override
	public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume,
			int count, double wap, boolean hasGaps) {
		LOG.info("historicalData date={}", date);
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			LOG.warn("can't parse {}", date);
		}

		Instrument instrument = this.tickerContractMap.get(reqId);

		Price h = new Price.Builder().instrument(instrument).date(parsedDate).open(BigDecimal.valueOf(open))
				.high(BigDecimal.valueOf(high)).low(BigDecimal.valueOf(low)).close(BigDecimal.valueOf(close))
				.average(BigDecimal.valueOf(wap)).volume(volume).numTrades(count).hasGaps(hasGaps).build();
		callbackHistorical.accept(h);
	}

	@Override
	public void accountDownloadEnd(String accountName) {
		LOG.info("accountDownloadEnd");

	}

	@Override
	public void accountSummary(int reqId, String account, String tag, String value, String currency) {
		LOG.info("accountSummary");
	}

	@Override
	public void accountSummaryEnd(int reqId) {
		LOG.info("accountSummaryEnd");

	}

	@Override
	public void bondContractDetails(int reqId, ContractDetails contractDetails) {
		LOG.info("bondContractDetails");

	}

	@Override
	public void commissionReport(CommissionReport commissionReport) {
		LOG.info("commissionReport");

	}

	@Override
	public void connectionClosed() {
		LOG.info("connectionClosed");
		reset();
	}

	@Override
	public void contractDetails(int reqId, ContractDetails contractDetails) {
		LOG.info("contractDetails");

	}

	@Override
	public void contractDetailsEnd(int reqId) {
		LOG.info("contractDetailsEnd");

	}

	@Override
	public void currentTime(long time) {
		LOG.info("currentTime");

	}

	@Override
	public void deltaNeutralValidation(int reqId, UnderComp underComp) {
		LOG.info("deltaNeutralValidation");

	}

	@Override
	public void displayGroupList(int reqId, String groups) {
		LOG.info("displayGroupList");

	}

	@Override
	public void displayGroupUpdated(int reqId, String contractInfo) {
		LOG.info("displayGroupUpdated");

	}

	@Override
	public void error(Exception e) {
		LOG.info("error", e);
	}

	@Override
	public void error(int id, int errorCode, String errorMsg) {
		LOG.info("error=" + errorMsg);
	}

	@Override
	public void error(String str) {
		LOG.info("error" + str);
	}

	@Override
	public void execDetails(int reqId, Contract contract, Execution execution) {
		LOG.info("execDetails");

	}

	@Override
	public void execDetailsEnd(int reqId) {
		LOG.info("execDetailsEnd");

	}

	@Override
	public void fundamentalData(int reqId, String data) {
		LOG.info("fundamentalData");

	}

	@Override
	public void managedAccounts(String accountsList) {
		LOG.info("managedAccounts");

	}

	@Override
	public void marketDataType(int reqId, int marketDataType) {
		LOG.info("marketDataType");

	}

	@Override
	public void nextValidId(int orderId) {
		LOG.info("nextValidId");

	}

	@Override
	public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
		LOG.info("openOrder");

	}

	@Override
	public void openOrderEnd() {
		LOG.info("openOrderEnd");

	}

	@Override
	public void orderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId,
			int parentId, double lastFillPrice, int clientId, String whyHeld) {
		LOG.info("orderStatus");

	}

	@Override
	public void position(String account, Contract c, int pos, double avgCost) {
		Instrument instrument = new Instrument.Builder().id((long) c.m_conId).symbol(c.m_symbol).secType(c.m_secType)
				.expiry(c.m_expiry).strike(c.m_strike).right(c.m_right).multiplier(c.m_multiplier)
				.exchange(c.m_exchange).currency(c.m_currency).localSymbol(c.m_localSymbol)
				.tradingClass(c.m_tradingClass).primaryExch(c.m_primaryExch).includeExpired(c.m_includeExpired)
				.secIdType(c.m_secIdType).secId(c.m_secId).build();
		LOG.info("position");
		Position p = new Position.Builder().avgCost(BigDecimal.valueOf(avgCost)).instrument(instrument)
				.position((long) pos).build();
		p.setOrigContract(c);
		positions.add(p);
	}

	@Override
	public void positionEnd() {
		LOG.info("positionEnd");
		try {
			this.barrier.await();
		} catch (Exception e) {
			LOG.error("Barrier exception.", e);
		}
	}

	@Override
	public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume,
			double wap, int count) {
		LOG.info("realtimeBar");

	}

	@Override
	public void receiveFA(int faDataType, String xml) {
		LOG.info("receiveFA");

	}

	private void reset() {
		eclient = new EClientSocket(this);
		eclient.eConnect("127.0.0.1", 7496, 0);
		LOG.info("connected=" + eclient.isConnected());
		this.tickerCounter = 1;
		this.tickerContractMap = new HashMap<>();
	}

	@Override
	public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark,
			String projection, String legsStr) {
		LOG.info("scannerData");

	}

	@Override
	public void scannerDataEnd(int reqId) {
		LOG.info("scannerDataEnd");

	}

	@Override
	public void scannerParameters(String xml) {
		LOG.info("scannerParameters");

	}

	@Override
	public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints,
			double impliedFuture, int holdDays, String futureExpiry, double dividendImpact, double dividendsToExpiry) {
		LOG.info("tickEFP");

	}

	@Override
	public void tickGeneric(int tickerId, int tickType, double value) {
		LOG.info("tickGeneric");

	}

	@Override
	public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice,
			double pvDividend, double gamma, double vega, double theta, double undPrice) {
		LOG.info("tickOptionComputation");
	}

	@Override
	public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {
		LOG.info("tickPrice");
	}

	@Override
	public void tickSize(int tickerId, int field, int size) {
		LOG.info("tickSize");
	}

	@Override
	public void tickSnapshotEnd(int reqId) {
		LOG.info("tickSnapshotEnd");

	}

	@Override
	public void tickString(int tickerId, int tickType, String value) {
		LOG.info("tickString");

	}

	@Override
	public void updateAccountTime(String timeStamp) {
		LOG.info("updateAccountTime");

	}

	@Override
	public void updateAccountValue(String key, String value, String currency, String accountName) {
		LOG.info("updateAccountValue");

	}

	@Override
	public void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size) {
		LOG.info("updateMktDepth");

	}

	@Override
	public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price,
			int size) {
		LOG.info("updateMktDepthL2");

	}

	@Override
	public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
		LOG.info("updateNewsBulletin");

	}

	@Override
	public void updatePortfolio(Contract contract, int position, double marketPrice, double marketValue,
			double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {
		LOG.info("updatePortfolio");

	}

	@Override
	public void verifyCompleted(boolean isSuccessful, String errorText) {
		LOG.info("verifyCompleted");

	}

	@Override
	public void verifyMessageAPI(String apiData) {
		LOG.info("verifyMessageAPI");

	}

}
