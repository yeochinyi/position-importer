package org.moomoocow.trading.tws;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EWrapperForwarder {// implements EWrapper {

  private static final Logger LOGGER = LoggerFactory.getLogger(EWrapperForwarder.class);

  private final List<EWrapperForwarder> forwarders;

  public EWrapperForwarder() {
    this.forwarders = new ArrayList<>();
  }

  // @Override
  // public void accountDownloadEnd(String accountName) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void accountSummary(int reqId, String account, String tag, String value, String
  // currency) {
  // this.forwarders.forEach(f -> f.accountSummary(reqId, account, tag, value, currency));
  // }

  // @Override
  // public void accountSummaryEnd(int reqId) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void bondContractDetails(int reqId, ContractDetails contractDetails) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void commissionReport(CommissionReport commissionReport) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  //
  // }
  //
  // @Override
  // public void connectionClosed() {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void contractDetails(int reqId, ContractDetails contractDetails) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void contractDetailsEnd(int reqId) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void currentTime(long time) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void deltaNeutralValidation(int reqId, UnderComp underComp) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void displayGroupList(int reqId, String groups) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void displayGroupUpdated(int reqId, String contractInfo) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void error(Exception e) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void error(int id, int errorCode, String errorMsg) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void error(String str) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void execDetails(int reqId, Contract contract, Execution execution) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void execDetailsEnd(int reqId) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void fundamentalData(int reqId, String data) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void historicalData(int reqId, String date, double open, double high, double low,
  // double close, int volume, int count, double WAP, boolean hasGaps) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void managedAccounts(String accountsList) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void marketDataType(int reqId, int marketDataType) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void nextValidId(int orderId) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  //
  // @Override
  // public void openOrderEnd() {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void orderStatus(int orderId, String status, int filled, int remaining,
  // double avgFillPrice, int permId, int parentId, double lastFillPrice, int clientId,
  // String whyHeld) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void position(String account, Contract contract, int pos, double avgCost) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void positionEnd() {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void realtimeBar(int reqId, long time, double open, double high, double low, double
  // close,
  // long volume, double wap, int count) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void receiveFA(int faDataType, String xml) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance,
  // String benchmark, String projection, String legsStr) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void scannerDataEnd(int reqId) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void scannerParameters(String xml) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void tickEFP(int tickerId, int tickType, double basisPoints, String
  // formattedBasisPoints,
  // double impliedFuture, int holdDays, String futureExpiry, double dividendImpact,
  // double dividendsToExpiry) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void tickGeneric(int tickerId, int tickType, double value) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta,
  // double optPrice, double pvDividend, double gamma, double vega, double theta,
  // double undPrice) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void tickSize(int tickerId, int field, int size) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  // }
  //
  // @Override
  // public void tickSnapshotEnd(int reqId) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void tickString(int tickerId, int tickType, String value) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  //
  // }
  //
  // @Override
  // public void updateAccountTime(String timeStamp) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  //
  //
  // }
  //
  // @Override
  // public void updateAccountValue(String key, String value, String currency, String accountName) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void updateMktDepth(int tickerId, int position, int operation, int side, double price,
  // int size) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation,
  // int side, double price, int size) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void updatePortfolio(Contract contract, int position, double marketPrice,
  // double marketValue, double averageCost, double unrealizedPNL, double realizedPNL,
  // String accountName) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void verifyCompleted(boolean isSuccessful, String errorText) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }
  //
  // @Override
  // public void verifyMessageAPI(String apiData) {
  // this.forwarders.forEach(f -> f.accountDownloadEnd(accountName));
  // }

}
