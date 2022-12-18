package com.gosmart.repository.entity;
/*
 * <h2>Property Entity</h2>
 * This is an Entity class maps to PROPERTY_ENTITY
 * @author Mallika
 * @Version 1.0
 * @Since 2022/12/17
 */

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "PROPERTY_ENTITY")

public class PropertyEntity {
	//primary key
	@Id
	@GeneratedValue
	@Column(name = "PROPERTY_ID")
	private Integer propertyId;
	//name of the product type
	@Column(name = "PROPERTY_TYPE")
	private String propertyType;
	//name of the cityId
	@Column(name = "CITY_ID")
	private Integer cityId;
	//name of the stateId
	@Column(name = "STATE_ID")
	private Integer stateId;
	//name of the tenantPreffered
	@Column(name = "TENANT_PREFFERD")
	private String tenantPreffered;
	//name of the availability
	@Column(name = "AVAILABILITY")
	private String availability;
	//name of the area
	@Column(name = "AREA")
	private String area;
	//name of the floor
	@Column(name = "FLOOR")
	private String floor;
	//name of the status
	@Column(name = "STATUS")
	private String status;
	//name of the createdOn
	@Column(name = "CREATED_ON")
	private Date createdOn;
	//name of the updatedOn
	@Column(name = "UPDATED_ON")
	private Date updatedOn;
	//name of the createdBy
	@Column(name = "CREATED_BY")
	private Integer createdBy;
	//name of the updatedBy
	@Column(name = "UPDATED_BY")
	private Integer updatedBy;
	
	
	
}
