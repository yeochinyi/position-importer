package org.moomoocow.trading.tws;

import java.util.concurrent.Phaser;

import org.moomoocow.trading.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ib.client.Contract;
import com.ib.client.ContractDetails;

@Service
public class ContractGetter extends EWrapperBlanker {

  private static final Logger LOGGER = LoggerFactory.getLogger(ContractGetter.class);

  public static Contract getContract(Instrument myContract) {
    return new Contract(myContract.getId().intValue(), myContract.getSymbol(),
        myContract.getSecType(), myContract.getExpiry(), myContract.getStrike(),
        myContract.getRights(), myContract.getMultiplier(), myContract.getExchange(),
        myContract.getCurrency(), myContract.getLocalSymbol(), myContract.getTradingClass(),
        // myContract.getComboLegs(),
        null,
        // myContract.getPrimaryExch(),
        "Smart",
        // myContract.getIncludeExpired(),
        true, myContract.getSecIdType(), myContract.getSecId());
  }

  private ContractDetails contractDetails;

  private int counter = 0;

  @Override
  public void contractDetails(int reqId, ContractDetails contractDetails) {
    LOGGER.info("contractDetails");
    this.contractDetails = contractDetails;
    this.phaser.arriveAndDeregister();
  }

  public ContractDetails getContractDetails(Instrument i) {
    this.phaser = new Phaser(2);
    final Contract contract = getContract(i);
    this.eclientSocket.reqContractDetails(this.counter++, contract);
    this.phaser.arriveAndAwaitAdvance();
    return this.contractDetails;


  }


}
