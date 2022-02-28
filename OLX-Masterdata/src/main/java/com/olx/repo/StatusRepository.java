package com.olx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olx.entity.StatusEntity;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity,Integer> {

}
