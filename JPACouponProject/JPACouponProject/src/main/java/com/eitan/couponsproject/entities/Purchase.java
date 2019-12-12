package com.eitan.couponsproject.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Purchases")
public class Purchase implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="Amount", nullable = false)
	private int amount;

	@ManyToOne
	@MapsId("ID")
	private Coupon coupon;
	
	@ManyToOne
	@MapsId("ID")
	private Customer customer;

	public Purchase() {
	}
	
	public Purchase(int amount, Coupon coupon, Customer customer) {
		this.amount = amount;
		this.coupon = coupon;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", amount=" + amount + ", coupon=" + coupon + ", customer=" + customer + "]";
	}
	

}
