package dev.lk.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int pid;

	@OneToMany(mappedBy="product", fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"product"})
	private List<Price> prices = new ArrayList<Price>();
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "store")
	private String store;
	
	@Column(name = "product_id")
	private String productId;
	
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	@Column(name = "image_url")
	private String imageUrl;

	@ManyToMany(mappedBy = "products")
	@JsonIgnoreProperties({"products"})
	private Set<Customer> customers = new HashSet<Customer>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, List<Price> prices, String title,String productId, String imageUrl, Set<Customer> customers) {
		super();
		this.pid = pid;
		this.prices = prices;
		this.title = title;
		this.productId = productId;
		this.imageUrl = imageUrl;
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", title=" + title + ", productId=" + productId + ", price=" + prices.get(0) 
				+ ", imageUrl=" + imageUrl + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	
}
