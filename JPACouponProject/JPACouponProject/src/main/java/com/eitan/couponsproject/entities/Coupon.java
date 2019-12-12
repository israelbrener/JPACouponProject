package com.eitan.couponsproject.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Coupons")
public class Coupon implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "Title", unique = true, nullable = false)
	private String title;

	@Column(name = "Start_Date", nullable = false)
	private Date startDate;

	@Column(name = "End_Date", nullable = false)
	private Date endDate;

	@Column(name = "Amount", nullable = false)
	private int amount;

	@Column(name = "Type", nullable = false)
	private String type;

	@Column(name = "Price", nullable = false)
	private float price;

	@Column(name = "Description", nullable = false)
	private String description;

	@ManyToOne
	@MapsId("ID")
	private Company company;
	
	@OneToMany(mappedBy = "coupon", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Purchase> purchases;

	public Coupon() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Company getCompanyId() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", amount=" + amount + ", type=" + type + ", price=" + price + ", description=" + description
				+ ", company=" + company + "]";
	}



}
