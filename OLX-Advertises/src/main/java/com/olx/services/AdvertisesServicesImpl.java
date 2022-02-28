package com.olx.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.olx.dto.Advertises;
import com.olx.entity.AdvertisesEntity;
import com.olx.exception.InvalidAdvertiseIdException;
import com.olx.exception.InvalidAuthTokenException;
import com.olx.repo.AdvertisesRepository;

@Service

public class AdvertisesServicesImpl implements AdvertiseServices {

	@Autowired
	AdvertisesRepository advertisesRepository;
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	EntityManager entityManager;

	@Override
	public Advertises postNewadvertise(Advertises advertises, String authToken) {
		AdvertisesEntity entity = convertAdvertisesDTOToAdvertisesEntity(advertises);
		advertisesRepository.save(entity);
		return advertises;
	}

	@Override
	public Advertises UpdatesExistingAdvertise(Advertises advertises, int advertiseId, String authToken) {
		Optional<AdvertisesEntity> optStock = advertisesRepository.findById(advertiseId);
		if (optStock.isPresent()) {
			AdvertisesEntity entity = convertAdvertisesDTOToAdvertisesEntity(advertises);
			advertisesRepository.save(entity);
			return advertises;
		}
		throw new InvalidAuthTokenException("" + authToken);
	}

	@Override
	public List<Advertises> readsAllAdvertisements(String authToken) {
		List<AdvertisesEntity> entityList = advertisesRepository.findAll();
		List<Advertises> advertisesList = new ArrayList<>();
		for (AdvertisesEntity entity : entityList) {
			Advertises advertises = convertAdvertisesEntityToAdvertisesDTO(entity);
			advertisesList.add(advertises);
		}
		return advertisesList;
	}

	@Override
	public Advertises getAdvertisementById(int advertiseId, String authToken) {
		Optional<AdvertisesEntity> optEntity = advertisesRepository.findById(advertiseId);
		if (optEntity.isPresent()) {
			AdvertisesEntity entity = optEntity.get();
			return convertAdvertisesEntityToAdvertisesDTO(entity);
		}
		throw new InvalidAuthTokenException("" + authToken);
	}

	@Override
	public boolean deleteSpecificAdvertisement(int advertiseId, String authToken) {
		Optional<AdvertisesEntity> stock = advertisesRepository.findById(advertiseId);
		if (stock.isPresent()) {
			AdvertisesEntity entity = stock.get();
			advertisesRepository.delete(entity);
			return true;
		}
		throw new InvalidAdvertiseIdException("" + advertiseId);
	}

	@Override
	public List<Advertises> getAllAdvertisementsBySearch(String Advertises) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertises getAdvertisesById(int advertiseId, String authToken) {
		Optional<AdvertisesEntity> optEntity = advertisesRepository.findById(advertiseId);
		if (optEntity.isPresent()) {
			AdvertisesEntity entity = optEntity.get();
			return convertAdvertisesEntityToAdvertisesDTO(entity);
		}

		throw new InvalidAdvertiseIdException("" + advertiseId);

	}

	private AdvertisesEntity convertAdvertisesDTOToAdvertisesEntity(Advertises dto) {
		TypeMap<Advertises, AdvertisesEntity> typeMap = this.modelMapper.typeMap(Advertises.class,
				AdvertisesEntity.class);
		typeMap.addMappings(mapper -> {
			mapper.map(Advertises::getId, AdvertisesEntity::setId);
			mapper.map(Advertises::getTitle, AdvertisesEntity::setTitle);
			mapper.map(Advertises::getCategory, AdvertisesEntity::setCategory);
			mapper.map(Advertises::getPrice, AdvertisesEntity::setPrice);
			mapper.map(Advertises::getStatus, AdvertisesEntity::setStatus);
			mapper.map(Advertises::getDescription, AdvertisesEntity::setDescription);
			mapper.map(Advertises::getUsername, AdvertisesEntity::setUsername);
			mapper.map(Advertises::getCreatedDate, AdvertisesEntity::setCreatedDate);
			mapper.map(Advertises::getModifiedDate, AdvertisesEntity::setModifiedDate);

		});
		return this.modelMapper.map(dto, AdvertisesEntity.class);
	}

