package com.olx.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Categories;
import com.olx.dto.Status;
import com.olx.entity.CategoriesEntity;
import com.olx.entity.StatusEntity;
import com.olx.repo.CategoriesRepository;
import com.olx.repo.StatusRepository;
@Service
public class MasterdataServicesImp implements MasterdataServices {
	@Autowired 
	CategoriesRepository categoriesRepository;
	@Autowired
	StatusRepository statusRepository;

	@Autowired
	ModelMapper modelMapper;
	@Override
	public List<Categories> getAllCategories() {
		List<CategoriesEntity> entityList = categoriesRepository.findAll();
		List<Categories> categoryList = new ArrayList<>();
		for (CategoriesEntity entity : entityList) {
			Categories stock = convertCategoriesEntityToCategoriesDTO(entity);
			categoryList.add(stock);
		}
		return categoryList;
	}

	@Override
	public Categories create(Categories categories) {
		CategoriesEntity entity = convertCategoriesDTOToCategoriesEntity(categories);
		categoriesRepository.save(entity);
		return categories;
		
	}

	@Override
	public Categories getCategoriesById(int categoriesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCategoriesById(int categoriesId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Status> getAllStatus() {
		List<StatusEntity> entityList = statusRepository.findAll();
		List<Status> statusList = new ArrayList<>();
		for (StatusEntity entity : entityList) {
			Status status = convertStatusEntityToStatusDTO(entity);
			statusList.add(status);
		}
		return statusList;
	}

	@Override
	public Status getStatusById(int statusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status updateStatus(Status status, int statusId) {
		Optional<StatusEntity> optStock = statusRepository.findById(statusId);
		if (optStock.isPresent()) {
			StatusEntity entity = convertStatusDTOToStatusEntity(status);
			statusRepository.save(entity);
			return status;
		}
		return null;
	}
	private CategoriesEntity convertCategoriesDTOToCategoriesEntity(Categories dto) {
		TypeMap<Categories, CategoriesEntity> typeMap = this.modelMapper.typeMap(Categories.class, CategoriesEntity.class);
		typeMap.addMappings(mapper -> {
			mapper.map(Categories::getDescription, CategoriesEntity::setDescription);
			mapper.map(Categories::getName, CategoriesEntity::setName);
			mapper.map(Categories::getId, CategoriesEntity::setId);
		});
		return this.modelMapper.map(dto, CategoriesEntity.class);
	}

	private Categories convertCategoriesEntityToCategoriesDTO(CategoriesEntity entity) {
		TypeMap<CategoriesEntity, Categories> typeMap = this.modelMapper.typeMap(CategoriesEntity.class, Categories.class);
		typeMap.addMappings(mapper -> {
			mapper.map(CategoriesEntity::getName, Categories::setName);
			mapper.map(CategoriesEntity::getDescription, Categories::setDescription);
			mapper.map(CategoriesEntity::getId, Categories::setId);
		});
		return this.modelMapper.map(entity, Categories.class);
	}
	private StatusEntity convertStatusDTOToStatusEntity(Status dto) {
		TypeMap<Status, StatusEntity> typeMap = this.modelMapper.typeMap(Status.class, StatusEntity.class);
		typeMap.addMappings(mapper -> {
			mapper.map(Status::getStatus, StatusEntity::setStatus);
			mapper.map(Status::getId, StatusEntity::setId);
		});
		return this.modelMapper.map(dto, StatusEntity.class);
	}

	private Status convertStatusEntityToStatusDTO(StatusEntity entity) {
		TypeMap<StatusEntity, Status> typeMap = this.modelMapper.typeMap(StatusEntity.class, Status.class);
		typeMap.addMappings(mapper -> {
			mapper.map(StatusEntity::getStatus, Status::setStatus);
			mapper.map(StatusEntity::getId, Status::setId);
		});
		return this.modelMapper.map(entity, Status.class);
	}



}
