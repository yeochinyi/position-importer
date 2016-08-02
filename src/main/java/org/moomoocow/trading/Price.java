package org.moomoocow.trading;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "price", uniqueConstraints = { @UniqueConstraint(columnNames = { "instrument_id", "date" }) })

public class Price implements Serializable {

	private static final long serialVersionUID = -2799974456857391928L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "instrument_id", nullable=false)
	private Instrument instrument;

	@Column(name = "date")
	private Date date;

	@Column(name = "open")
	private BigDecimal open;

	@Column(name = "high")
	private BigDecimal high;

	@Column(name = "low")
	private BigDecimal low;

	@Column(name = "close")
	private BigDecimal close;

	@Column(name = "average")
	private BigDecimal average;

	@Column(name = "volume")
	private int volume;

	@Column(name = "numTrades")
	private int numTrades;

	@Column(name = "hasGaps")
	private boolean hasGaps;

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
	 * @return the instrument
	 */
	public Instrument getInstrument() {
		return instrument;
	}

	/**
	 * @param instrument the instrument to set
	 */
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the open
	 */
	public BigDecimal getOpen() {
		return open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	/**
	 * @return the high
	 */
	public BigDecimal getHigh() {
		return high;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	/**
	 * @return the low
	 */
	public BigDecimal getLow() {
		return low;
	}

	/**
	 * @param low the low to set
	 */
	public void setLow(BigDecimal low) {
		this.low = low;
	}

	/**
	 * @return the close
	 */
	public BigDecimal getClose() {
		return close;
	}

	/**
	 * @param close the close to set
	 */
	public void setClose(BigDecimal close) {
		this.close = close;
	}

	/**
	 * @return the average
	 */
	public BigDecimal getAverage() {
		return average;
	}

	/**
	 * @param average the average to set
	 */
	public void setAverage(BigDecimal average) {
		this.average = average;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	/**
	 * @return the numTrades
	 */
	public int getNumTrades() {
		return numTrades;
	}

	/**
	 * @param numTrades the numTrades to set
	 */
	public void setNumTrades(int numTrades) {
		this.numTrades = numTrades;
	}

	/**
	 * @return the hasGaps
	 */
	public boolean isHasGaps() {
		return hasGaps;
	}

	/**
	 * @param hasGaps the hasGaps to set
	 */
	public void setHasGaps(boolean hasGaps) {
		this.hasGaps = hasGaps;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Price [\nid=" + id + ", \ninstrument=" + instrument + ", \ndate=" + date + ", \nopen=" + open + ", \nhigh="
				+ high + ", \nlow=" + low + ", \nclose=" + close + ", \naverage=" + average + ", \nvolume=" + volume
				+ ", \nnumTrades=" + numTrades + ", \nhasGaps=" + hasGaps + "\n]";
	}

	public static class Builder {
		private Long id;
		private Instrument instrument;
		private Date date;
		private BigDecimal open;
		private BigDecimal high;
		private BigDecimal low;
		private BigDecimal close;
		private BigDecimal average;
		private int volume;
		private int numTrades;
		private boolean hasGaps;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder instrument(Instrument instrument) {
			this.instrument = instrument;
			return this;
		}

		public Builder date(Date date) {
			this.date = date;
			return this;
		}

		public Builder open(BigDecimal open) {
			this.open = open;
			return this;
		}

		public Builder high(BigDecimal high) {
			this.high = high;
			return this;
		}

		public Builder low(BigDecimal low) {
			this.low = low;
			return this;
		}

		public Builder close(BigDecimal close) {
			this.close = close;
			return this;
		}

		public Builder average(BigDecimal average) {
			this.average = average;
			return this;
		}

		public Builder volume(int volume) {
			this.volume = volume;
			return this;
		}

		public Builder numTrades(int numTrades) {
			this.numTrades = numTrades;
			return this;
		}

		public Builder hasGaps(boolean hasGaps) {
			this.hasGaps = hasGaps;
			return this;
		}

		public Price build() {
			return new Price(this);
		}
	}

	private Price(Builder builder) {
		this.id = builder.id;
		this.instrument = builder.instrument;
		this.date = builder.date;
		this.open = builder.open;
		this.high = builder.high;
		this.low = builder.low;
		this.close = builder.close;
		this.average = builder.average;
		this.volume = builder.volume;
		this.numTrades = builder.numTrades;
		this.hasGaps = builder.hasGaps;
	}
}
