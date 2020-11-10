package dev.lk.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.lk.entities.Customer;
import dev.lk.entities.Price;
import dev.lk.entities.Product;
import dev.lk.repositories.CustomerRepository;
import dev.lk.repositories.PriceRepository;
import dev.lk.repositories.ProductRepository;

@Component
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	CustomerRepository cr;
	@Autowired
	ProductRepository prodr;
	@Autowired
	PriceRepository pricer;
	
	@Override
	public Product addProduct(Product p) {
		return prodr.save(p);
	}
	
	@Override
	public Product addProduct(int cid, String url) {
		System.setProperty("webdriver.chrome.driver", "../PriceTracker/src/main/resources/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
//		chromeOptions.addArguments("--test-type");
//		chromeOptions.addArguments("--disable-gpu");
//		chromeOptions.addArguments("--no-first-run");
//		chromeOptions.addArguments("--no-default-browser-check");
//		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Product p = null;
		if(url.contains("www.amazon.com")) {
			p = getAmazon(cid, url, driver);
		}else if(url.contains("www.ebay.com")) {
			p = getEbay(cid, url, driver);
		}
		return p;
	}

	private Product getAmazon(int cid, String url, WebDriver driver) {
		int index = url.indexOf("?");
		if(index != -1) {
			url.substring(0, index);
		}
		driver.get(url);
		
		Product p = new Product();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='productTitle']"))));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText());
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='cerberus_feature_div']"))));
		
		WebElement e = driver.findElement(By.xpath("//*[@id='cerberus-data-metrics']"));
		
		String title = driver.findElement(By.id("productTitle")).getText();
		String productId = e.getAttribute("data-asin");
		double amount = Double.parseDouble(e.getAttribute("data-asin-price"));
		double shipping = Double.parseDouble(e.getAttribute("data-asin-shipping"));
		String currCode = e.getAttribute("data-asin-currency-code");
		String imageUrl = driver.findElement(By.id("landingImage")).getAttribute("src");
		
		driver.close();
		driver.quit();
		
		Timestamp priceTime = new Timestamp(System.currentTimeMillis());
		
		p.setTitle(title);
		p.setProductId(productId);
		p.setStore("amazon");
		
		p.setImageUrl(imageUrl);
		
		Customer c = cr.findById(cid).orElse(null);
		p.getCustomers().add(c);
		
		p=prodr.save(p);
		
		Price price = new Price();
		price.setPrid(0);
		price.setProduct(p);
		price.setAmount(amount);
		price.setPriceTime(priceTime);
		price.setShipping(shipping);

		price = pricer.save(price);
		
		
		p.getPrices().add(price);
		
		return p;
		
	}
	
	private Product getEbay(int cid, String url, WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Product getProductById(int id) {
		return prodr.findById(id).orElse(null);
	}

	@Override
	public List<Product> getProductsByTitle(String title) {
		return prodr.findByTitleContainsIgnoreCase(title);
	}

	@Override
	public List<Product> getProducts() {
		return (List<Product>) prodr.findAll();
	}

	@Override
	public Product updateProduct(Product p) {
		return prodr.save(p);
	}

	@Override
	public boolean deleteProduct(Product p) {
		prodr.delete(p);
		return true;
	}

	@Override
	public Price updatePrice(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

}
