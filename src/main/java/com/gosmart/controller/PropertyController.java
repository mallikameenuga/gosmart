package com.gosmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.constants.PropertyConstants;
import com.gosmart.repository.entity.PropertyEntity;
import com.gosmart.service.PropertyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class PropertyController {
	@Autowired
	private PropertyService propertyService;
	@PostMapping("/property/save/")
	public ResponseEntity<Integer> insertProperty(@RequestBody PropertyEntity propertyEntity)
	{
		try {
			log.info("{}-Controller Insert Method Started",PropertyConstants.PROPERTY);
			Integer propertyId=propertyService.insertProperty(propertyEntity);
			return new ResponseEntity<>(propertyId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/property/properties/")
	public ResponseEntity<List<PropertyEntity>> getProperties(@PathVariable Integer propertyType)
	{
		try {
			log.info("In propertyController... getProperties() Method Started");
			List<PropertyEntity> properties=propertyService.getProperties(propertyType);
			log.info("In propertyController... propertyDetails successfully Inserted");
			return new ResponseEntity<>(properties,HttpStatus.OK);
		} catch (Exception e)
		{
			log.error("In PropertyController getProperties() Method Error Message is:"+e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}




}
