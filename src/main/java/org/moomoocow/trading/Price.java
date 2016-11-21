package org.moomoocow.trading;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "price",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"instrument_id", "date"})})

public class Price implements Serializable {

  private static final long serialVersionUID = -2799974456857391928L;

  private BigDecimal average;

  private BigDecimal close;

  private Date date;

  private boolean hasGaps;

  private BigDecimal high;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  private Instrument instrument;

  private BigDecimal low;

  private int numTrades;

  private BigDecimal open;

  private int volume;

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

  /**
   * @return the average
   */
  public BigDecimal getAverage() {
    return this.average;
  }

  /**
   * @return the close
   */
  public BigDecimal getClose() {
    return this.close;
  }

  /**
   * @return the date
   */
  public Date getDate() {
    return this.date;
  }

  /**
   * @return the high
   */
  public BigDecimal getHigh() {
    return this.high;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return this.id;
  }

  /**
   * @return the instrument
   */
  public Instrument getInstrument() {
    return this.instrument;
  }

  /**
   * @return the low
   */
  public BigDecimal getLow() {
    return this.low;
  }

  /**
   * @return the numTrades
   */
  public int getNumTrades() {
    return this.numTrades;
  }

  /**
   * @return the open
   */
  public BigDecimal getOpen() {
    return this.open;
  }

  /**
   * @return the volume
   */
  public int getVolume() {
    return this.volume;
  }

  /**
   * @return the hasGaps
   */
  public boolean isHasGaps() {
    return this.hasGaps;
  }

  /**
   * @param average the average to set
   */
  public void setAverage(BigDecimal average) {
    this.average = average;
  }

  /**
   * @param close the close to set
   */
  public void setClose(BigDecimal close) {
    this.close = close;
  }

  /**
   * @param date the date to set
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * @param hasGaps the hasGaps to set
   */
  public void setHasGaps(boolean hasGaps) {
    this.hasGaps = hasGaps;
  }

  /**
   * @param high the high to set
   */
  public void setHigh(BigDecimal high) {
    this.high = high;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @param instrument the instrument to set
   */
  public void setInstrument(Instrument instrument) {
    this.instrument = instrument;
  }

  /**
   * @param low the low to set
   */
  public void setLow(BigDecimal low) {
    this.low = low;
  }

  /**
   * @param numTrades the numTrades to set
   */
  public void setNumTrades(int numTrades) {
    this.numTrades = numTrades;
  }

  /**
   * @param open the open to set
   */
  public void setOpen(BigDecimal open) {
    this.open = open;
  }

  /**
   * @param volume the volume to set
   */
  public void setVolume(int volume) {
    this.volume = volume;
  }

  @Override
  public String toString() {
    return "Price [id=" + this.id + ", instrument=" + this.instrument + ", date=" + this.date
        + ", open=" + this.open + ", high=" + this.high + ", low=" + this.low + ", close="
        + this.close + ", average=" + this.average + ", volume=" + this.volume + ", numTrades="
        + this.numTrades + ", hasGaps=" + this.hasGaps + "]";
  }

  public static class Builder {
    private BigDecimal average;
    private BigDecimal close;
    private Date date;
    private boolean hasGaps;
    private BigDecimal high;
    private Long id;
    private Instrument instrument;
    private BigDecimal low;
    private int numTrades;
    private BigDecimal open;
    private int volume;

    public Builder average(BigDecimal average) {
      this.average = average;
      return this;
    }

    public Price build() {
      return new Price(this);
    }

    public Builder close(BigDecimal close) {
      this.close = close;
      return this;
    }

    public Builder date(Date date) {
      this.date = date;
      return this;
    }

    public Builder hasGaps(boolean hasGaps) {
      this.hasGaps = hasGaps;
      return this;
    }

    public Builder high(BigDecimal high) {
      this.high = high;
      return this;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder instrument(Instrument instrument) {
      this.instrument = instrument;
      return this;
    }

    public Builder low(BigDecimal low) {
      this.low = low;
      return this;
    }

    public Builder numTrades(int numTrades) {
      this.numTrades = numTrades;
      return this;
    }

    public Builder open(BigDecimal open) {
      this.open = open;
      return this;
    }

    public Builder volume(int volume) {
      this.volume = volume;
      return this;
    }
  }
}
