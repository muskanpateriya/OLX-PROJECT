package com.olx.services;

import java.util.List;

import com.olx.dto.Categories;
import com.olx.dto.Status;

public interface MasterdataServices {
	public List<Categories> getAllCategories();
	public Categories create(Categories categories);
	public Categories getCategoriesById(int categoriesId );
	public boolean deleteCategoriesById(int categoriesId);
	public List<Status> getAllStatus();
	public Status getStatusById(int statusId);
	public Status updateStatus(Status status,int statusId);

}
