package com.swamy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {

	@Id
	@Column(name = "PROD_ID")
	private Integer productId;

	@Column(name = "PROD_NAME")
	private String productName;

	@Column(name = "PROD_COST")
	private Double productCost;

	@Column(name = "PROD_DESC")
	private String productDescription;
	
	@Column(name = "STATUS")
	private String status;
}
