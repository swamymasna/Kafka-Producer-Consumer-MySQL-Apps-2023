package com.swamy.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.swamy.dto.ProductDto;
import com.swamy.dto.ProductEvent;
import com.swamy.entity.Product;
import com.swamy.repository.ProductRepository;

@Service
public class KafkaProductClient {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaProductClient.class);

	@Autowired
	private ProductRepository productRepository;

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeProductEvent(ProductEvent productEvent) {

		LOG.info(String.format("Product Event Received Successfully : %s", productEvent));

		ProductDto productDto = productEvent.getProductDto();

		Product product = new Product();
		product.setStatus(productEvent.getStatus());

		BeanUtils.copyProperties(productDto, product);

		productRepository.save(product);

		LOG.info("Product Data Saved Successfully in Database...!");

	}
}
