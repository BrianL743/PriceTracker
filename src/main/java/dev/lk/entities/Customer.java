package dev.lk.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	private int cid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	public Customer() {
		super();
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_product", joinColumns = {@JoinColumn(name="c_id")}, inverseJoinColumns = {@JoinColumn(name="p_id")})
	@JsonIgnoreProperties({"customers"})
	private List<Product> products = new ArrayList<Product>();

	public Customer(int cid, String username, String password, List<Product> products) {
		super();
		this.cid = cid;
		this.username = username;
		this.password = password;
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", username=" + username + ", password=" + password + ", products=" + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
