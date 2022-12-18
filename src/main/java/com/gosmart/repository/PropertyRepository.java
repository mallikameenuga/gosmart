package com.gosmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gosmart.repository.entity.PropertyEntity;
@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Integer>{
	public List<PropertyEntity> findAllByPropertyType(Integer propertyType);

}
