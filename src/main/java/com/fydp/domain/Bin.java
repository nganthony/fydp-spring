package com.fydp.domain;

import java.sql.Timestamp;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Bin {
	private int id;
	private int binSystemId;
	private String name;
	private String description;
	private String imageUrl;
	private String purchaseUrl;
	private double massPerItem;
	private double totalMass;
	private Timestamp createdTimestamp;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBinSystemId() {
		return binSystemId;
	}
	
	public void setBinSystemId(int binSystemId) {
		this.binSystemId = binSystemId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getPurchaseUrl() {
		return purchaseUrl;
	}
	
	public void setPurchaseUrl(String purchaseUrl) {
		this.purchaseUrl = purchaseUrl;
	}
	
	public double getMassPerItem() {
		return massPerItem;
	}
	
	public void setMassPerItem(double massPerItem) {
		this.massPerItem = massPerItem;
	}
	
	public double getTotalMass() {
		return totalMass;
	}
	
	public void setTotalMass(double totalMass) {
		this.totalMass = totalMass;
	}
	
	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}
	
	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
}
