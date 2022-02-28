package com.olx.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.olx.entity.BlackListedTokens;

public interface UserLogoutMongoRepo extends MongoRepository<BlackListedTokens, String> {

}
