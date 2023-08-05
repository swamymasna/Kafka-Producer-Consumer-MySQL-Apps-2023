package com.swamy.dto;

import lombok.Data;

@Data
public class ProductEvent {

	private ProductDto productDto;
	private String status;
}
