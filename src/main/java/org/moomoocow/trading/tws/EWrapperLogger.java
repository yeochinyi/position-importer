package org.moomoocow.trading.tws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.UnderComp;

public class EWrapperLogger implements EWrapper {

  private static final Logger LOGGER = LoggerFactory.getLogger(EWrapperLogger.class);

  public EWrapperLogger() {}

  @Override
  public void accountDownloadEnd(String accountName) {
    LOGGER.info("accountDownloadEnd");
  }

  @Override
  public void accountSummary(int reqId, String account, String tag, String value, String currency) {
    LOGGER.info("accountSummary");
  }

  @Override
  public void accountSummaryEnd(int reqId) {
    LOGGER.info("accountSummaryEnd");

  }

  @Override
  public void bondContractDetails(int reqId, ContractDetails contractDetails) {
    LOGGER.info("bondContractDetails");

  }

  @Override
  public void commissionReport(CommissionReport commissionReport) {
    LOGGER.info("commissionReport");

  }

  @Override
  public void connectionClosed() {
    LOGGER.info("connectionClosed");
    // reset();
  }

  @Override
  public void contractDetails(int reqId, ContractDetails contractDetails) {
    LOGGER.info("contractDetails");

  }

  @Override
  public void contractDetailsEnd(int reqId) {
    LOGGER.info("contractDetailsEnd");
  }

  @Override
  public void currentTime(long time) {
    LOGGER.info("currentTime");

  }

  @Override
  public void deltaNeutralValidation(int reqId, UnderComp underComp) {
    LOGGER.info("deltaNeutralValidation");

  }

  @Override
  public void displayGroupList(int reqId, String groups) {
    LOGGER.info("displayGroupList");

  }

  @Override
  public void displayGroupUpdated(int reqId, String contractInfo) {
    LOGGER.info("displayGroupUpdated");

  }

  @Override
  public void error(Exception e) {
    LOGGER.info("error", e);
  }

  @Override
  public void error(int id, int errorCode, String errorMsg) {
    LOGGER.info("error=" + errorMsg);
  }

  @Override
  public void error(String str) {
    LOGGER.info("error" + str);
  }

  @Override
  public void execDetails(int reqId, Contract contract, Execution execution) {
    LOGGER.info("execDetails");

  }

  @Override
  public void execDetailsEnd(int reqId) {
    LOGGER.info("execDetailsEnd");

  }

  @Override
  public void fundamentalData(int reqId, String data) {
    LOGGER.info("fundamentalData data={}", data);
  }

  @Override
  public void historicalData(int reqId, String date, double open, double high, double low,
      double close, int volume, int count, double WAP, boolean hasGaps) {
    LOGGER.info("historicalData");
  }

  @Override
  public void managedAccounts(String accountsList) {
    LOGGER.info("managedAccounts");

  }

  @Override
  public void marketDataType(int reqId, int marketDataType) {
    LOGGER.info("marketDataType");

  }

  @Override
  public void nextValidId(int orderId) {
    LOGGER.info("nextValidId");

  }

  @Override
  public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
    LOGGER.info("openOrder");

  }

  // private void notifyFor(){
  // try {
  // this.barrier.await();
  // } catch (Exception e) {
  // LOG.error("Barrier exception.", e);
  // }
  // }

  @Override
  public void openOrderEnd() {
    LOGGER.info("openOrderEnd");

  }

  @Override
  public void orderStatus(int orderId, String status, int filled, int remaining,
      double avgFillPrice, int permId, int parentId, double lastFillPrice, int clientId,
      String whyHeld) {
    LOGGER.info("orderStatus");

  }

  @Override
  public void position(String account, Contract contract, int pos, double avgCost) {
    LOGGER.info("position");
  }

  @Override
  public void positionEnd() {
    LOGGER.info("positionEnd");
  }

  @Override
  public void realtimeBar(int reqId, long time, double open, double high, double low, double close,
      long volume, double wap, int count) {
    LOGGER.info("realtimeBar");

  }

  @Override
  public void receiveFA(int faDataType, String xml) {
    LOGGER.info("receiveFA");

  }

  @Override
  public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance,
      String benchmark, String projection, String legsStr) {
    LOGGER.info("scannerData");

  }

  @Override
  public void scannerDataEnd(int reqId) {
    LOGGER.info("scannerDataEnd");

  }

  @Override
  public void scannerParameters(String xml) {
    LOGGER.info("scannerParameters");

  }

  @Override
  public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints,
      double impliedFuture, int holdDays, String futureExpiry, double dividendImpact,
      double dividendsToExpiry) {
    LOGGER.info("tickEFP");

  }

  @Override
  public void tickGeneric(int tickerId, int tickType, double value) {
    LOGGER.info("tickGeneric");

  }

  @Override
  public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta,
      double optPrice, double pvDividend, double gamma, double vega, double theta,
      double undPrice) {
    LOGGER.info("tickOptionComputation");
  }

  @Override
  public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {
    LOGGER.info("tickPrice");
  }

  @Override
  public void tickSize(int tickerId, int field, int size) {
    LOGGER.info("tickSize");
  }

  @Override
  public void tickSnapshotEnd(int reqId) {
    LOGGER.info("tickSnapshotEnd");

  }

  @Override
  public void tickString(int tickerId, int tickType, String value) {
    LOGGER.info("tickString");

  }

  @Override
  public void updateAccountTime(String timeStamp) {
    LOGGER.info("updateAccountTime");

  }

  @Override
  public void updateAccountValue(String key, String value, String currency, String accountName) {
    LOGGER.info("updateAccountValue");

  }

  @Override
  public void updateMktDepth(int tickerId, int position, int operation, int side, double price,
      int size) {
    LOGGER.info("updateMktDepth");

  }

  @Override
  public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation,
      int side, double price, int size) {
    LOGGER.info("updateMktDepthL2");

  }

  @Override
  public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
    LOGGER.info("updateNewsBulletin");

  }

  @Override
  public void updatePortfolio(Contract contract, int position, double marketPrice,
      double marketValue, double averageCost, double unrealizedPNL, double realizedPNL,
      String accountName) {
    LOGGER.info("updatePortfolio");

  }

  @Override
  public void verifyCompleted(boolean isSuccessful, String errorText) {
    LOGGER.info("verifyCompleted");

  }

  @Override
  public void verifyMessageAPI(String apiData) {
    LOGGER.info("verifyMessageAPI");

  }

}
