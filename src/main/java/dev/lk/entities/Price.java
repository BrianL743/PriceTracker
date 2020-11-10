package dev.lk.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "price")
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pr_id")
	private int prid;
	
	@ManyToOne
	@JoinColumn(name="p_id")
	@JsonIgnoreProperties({"prices"})
	private Product product;
	
	@Column(name = "price_time")
	private Timestamp priceTime;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "shipping")
	private double shipping;

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Price(int prid, Timestamp priceTime, double amount, double shipping) {
		super();
		this.prid = prid;
		this.priceTime = priceTime;
		this.amount = amount;
		this.shipping = shipping;
	}

	@Override
	public String toString() {
		return "Price [prid=" + prid + ", priceTime=" + priceTime + ", amount=" + amount + ", shipping=" + shipping + "]";
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}

	public int getPrid() {
		return prid;
	}

	public void setPrid(int prid) {
		this.prid = prid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Timestamp getPriceTime() {
		return priceTime;
	}

	public void setPriceTime(Timestamp priceTime) {
		this.priceTime = priceTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
