package com.olx.controll;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Advertises;
import com.olx.security.JwtUtil;
import com.olx.services.AdvertiseServices;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/olx-advertises")
@CrossOrigin(origins = "*")
public class AdvertiseControll {
	@Autowired
	private AdvertiseServices advertiseServices;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtil jwtUtil;

	// service 8//
	@PostMapping(value = "/advertise", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Advertises> postNewAdvertises(@RequestBody Advertises advertises, String authToken) {
		return new ResponseEntity<>(advertiseServices.postNewadvertise(advertises, authToken), HttpStatus.CREATED);
	}

	// service 9//
	@PutMapping(value = "/advertise/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Update a Advertise by its id", notes = "Update a specific advertise by Id")
	public ResponseEntity<Advertises> UpdatesExistingAdvertise(@RequestBody Advertises advertises, int advertiseId,
			String authToken) {
		return new ResponseEntity<>(advertiseServices.UpdatesExistingAdvertise(advertises, advertiseId, authToken),
				HttpStatus.OK);
	}

	// service 10//
	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Advertises>> readsAllAdvertisements(String authToken) {
		return new ResponseEntity<>(advertiseServices.readsAllAdvertisements(authToken), HttpStatus.OK);
	}
	// service 11//
	@GetMapping(value = "/user/advertise/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	// @ApiOperation(value="Read advertisement by AdvertismentId",notes = "Returns
	// advertisement by AdvertismentId to Client")
	public ResponseEntity<Advertises> getAdvertisementById(
			/* @ApiParam(value = "Advertisement Id",name="id",required=true) */ @PathVariable("id") int id,
			@RequestHeader("Authorization") String authtoken) {
		return new ResponseEntity<>(advertiseServices.getAdvertisementById(id, authtoken), HttpStatus.OK);
	}

	// service 12//
	@DeleteMapping(value = "/user/advertise/{advertiseId} ")
	@ApiOperation(value = "Delete advertise by a specific id", notes = "Delete a specific advertise by Id")
	public ResponseEntity<Boolean> deleteSpecificAdvertisement(
			@ApiParam(name = "advertiseId", required = true) @PathVariable("advertiseId") int advertiseId,
			String authToken) {
		return new ResponseEntity<>(advertiseServices.deleteSpecificAdvertisement(advertiseId, authToken),
				HttpStatus.OK);
	}
	// service 13//
	@GetMapping(value = "/search/filtercriteria", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Advertises>> searchAdvertisesByFilterCriteria(
			@RequestParam(name = "searchText", required = false) String searchText,
			@RequestParam(name = "category", required = false) int categoryId,
			@RequestParam(name = "postedBy", required = false) String postedBy,
			@RequestParam(name = "dateCondition", required = false) String dateCondition,
			@RequestParam(name = "onDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate onDate,
			@RequestParam(name = "fromDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
			@RequestParam(name = "toDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
			@RequestParam(name = "sortedBy", required = false) String sortedBy,
			@RequestParam(name = "startIndex", defaultValue = "0") int startIndex,
			@RequestParam(name = "records", defaultValue = "10") int records) {
		return new ResponseEntity<List<Advertises>>(advertiseServices.getAdvertisesBySearchFilterCriteria(searchText, categoryId, postedBy, dateCondition, onDate, fromDate, toDate, sortedBy, startIndex, records),HttpStatus.OK);
	}

	
	
	
	// service14//

	@GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	// @ApiOperation(value="Read all advertisements by search",notes = "Returns all
	// advertisements by search to Client")
	public ResponseEntity<List<Advertises>> getAllAdvertisementsBySearch(
			/* @ApiParam(value = "Request Params") */ @RequestParam(name = "searchText", required = false) String searchText) {
		return new ResponseEntity<>(advertiseServices.getAllAdvertisementsBySearch(searchText), HttpStatus.OK);

	}
	
	
	// service 15//
	@GetMapping(value = "/user/advertise/{advertiseId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Read advertise by id", notes = "Returns a advertise by its id")
	public ResponseEntity<Advertises> getAdvertisesById(
			@ApiParam(name = "advertiseId", required = true) @PathVariable("advertiseId") int advertiseId,
			@RequestHeader("Authorization") String authToken) {
		return new ResponseEntity<Advertises>(advertiseServices.getAdvertisesById(advertiseId, authToken),
				HttpStatus.OK);
	}
}
