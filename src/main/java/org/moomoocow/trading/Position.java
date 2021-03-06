package org.moomoocow.trading;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * A Position.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"date"})})
public class Position implements Serializable {

  private static final long serialVersionUID = 4630318760432404644L;

  private Date date;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long total;

  public Position() {
    this.date = new Date();
  }

  private Position(Builder builder) {
    this.id = builder.id;
    this.position = builder.position;
    this.avgCost = builder.avgCost;
    this.instrument = builder.instrument;
    this.date = builder.date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    final Position position = (Position) o;
    if (position.id == null || this.id == null) {
      return false;
    }
    return Objects.equals(this.id, position.id);
  }

  public BigDecimal getAvgCost() {
    return this.avgCost;
  }

  /**
   * @return the datetime
   */
  public Date getDate() {
    return this.date;
  }

  public Long getId() {
    return this.id;
  }

  public Instrument getInstrument() {
    return this.instrument;
  }

  public Long getPosition() {
    return this.position;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.id);
  }

  public void setAvgCost(BigDecimal avgCost) {
    this.avgCost = avgCost;
  }

  public void setContract(Instrument instrument) {
    this.instrument = instrument;
  }

  /**
   * @param datetime the datetime to set
   */
  public void setDate(Date date) {
    this.date = date;
  }

  public void setId(Long id) {
    this.id = id;
  }



  public void setPosition(Long position) {
    this.position = position;
  }



  @Override
  public String toString() {
    return "Position [id=" + this.id + ", position=" + this.position + ", avgCost=" + this.avgCost
        + ", instrument=" + this.instrument + ", date=" + this.date + "]";
  }

  public static class Builder {
    private BigDecimal avgCost;
    private Date date;
    private Long id;
    private Instrument instrument;
    private Long position;

    public Builder avgCost(BigDecimal avgCost) {
      this.avgCost = avgCost;
      return this;
    }

    public Position build() {
      return new Position(this);
    }

    public Builder date(Date datetime) {
      this.date = datetime;
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

    public Builder position(Long position) {
      this.position = position;
      return this;
    }
  }
}
