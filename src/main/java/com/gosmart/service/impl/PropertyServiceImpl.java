package com.gosmart.service.impl;

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
		log.info("{}-ServiceImpl insertUser() started",PropertyConstants.PROPERTY);
		
		try 
		{
			log.info("{}-ServiceImpl insertProperty() saving userDetails in repository",PropertyConstants.PROPERTY);
			
			if(propertyEntity!=null)
			{
				PropertyEntity propertyEntity2=propertyRepository.save(propertyEntity);
				log.info("{}-ServiceImpl insertUser() saved userDetails in repository",PropertyConstants.PROPERTY);
				if(propertyEntity2!=null)
				{
					propertyId=propertyEntity2.getPropertyId();
					log.info("{}-ServiceImpl insertUser() userId is-{}",PropertyConstants.PROPERTY,propertyId);
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
}