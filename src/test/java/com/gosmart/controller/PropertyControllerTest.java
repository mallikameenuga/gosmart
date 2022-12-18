package com.gosmart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import com.gosmart.repository.entity.PropertyEntity;
import com.gosmart.service.PropertyService;



@RunWith(SpringJUnit4ClassRunner.class)

public class PropertyControllerTest {
	@InjectMocks
	private PropertyController propertyController;
	@Mock
	private PropertyService service;
	@Test
	public void testInsertProperty() throws Exception
	{
		PropertyEntity propertyEntity=new PropertyEntity();
		Integer propertyId=1;
		when(service.insertProperty(propertyEntity)).thenReturn(propertyId);
		ResponseEntity<Integer>response=propertyController.insertProperty(propertyEntity);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void testInsertProperty_Exception() throws Exception
	{
		PropertyEntity propertyEntity=new PropertyEntity();
		
		when(service.insertProperty(propertyEntity)).thenThrow(NullPointerException.class);
		ResponseEntity<Integer>response=propertyController.insertProperty(propertyEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	
	@Test
	public void testGetProperties() throws Exception
	{
		Integer propertyId=1;
		List<PropertyEntity> property=new ArrayList<>();
		when(service.getProperties(propertyId)).thenReturn(property);
		ResponseEntity<List<PropertyEntity>> responseEntity=propertyController.getProperties(propertyId);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	
	@Test
	public void testGetProperties_Exception() throws Exception
	{
		Integer PropertyId=1;
		when(service.getProperties(PropertyId)).thenThrow(NullPointerException.class);
		ResponseEntity<List<PropertyEntity>> responseEntity=propertyController.getProperties(PropertyId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}
	
	
	
}
