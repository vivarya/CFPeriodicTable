package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Element {
	@Id
	private String symbol ;
	private String name ;
	private double mass ;
	public Element () {
		
	}
	public Element(String ticker, double price, String name) {
		super();
		this.symbol = ticker;
		this.mass = price;
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String ticker) {
		this.symbol = ticker;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double price) {
		this.mass = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Element [symbol=" + symbol + ", name=" + name + ", mass=" + mass + "]";
	}
	
}
