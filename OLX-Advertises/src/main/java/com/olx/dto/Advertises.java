package com.olx.dto;

public class Advertises {
	private int id;
	private String title;
	private String category;
	private String status;
	private String price;
	private String description;
	private String username;
	private String createdDate;
	private String modifiedDate;

	public Advertises() {
		super();

	}

	public Advertises(int id, String title, String category, String status, String price, String description,
			String username, String createdDate, String modifiedDate) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.status = status;
		this.price = price;
		this.description = description;
		this.username = username;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Advertises [id=" + id + ", title=" + title + ", categories=" + category + ", status=" + status
				+ ", price=" + price + ", description=" + description + ", username=" + username + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
