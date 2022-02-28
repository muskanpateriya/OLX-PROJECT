package com.olx.actuator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.olx.entity.AdvertisesEntity;
import com.olx.repo.AdvertisesRepository;

@Component
@Endpoint(id = "orders")
public class OLXAdvertiseCustomActuator {
	
	@Autowired
	AdvertisesRepository advertisesRepository;
	
	@ReadOperation
	public List<AdvertisesEntity> getAllUsers() {
		return advertisesRepository.findAll();
	}

}
