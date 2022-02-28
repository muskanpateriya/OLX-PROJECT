package com.olx.dto;



import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "MasterData DTO")
public class MasterData {

	//private List<String> categories = new ArrayList<String>();
	@ApiModelProperty(value = "MasterData Identification")
	private int id;
	@ApiModelProperty(value = "MasterData Category")
	private String category;
	@ApiModelProperty(value = "MasterData Description")
	private String description;
	
	public MasterData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MasterData(String categories, int id, String category) {
		super();
		this.id = id;
		this.category = category;
		this.description= description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "MasterData [id=" + id + ", category=" + category + ", description=" + description + "]";
	}
 	
}

