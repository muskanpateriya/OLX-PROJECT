package com.olx.actuator;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.info.Info.Builder;

import com.github.andrewoma.dexx.collection.HashMap;
import com.github.andrewoma.dexx.collection.Map;
import com.olx.entity.RegisterUserEntity;
import com.olx.repo.RegisterUserRepository;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;




@Component
@Endpoint(id = "users")
public class OlxLoginCustomActuatorEndPoint extends AbstractHealthIndicator {

	@Autowired
	private RegisterUserRepository registerUserRepository;

	@ReadOperation
	public List<RegisterUserEntity> getAllUsers() {
		return registerUserRepository.findAll();
	}
	
	public void cotribute(Builder builder) {
		Map<String, String> userDetails = new HashMap();
		userDetails.put("vendorName", "zensar");
		userDetails.put("ApplictioName", "OLX-Login");
		userDetails.put("version", "2.4");
		userDetails.put("releaseDate", LocalDate.now().toString());
		builder.withDetail("info", userDetails);
	}
	

	@Override
	protected void doHealthCheck(org.springframework.boot.actuate.health.Health.Builder builder) throws Exception {
		Random random = new Random();
		int randomNo  = random.nextInt(100);
		if(randomNo%2==0)
			builder.up();
		else
			builder.down();
		
	}

}
