package com.swamy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private Integer productId;
	private String productName;
	private Double productCost;
	private String productDescription;
}
