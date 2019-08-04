package net.javaguides.maven_web_project.KafkaExample;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class LogConsumer {
	 public static void consumer() throws Exception {    
	      String topic = "LogFileTopic";
	      String group = "console-consumer-8106";
	      Properties props = new Properties();
	      props.put("bootstrap.servers", "localhost:9092");
	      props.put("group.id", group);
	      props.put("enable.auto.commit", "true");
          props.put("auto.commit.interval.ms", "1000");
	      props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	      props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		  props.put("auto.offset.reset","earliest");
	      KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

	      consumer.subscribe(Arrays.asList(topic));
	      System.out.println("Subscribed to topic " + topic);
	         
	      while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(100);
	            for (ConsumerRecord<String, String> record : records) {
	               System.out.printf("offset = %d, key = %s, value = %s\n", 
	               record.offset(), record.key(), record.value());
	               ParseAndSaveDB.parse(record.value());
	            }
	      }     
	}  
}