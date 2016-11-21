package org.moomoocow.trading.tws;

import org.moomoocow.trading.Instrument;

public class FundamentalGetter {


  public void getFundamentalData(Instrument i) {
    // https://www.interactivebrokers.com/en/software/api/apiguide/java/reqfundamentaldata.htm
    /*
     * ReportSnapshot (company overview) ReportsFinSummary (financial summary) ReportRatios
     * (financial ratios) ReportsFinStatements (financial statements) RESC (analyst estimates)
     * CalendarReport (company calendar)
     */
    // int reqId = this.tickerCounter.getAndIncrement();
    // Contract c = getContract(i);
    // eclient.reqFundamentalData(reqId, c, "ReportSnapshot");
    // waitFor();

  }

}
