package com.swamy.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.swamy.dto.ProductEvent;

@Service
public class KafkaProductProducer {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaProductProducer.class);

	@Value("${kafka.topic.name}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, ProductEvent> kafkaTemplate;

	public String sendMessage(ProductEvent productEvent) {

		LOG.info("Entered into sendMessage() method");

		kafkaTemplate.send(topic, productEvent);

		LOG.info(String.format("Product Details Published Successfully : %s", productEvent));

		LOG.info("Returned Back From sendMessage() method");

		return "Product Details Published Successfully...!";
	}
}
