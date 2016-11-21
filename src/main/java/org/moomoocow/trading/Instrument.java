package org.moomoocow.trading;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instrument implements Serializable {

  private static final long serialVersionUID = 5478157949138458995L;

  private String currency;

  private String exchange;

  private String expiry;

  @Id
  private Long id;

  private boolean includeExpired; // can not be set to true for orders.

  private String localSymbol;

  private String multiplier;

  private String primaryExch; // pick a non-aggregate (ie not the SMART exchange) exchange that the
                              // contract trades on. DO NOT SET TO SMART.

  private String rights;

  private String secId;

  private String secIdType; // CUSIP;SEDOL;ISIN;RIC

  private String secType;

  private double strike;

  private String symbol;

  private String tradingClass;

  public Instrument() {}

  private Instrument(Builder builder) {
    this.id = builder.id;
    this.symbol = builder.symbol;
    this.secType = builder.secType;
    this.expiry = builder.expiry;
    this.strike = builder.strike;
    this.rights = builder.right;
    this.multiplier = builder.multiplier;
    this.exchange = builder.exchange;
    this.currency = builder.currency;
    this.localSymbol = builder.localSymbol;
    this.tradingClass = builder.tradingClass;
    this.primaryExch = builder.primaryExch;
    this.includeExpired = builder.includeExpired;
    this.secIdType = builder.secIdType;
    this.secId = builder.secId;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final Instrument other = (Instrument) obj;
    if (this.id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!this.id.equals(other.id)) {
      return false;
    }
    return true;
  }

  /**
   * @return the currency
   */
  public String getCurrency() {
    return this.currency;
  }

  /**
   * @return the exchange
   */
  public String getExchange() {
    return this.exchange;
  }

  /**
   * @return the expiry
   */
  public String getExpiry() {
    return this.expiry;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return this.id;
  }

  /**
   * @return the localSymbol
   */
  public String getLocalSymbol() {
    return this.localSymbol;
  }

  /**
   * @return the multiplier
   */
  public String getMultiplier() {
    return this.multiplier;
  }

  /**
   * @return the primaryExch
   */
  public String getPrimaryExch() {
    return this.primaryExch;
  }

  /**
   * @return the right
   */
  public String getRights() {
    return this.rights;
  }

  /**
   * @return the secId
   */
  public String getSecId() {
    return this.secId;
  }

  /**
   * @return the secIdType
   */
  public String getSecIdType() {
    return this.secIdType;
  }

  /**
   * @return the secType
   */
  public String getSecType() {
    return this.secType;
  }

  /**
   * @return the strike
   */
  public double getStrike() {
    return this.strike;
  }

  /**
   * @return the symbol
   */
  public String getSymbol() {
    return this.symbol;
  }

  /**
   * @return the tradingClass
   */
  public String getTradingClass() {
    return this.tradingClass;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (this.id == null ? 0 : this.id.hashCode());
    return result;
  }

  /**
   * @return the includeExpired
   */
  public boolean isIncludeExpired() {
    return this.includeExpired;
  }

  /**
   * @param currency the currency to set
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * @param exchange the exchange to set
   */
  public void setExchange(String exchange) {
    this.exchange = exchange;
  }

  /**
   * @param expiry the expiry to set
   */
  public void setExpiry(String expiry) {
    this.expiry = expiry;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @param includeExpired the includeExpired to set
   */
  public void setIncludeExpired(boolean includeExpired) {
    this.includeExpired = includeExpired;
  }

  /**
   * @param localSymbol the localSymbol to set
   */
  public void setLocalSymbol(String localSymbol) {
    this.localSymbol = localSymbol;
  }

  /**
   * @param multiplier the multiplier to set
   */
  public void setMultiplier(String multiplier) {
    this.multiplier = multiplier;
  }

  /**
   * @param primaryExch the primaryExch to set
   */
  public void setPrimaryExch(String primaryExch) {
    this.primaryExch = primaryExch;
  }

  /**
   * @param right the right to set
   */
  public void setRights(String rights) {
    this.rights = rights;
  }

  /**
   * @param secId the secId to set
   */
  public void setSecId(String secId) {
    this.secId = secId;
  }

  /**
   * @param secIdType the secIdType to set
   */
  public void setSecIdType(String secIdType) {
    this.secIdType = secIdType;
  }

  /**
   * @param secType the secType to set
   */
  public void setSecType(String secType) {
    this.secType = secType;
  }

  /**
   * @param strike the strike to set
   */
  public void setStrike(double strike) {
    this.strike = strike;
  }



  /**
   * @param symbol the symbol to set
   */
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  /**
   * @param tradingClass the tradingClass to set
   */
  public void setTradingClass(String tradingClass) {
    this.tradingClass = tradingClass;
  }



  @Override
  public String toString() {
    return "Instrument [id=" + this.id + ", symbol=" + this.symbol + ", secType=" + this.secType
        + ", expiry=" + this.expiry + ", strike=" + this.strike + ", rights=" + this.rights
        + ", multiplier=" + this.multiplier + ", exchange=" + this.exchange + ", currency="
        + this.currency + ", localSymbol=" + this.localSymbol + ", tradingClass="
        + this.tradingClass + ", primaryExch=" + this.primaryExch + ", includeExpired="
        + this.includeExpired + ", secIdType=" + this.secIdType + ", secId=" + this.secId + "]";
  }

  public static class Builder {
    private String currency;
    private String exchange;
    private String expiry;
    private Long id;
    private boolean includeExpired;
    private String localSymbol;
    private String multiplier;
    private String primaryExch;
    private String right;
    private String secId;
    private String secIdType;
    private String secType;
    private double strike;
    private String symbol;
    private String tradingClass;

    public Instrument build() {
      return new Instrument(this);
    }

    public Builder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public Builder exchange(String exchange) {
      this.exchange = exchange;
      return this;
    }

    public Builder expiry(String expiry) {
      this.expiry = expiry;
      return this;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder includeExpired(boolean includeExpired) {
      this.includeExpired = includeExpired;
      return this;
    }

    public Builder localSymbol(String localSymbol) {
      this.localSymbol = localSymbol;
      return this;
    }

    public Builder multiplier(String multiplier) {
      this.multiplier = multiplier;
      return this;
    }

    public Builder primaryExch(String primaryExch) {
      this.primaryExch = primaryExch;
      return this;
    }

    public Builder right(String right) {
      this.right = right;
      return this;
    }

    public Builder secId(String secId) {
      this.secId = secId;
      return this;
    }

    public Builder secIdType(String secIdType) {
      this.secIdType = secIdType;
      return this;
    }

    public Builder secType(String secType) {
      this.secType = secType;
      return this;
    }

    public Builder strike(double strike) {
      this.strike = strike;
      return this;
    }

    public Builder symbol(String symbol) {
      this.symbol = symbol;
      return this;
    }

    public Builder tradingClass(String tradingClass) {
      this.tradingClass = tradingClass;
      return this;
    }
  }
}