	private Advertises convertAdvertisesEntityToAdvertisesDTO(AdvertisesEntity entity) {
		TypeMap<AdvertisesEntity, Advertises> typeMap = this.modelMapper.typeMap(AdvertisesEntity.class,
				Advertises.class);
		typeMap.addMappings(mapper -> {
			mapper.map(AdvertisesEntity::getId, Advertises::setId);
			mapper.map(AdvertisesEntity::getTitle, Advertises::setTitle);
			mapper.map(AdvertisesEntity::getCategory, Advertises::setCategory);
			mapper.map(AdvertisesEntity::getPrice, Advertises::setPrice);
			mapper.map(AdvertisesEntity::getStatus, Advertises::setStatus);
			mapper.map(AdvertisesEntity::getDescription, Advertises::setDescription);
			mapper.map(AdvertisesEntity::getUsername, Advertises::setUsername);
			mapper.map(AdvertisesEntity::getCreatedDate, Advertises::setCreatedDate);
			mapper.map(AdvertisesEntity::getModifiedDate, Advertises::setModifiedDate);
		});
		return this.modelMapper.map(entity, Advertises.class);
	}

	@Override
	public List<Advertises> getAdvertisesBySearchFilterCriteria(String searchText, int categoryId, String postedBy,
			String dateCondition, LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy,
			int startIndex, int records) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AdvertisesEntity> criteriaQuery = criteriaBuilder.createQuery(AdvertisesEntity.class);
		Root<AdvertisesEntity> rootEntity = criteriaQuery.from(AdvertisesEntity.class);
		Predicate predicateSearchText = criteriaBuilder.and();
		Predicate predicateCategoryId = criteriaBuilder.and();
		Predicate predicateDateCondition = criteriaBuilder.and();
		Predicate predicateFinal = criteriaBuilder.and();
		Predicate predicateTitle = criteriaBuilder.and();	
		Predicate predicateDescription = criteriaBuilder.and();	
		Predicate predicatePostedBy = criteriaBuilder.and();	
		Predicate predicateEquals = criteriaBuilder.and();	
		Predicate predicateGreaterThan = criteriaBuilder.and();
		Predicate predicateLessThan = criteriaBuilder.and();	
		Predicate predicateBetween = criteriaBuilder.and();

		if (searchText != null && !"".equals(searchText)) {
			predicateTitle = criteriaBuilder.like(rootEntity.get("title"), "%" + searchText + "%");
			predicateDescription = criteriaBuilder.like(rootEntity.get("description"),
					"%" + searchText + "%");
			predicateSearchText = criteriaBuilder.or(predicateTitle, predicateDescription);
		}
		
      if(categoryId != 0) {
			predicateCategoryId = criteriaBuilder.equal(rootEntity.get("category"), categoryId);
		}
		
		if (postedBy != null && !"".equals(postedBy)) {
			predicatePostedBy = criteriaBuilder.equal(rootEntity.get("title"), postedBy);

		}
		if (dateCondition != null && !"".equalsIgnoreCase(dateCondition)) {
			if (dateCondition.equalsIgnoreCase("equals")) {
				predicateEquals = criteriaBuilder.equal(rootEntity.get("createdDate"), onDate);
				predicateDateCondition = criteriaBuilder.and(predicateEquals);
			}
			else if (dateCondition.equalsIgnoreCase("greaterThan")) {
				predicateGreaterThan = criteriaBuilder.greaterThan(rootEntity.get("createdDate"), fromDate);
			} 
			else if (dateCondition.equalsIgnoreCase("leassThan")) {
				predicateLessThan = criteriaBuilder.lessThan(rootEntity.get("createdDate"), fromDate);
			} 
			else if (dateCondition.equalsIgnoreCase("between")) {
				predicateBetween = criteriaBuilder.between(rootEntity.get("createDate"), fromDate, toDate);
			}

		}
		
		
		predicateFinal = criteriaBuilder.and(predicateSearchText, predicateDateCondition,
				predicateCategoryId,predicateTitle,predicateDescription,predicatePostedBy,predicateEquals,
				predicateLessThan,predicateGreaterThan,predicateBetween);
		criteriaQuery.where(predicateFinal);
		TypedQuery<AdvertisesEntity> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(startIndex);
		typedQuery.setMaxResults(records);
		AdvertisesEntity advertiseEntityList = (AdvertisesEntity) typedQuery.getResultList(); // database call
		return (List<Advertises>) convertAdvertisesEntityToAdvertisesDTO(advertiseEntityList); // private function
		//throw new InvalidAdvertiseIdException(sortedBy);
	}

}
