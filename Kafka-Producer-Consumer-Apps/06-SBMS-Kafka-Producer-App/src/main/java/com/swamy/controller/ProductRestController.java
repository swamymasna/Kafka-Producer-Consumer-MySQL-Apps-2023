package com.swamy.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.dto.ProductDto;
import com.swamy.dto.ProductEvent;
import com.swamy.producer.KafkaProductProducer;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

	@Autowired
	private KafkaProductProducer kafkaProductProducer;

	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) {

		productDto.setProductId(new Random().nextInt(1000));

		ProductEvent productEvent = new ProductEvent();
		productEvent.setProductDto(productDto);
		productEvent.setStatus("SUCCESS");

		return new ResponseEntity<>(kafkaProductProducer.sendMessage(productEvent), HttpStatus.CREATED);
	}
}
