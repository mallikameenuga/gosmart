package com.gosmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			log.info("Property Insert Method Started");
			Integer propertyId=propertyService.insertProperty(propertyEntity);
			return new ResponseEntity(propertyId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
