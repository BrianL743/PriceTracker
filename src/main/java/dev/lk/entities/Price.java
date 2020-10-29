package dev.lk.entities;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pr_id")
	private int prid;
	
	@Column(name = "p_id")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "p_id")
	private Product product;
	
	@Column(name = "check_time")
	private LocalDateTime checkTime;
	
	@Column(name = "amount")
	private double amount;

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Price(int prid, Product product, LocalDateTime checkTime, double amount) {
		super();
		this.prid = prid;
		this.product = product;
		this.checkTime = checkTime;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Price [prid=" + prid + ", product=" + product + ", checkTime=" + checkTime + ", amount=" + amount + "]";
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

	public LocalDateTime getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(LocalDateTime checkTime) {
		this.checkTime = checkTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
