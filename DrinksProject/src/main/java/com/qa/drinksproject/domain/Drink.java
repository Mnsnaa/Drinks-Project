package com.qa.drinksproject.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Drink {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message= "enter the drink name")
	private String name;
	
	@Column
	private String type;
	
	@Column
	private double  price;

	@Column
	private double amount;
	
	
	public Drink() {
		
	}
	
	// for Testing 
	
	public Drink(long id, String name, String type , double price, double amount) {
		
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
			
	}

	// for Creating 
	
	public Drink(String name, String type , double price, double amount ) {
		
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
		
		
	}
	
	// Getter and Setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", amount=" + amount
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, name, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(type, other.type);
	}
	
}

