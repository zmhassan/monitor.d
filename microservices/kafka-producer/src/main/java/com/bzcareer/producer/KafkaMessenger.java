package com.bzcareer.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaMessenger {

	private static KafkaProducer<String, String> producer;
	private final Properties properties = new Properties();

	public KafkaMessenger(String servers) {
		properties.put("bootstrap.servers", servers);
		properties.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String,String>(properties);

	}
	
	
	public void send(String topic, String msg){
		ProducerRecord<String, String> data = new ProducerRecord<>(topic, msg);
        producer.send(data); 
	}
	
	public void close(){
        producer.close();
	}

}
