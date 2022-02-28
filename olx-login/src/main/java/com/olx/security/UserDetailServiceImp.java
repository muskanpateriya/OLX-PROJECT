package com.olx.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.olx.entity.RegisterUserEntity;

import com.olx.repo.RegisterUserRepository;


@Service

public class UserDetailServiceImp implements UserDetailsService {

	@Autowired
	RegisterUserRepository RegisterUserReposiotory;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
	 List<RegisterUserEntity> userEntities=RegisterUserReposiotory.findByuserName(username);
		if(userEntities==null||userEntities.size()==0) {
			throw new UsernameNotFoundException(username);
		}
		RegisterUserEntity userEntity=userEntities.get(0);
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
//		String roles=userEntity.getUserName();
//		
//		String roleArray[]=roles.split(",");
//		for(int i=0;i<roleArray.length;i++) {
//			authorities.add(new SimpleGrantedAuthority(roleArray[i]));
//		}
		UserDetails userDetails=new User(username,passwordEncoder.encode(userEntity.getPassword()),authorities);
		return userDetails;
		}
}