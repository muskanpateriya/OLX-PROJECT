package com.olx.actuator;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.olx.entity.CategoriesEntity;
import com.olx.repo.CategoriesRepository;




@Component
@Endpoint(id = "users")
public class OlxMasterDataCustomActuatorEndPoint {

	@Autowired
	private CategoriesRepository categoriesRepository;

	@ReadOperation
	public List<CategoriesEntity> getAllUsers() {
		return categoriesRepository.findAll();
	}

}
