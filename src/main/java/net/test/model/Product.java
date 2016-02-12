package net.test.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Product entity
 * 
 * @author Sergey
 */
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	private Long key;
	private String name;
	private Double price;
	private Date date;

	public Product() {
	}

	public Product(String name, Double price, Date date) {
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", date=" + date + "]";
	}
}
