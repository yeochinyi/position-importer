package org.moomoocow.trading;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.ib.client.Contract;

/**
 * A Position.
 */
@Entity
@Table(name = "position", uniqueConstraints={@UniqueConstraint(columnNames={"instrument_id","date"})})
// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
// @Document(indexName = "position")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "position")
	private Long position;

	@Column(name = "avg_cost", precision = 10, scale = 2)
	private BigDecimal avgCost;

	@ManyToOne
	@JoinColumn(name = "instrument_id", nullable=false)
	private Instrument instrument;

	@Column(name = "date", nullable=false)
	private Date date;
	
	@Transient
	private Contract origContract;

	
	/**
	 * @return the origContract
	 */
	public Contract getOrigContract() {
		return origContract;
	}

	/**
	 * @param origContract the origContract to set
	 */
	public void setOrigContract(Contract origContract) {
		this.origContract = origContract;
	}

	public Position(){
		//this.date = new Date();
	}

	/**
	 * @return the datetime
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param datetime
	 *            the datetime to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public BigDecimal getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(BigDecimal avgCost) {
		this.avgCost = avgCost;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setContract(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Position position = (Position) o;
		if (position.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, position.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Position{" + "id=" + id + ", position='" + position + "'" + ", avgCost='" + avgCost + "'" + '}';
	}

	public static class Builder {
		private Long id;
		private Long position;
		private BigDecimal avgCost;
		private Instrument instrument;
		private Date date;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder position(Long position) {
			this.position = position;
			return this;
		}

		public Builder avgCost(BigDecimal avgCost) {
			this.avgCost = avgCost;
			return this;
		}

		public Builder instrument(Instrument instrument) {
			this.instrument = instrument;
			return this;
		}

		public Builder date(Date datetime) {
			this.date = datetime;
			return this;
		}

		public Position build() {
			return new Position(this);
		}
	}

	private Position(Builder builder) {
		this.id = builder.id;
		this.position = builder.position;
		this.avgCost = builder.avgCost;
		this.instrument = builder.instrument;
		this.date = builder.date;
	}
}
