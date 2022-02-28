package com.olx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name = "categories")

public class CategoriesEntity {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	public CategoriesEntity(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "CategoriesEntity [id=" + id + ", name=" + name + ", description=" + description + "]";
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
	public CategoriesEntity() {
		super();
	
	}
}
