package com.gosmart.service;

import java.util.List;

import com.gosmart.repository.entity.PropertyEntity;

public interface PropertyService {
	public Integer insertProperty(PropertyEntity propertyEntity);
	public List<PropertyEntity> getProperties(Integer propertyType);
	public PropertyEntity getProperty(Integer propertyId);
	

}
