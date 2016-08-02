package org.moomoocow.trading;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {

	private static final long serialVersionUID = 5478157949138458995L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "symbol")
	private String symbol;

	@Column(name = "secType")
	private String secType;

	@Column(name = "expiry")
	private String expiry;

	@Column(name = "strike")
	private double strike;

	@Column(name = "rights")
	private String rights;

	@Column(name = "multiplier")
	private String multiplier;

	@Column(name = "exchange")
	private String exchange;

	@Column(name = "currency")
	private String currency;

	@Column(name = "localSymbol")
	private String localSymbol;

	@Column(name = "tradingClass")
	private String tradingClass;

	@Column(name = "primaryExch")
	private String primaryExch; // pick a non-aggregate (ie not the SMART exchange) exchange that the contract trades on.  DO NOT SET TO SMART.

	@Column(name = "includeExpired")
	private boolean includeExpired; // can not be set to true for orders.

	@Column(name = "secIdType")
	private String secIdType; // CUSIP;SEDOL;ISIN;RIC

	@Column(name = "secId")
	private String secId;
	
	public Instrument(){}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the secType
	 */
	public String getSecType() {
		return secType;
	}

	/**
	 * @param secType the secType to set
	 */
	public void setSecType(String secType) {
		this.secType = secType;
	}

	/**
	 * @return the expiry
	 */
	public String getExpiry() {
		return expiry;
	}

	/**
	 * @param expiry the expiry to set
	 */
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	/**
	 * @return the strike
	 */
	public double getStrike() {
		return strike;
	}

	/**
	 * @param strike the strike to set
	 */
	public void setStrike(double strike) {
		this.strike = strike;
	}

	/**
	 * @return the right
	 */
	public String getRights() {
		return rights;
	}

	/**
	 * @param right the right to set
	 */
	public void setRights(String rights) {
		this.rights = rights;
	}

	/**
	 * @return the multiplier
	 */
	public String getMultiplier() {
		return multiplier;
	}

	/**
	 * @param multiplier the multiplier to set
	 */
	public void setMultiplier(String multiplier) {
		this.multiplier = multiplier;
	}

	/**
	 * @return the exchange
	 */
	public String getExchange() {
		return exchange;
	}

	/**
	 * @param exchange the exchange to set
	 */
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the localSymbol
	 */
	public String getLocalSymbol() {
		return localSymbol;
	}
	/**
	 * @param localSymbol the localSymbol to set
	 */
	public void setLocalSymbol(String localSymbol) {
		this.localSymbol = localSymbol;
	}

	/**
	 * @return the tradingClass
	 */
	public String getTradingClass() {
		return tradingClass;
	}

	/**
	 * @param tradingClass the tradingClass to set
	 */
	public void setTradingClass(String tradingClass) {
		this.tradingClass = tradingClass;
	}

	/**
	 * @return the primaryExch
	 */
	public String getPrimaryExch() {
		return primaryExch;
	}

	/**
	 * @param primaryExch the primaryExch to set
	 */
	public void setPrimaryExch(String primaryExch) {
		this.primaryExch = primaryExch;
	}

	/**
	 * @return the includeExpired
	 */
	public boolean isIncludeExpired() {
		return includeExpired;
	}

	/**
	 * @param includeExpired the includeExpired to set
	 */
	public void setIncludeExpired(boolean includeExpired) {
		this.includeExpired = includeExpired;
	}

	/**
	 * @return the secIdType
	 */
	public String getSecIdType() {
		return secIdType;
	}

	/**
	 * @param secIdType the secIdType to set
	 */
	public void setSecIdType(String secIdType) {
		this.secIdType = secIdType;
	}

	/**
	 * @return the secId
	 */
	public String getSecId() {
		return secId;
	}

	/**
	 * @param secId the secId to set
	 */
	public void setSecId(String secId) {
		this.secId = secId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contract [\nid=" + id + ", \nsymbol=" + symbol + ", \nsecType=" + secType + ", \nexpiry=" + expiry
				+ ", \nstrike=" + strike + ", \nrights=" + rights + ", \nmultiplier=" + multiplier + ", \nexchange="
				+ exchange + ", \ncurrency=" + currency + ", \nlocalSymbol=" + localSymbol + ", \ntradingClass="
				+ tradingClass + ", \nprimaryExch=" + primaryExch + ", \nincludeExpired=" + includeExpired
				+ ", \nsecIdType=" + secIdType + ", \nsecId=" + secId + "\n]";
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrument other = (Instrument) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public static class Builder {
		private Long id;
		private String symbol;
		private String secType;
		private String expiry;
		private double strike;
		private String right;
		private String multiplier;
		private String exchange;
		private String currency;
		private String localSymbol;
		private String tradingClass;
		private String primaryExch;
		private boolean includeExpired;
		private String secIdType;
		private String secId;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder symbol(String symbol) {
			this.symbol = symbol;
			return this;
		}

		public Builder secType(String secType) {
			this.secType = secType;
			return this;
		}

		public Builder expiry(String expiry) {
			this.expiry = expiry;
			return this;
		}

		public Builder strike(double strike) {
			this.strike = strike;
			return this;
		}

		public Builder right(String right) {
			this.right = right;
			return this;
		}

		public Builder multiplier(String multiplier) {
			this.multiplier = multiplier;
			return this;
		}

		public Builder exchange(String exchange) {
			this.exchange = exchange;
			return this;
		}

		public Builder currency(String currency) {
			this.currency = currency;
			return this;
		}

		public Builder localSymbol(String localSymbol) {
			this.localSymbol = localSymbol;
			return this;
		}

		public Builder tradingClass(String tradingClass) {
			this.tradingClass = tradingClass;
			return this;
		}

		public Builder primaryExch(String primaryExch) {
			this.primaryExch = primaryExch;
			return this;
		}

		public Builder includeExpired(boolean includeExpired) {
			this.includeExpired = includeExpired;
			return this;
		}

		public Builder secIdType(String secIdType) {
			this.secIdType = secIdType;
			return this;
		}

		public Builder secId(String secId) {
			this.secId = secId;
			return this;
		}

		public Instrument build() {
			return new Instrument(this);
		}
	}

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
}
