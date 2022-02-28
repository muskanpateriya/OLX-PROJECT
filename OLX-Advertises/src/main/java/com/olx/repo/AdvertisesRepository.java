package com.olx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olx.entity.AdvertisesEntity;


@Repository
public interface AdvertisesRepository extends JpaRepository<AdvertisesEntity,Integer>{

}
