package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Categories;
import com.olx.dto.Status;
import com.olx.services.MasterdataServices;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/masterdata")
@CrossOrigin(origins = "*")
public class MasterdataController {
	@Autowired
	private MasterdataServices masterdataServices;
	@GetMapping(value = "/categories", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Read All categories", notes = "Returns all categories")
	public ResponseEntity<List<Categories>> getAllCategories() {
		return new ResponseEntity<>(masterdataServices.getAllCategories(), HttpStatus.OK);
	}
	@GetMapping(value = "/status", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Status>> getAllStatus() {
		return new ResponseEntity<>(masterdataServices.getAllStatus(), HttpStatus.OK);
	}
	@PostMapping(value = "/categories/craete", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Categories> create(@RequestBody Categories categories){
		return new ResponseEntity<>(masterdataServices.create(categories), HttpStatus.CREATED);
	}
	@PutMapping(value = "/status/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value="Update a Status by its id", notes = "Craete a specific status by Id")
	public ResponseEntity<Status> updateStock(@RequestBody Status status,@ApiParam(name = "id", required = true) @PathVariable("id") int statusId) {
		return new ResponseEntity<>(masterdataServices.updateStatus(status, statusId), HttpStatus.OK);
	}
}
