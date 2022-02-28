package com.olx.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.olx.dto.AuthenticationRequest;
import com.olx.dto.RegisterUser;
import com.olx.entity.BlackListedTokens;
import com.olx.entity.RegisterUserEntity;
import com.olx.exception.InvalidAuthTokenException;
import com.olx.exception.InvalidUserIdException;
import com.olx.repo.RegisterUserRepository;
import com.olx.repo.UserLogoutMongoRepo;
import com.olx.security.JwtUtil;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	RegisterUserRepository registerUserRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	UserLogoutMongoRepo userLogoutMongoRepo;

	@Override
	public RegisterUser registerUser(RegisterUser registerUser) {
		RegisterUserEntity entity=convertStockDTOToStockEntity(registerUser);
		registerUserRepository.save(entity);
		return registerUser;
	
	}

	@Override
	public ResponseEntity<String> authrntication(AuthenticationRequest authenticationRequest)throws UsernameNotFoundException {
		
		throw new InvalidUserIdException("" + authenticationRequest);
	}

	@Override
	public boolean userLogout(String authToken) {
		String  token = authToken.substring(7);
		Date extractExpiration = jwtUtil.extractExpiration(token) ;
		BlackListedTokens blackListedTokens = new BlackListedTokens(1,token,LocalDateTime.now(),LocalDateTime.now());
		if(extractExpiration.after(extractExpiration)) {
			userLogoutMongoRepo.save(blackListedTokens);
			return true;
		}
		
		throw new InvalidAuthTokenException("" + authToken);
		
	}

	@Override
	public List<RegisterUser> userInfo() {
		List<RegisterUserEntity> entityList = registerUserRepository.findAll();
		List<RegisterUser> userList = new ArrayList<>();
		for (RegisterUserEntity entity : entityList) {
			RegisterUser user = convertStockEntityToStockDTO(entity);
			userList.add(user);
		}
		return userList;
	}

	@Override
	public boolean validation(String authToken) {
		
		throw new InvalidAuthTokenException("" + authToken);
	}
	private RegisterUserEntity convertStockDTOToStockEntity(RegisterUser dto) {
		TypeMap<RegisterUser, RegisterUserEntity> typeMap = this.modelMapper.typeMap(RegisterUser.class, RegisterUserEntity.class);
		typeMap.addMappings(mapper -> {
			mapper.map(RegisterUser::getId, RegisterUserEntity::setId);
			mapper.map(RegisterUser::getFirstName, RegisterUserEntity::setFirstName);
			mapper.map(RegisterUser::getLastName, RegisterUserEntity::setLastName);
			mapper.map(RegisterUser::getUserName, RegisterUserEntity::setUserName);
			mapper.map(RegisterUser::getPassword, RegisterUserEntity::setPassword);
			mapper.map(RegisterUser::getEmail, RegisterUserEntity::setEmail);
			mapper.map(RegisterUser::getPhone, RegisterUserEntity::setPhone);
		});
		return this.modelMapper.map(dto, RegisterUserEntity.class);
	}

	private RegisterUser convertStockEntityToStockDTO(RegisterUserEntity entity) {
		TypeMap<RegisterUserEntity, RegisterUser> typeMap = this.modelMapper.typeMap(RegisterUserEntity.class, RegisterUser.class);
		typeMap.addMappings(mapper -> {
			mapper.map(RegisterUserEntity::getId, RegisterUser::setId);
			mapper.map(RegisterUserEntity::getFirstName, RegisterUser::setFirstName);
			mapper.map(RegisterUserEntity::getLastName, RegisterUser::setLastName);
			mapper.map(RegisterUserEntity::getUserName, RegisterUser::setUserName);
			mapper.map(RegisterUserEntity::getPassword, RegisterUser::setPassword);
			mapper.map(RegisterUserEntity::getEmail, RegisterUser::setEmail);
			mapper.map(RegisterUserEntity::getPhone, RegisterUser::setPhone);
		});
		return this.modelMapper.map(entity, RegisterUser.class);
	}

	@Override
		public RegisterUser getUserById(int userId) {
			Optional<RegisterUserEntity> optEntity = registerUserRepository.findById(userId);
			if (optEntity.isPresent()) {
				RegisterUserEntity entity = optEntity.get();
				return convertStockEntityToStockDTO(entity);
			}
			throw new InvalidUserIdException("" + userId);
		
	}

	}


