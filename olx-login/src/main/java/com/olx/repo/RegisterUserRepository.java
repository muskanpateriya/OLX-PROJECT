package com.olx.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olx.entity.RegisterUserEntity;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUserEntity,Integer> {
	List<RegisterUserEntity>findByuserName(String username);

}
