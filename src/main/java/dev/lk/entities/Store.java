package dev.lk.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private int sid;
	
	@Column(name = "p_id")
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	@Column(name = "store_name")
	private String name;
	
	@Column(name = "base_url")
	private String baseUrl;

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(int sid, List<Product> products, String name, String baseUrl) {
		super();
		this.sid = sid;
		this.products = products;
		this.name = name;
		this.baseUrl = baseUrl;
	}

	@Override
	public String toString() {
		return "Store [sid=" + sid + ", products=" + products + ", name=" + name + ", baseUrl=" + baseUrl + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
