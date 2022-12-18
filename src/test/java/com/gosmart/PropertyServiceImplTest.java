package com.gosmart;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.PropertyRepository;
import com.gosmart.repository.entity.PropertyEntity;
import com.gosmart.service.impl.PropertyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)

public class PropertyServiceImplTest {
	@InjectMocks
	private PropertyServiceImpl service;
	@Mock
	private PropertyRepository repository;
	@Test
	public void testInsertProperty() throws Exception
	{
		PropertyEntity propertyEntity=new PropertyEntity();
		PropertyEntity propertyEntity2=Mockito.any();
		when(repository.save(propertyEntity)).thenReturn(propertyEntity2);
		Integer propertyId=service.insertProperty(propertyEntity2);
		assertNotNull(propertyId);
		
	
	}
	@Test(expected = GoSmartException.class)
	public void testInsertProperty_Exception() throws Exception
	{
		PropertyEntity propertyEntity=new PropertyEntity();
		when(repository.save(propertyEntity)).thenThrow(NullPointerException.class);
		service.insertProperty(propertyEntity);
		
	
	}
	@Test
	public void testGetProperties() throws Exception
	{
		Integer propertyId=1;
		List<PropertyEntity> property=new ArrayList<>();
		when(repository.findAllByPropertyType(propertyId)).thenReturn(property);
		List<PropertyEntity> property1=service.getProperties(propertyId);
		assertNotNull(property1);
		
		
	
	}
	@Test(expected = GoSmartException.class)
	public void testGetProperties_Exception() throws Exception
	{
		Integer propertyId=1;
		
		when(repository.findAllByPropertyType(propertyId)).thenThrow(NullPointerException.class);
		service.getProperties(propertyId);
	
	}
	
	
}
