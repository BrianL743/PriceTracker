package dev.lk.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int pid;
	
	@Column(name = "s_id")
	@ManyToOne
	@JoinColumn(name = "s_id")
	private Store store;
	
	@Column(name = "pr_id")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pr_id")
	private Price price;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "image_url")
	private String imageUrl;

	@ManyToMany(mappedBy = "products")
	private List<Customer> customers = new ArrayList<Customer>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, Store store, Price price, String productName, String imageUrl, List<Customer> customers) {
		super();
		this.pid = pid;
		this.store = store;
		this.price = price;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", store=" + store + ", price=" + price + ", productName=" + productName
				+ ", imageUrl=" + imageUrl + ", customers=" + customers + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
}
