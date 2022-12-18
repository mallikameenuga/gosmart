package com.gosmart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosmart.constants.PropertyConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.PropertyRepository;
import com.gosmart.repository.entity.PropertyEntity;
import com.gosmart.service.PropertyService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PropertyServiceImpl implements PropertyService{
	
	
	/**
	 * This method is used for the insertUser
	 * @param PropertyEntity This is the parameter to insertProperty()
	 * @return Integer This returns propertyId
	 * 
	 */
	@Autowired
	private PropertyRepository propertyRepository;
	@Override
	public Integer insertProperty(PropertyEntity propertyEntity) {
		
		Integer propertyId=0;
		log.info("{}-ServiceImpl insertproperty() started",PropertyConstants.PROPERTY);
		
		try 
		{
			log.info("{}-ServiceImpl insertProperty() saving propertyDetails in repository",PropertyConstants.PROPERTY);
			
			if(propertyEntity!=null)
			{
				PropertyEntity propertyEntity2=propertyRepository.save(propertyEntity);
				log.info("{}-ServiceImpl insertProperty() saved propertyDetails in repository",PropertyConstants.PROPERTY);
				if(propertyEntity2!=null)
				{
					propertyId=propertyEntity2.getPropertyId();
					log.info("{}-ServiceImpl insertProperty() propertyId is-{}",PropertyConstants.PROPERTY,propertyId);
				}
			}
			
		} 
		catch (Exception e) 
		{
			log.error ("{}-Serviceimpl insertProperty() exception occured-{}",PropertyConstants.PROPERTY,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return propertyId;
	}
	@Override
	public List<PropertyEntity> getProperties(Integer propertyType) {
		List<PropertyEntity> properties=null;
		try {
			properties=propertyRepository.findAllByPropertyType(propertyType);
		} catch (Exception e) {
			log.error ("{}-Serviceimpl insertProperty() exception occured-{}",PropertyConstants.PROPERTY,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return properties;
	}
	
	
}