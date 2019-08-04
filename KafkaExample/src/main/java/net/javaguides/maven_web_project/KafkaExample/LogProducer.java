package net.javaguides.maven_web_project.KafkaExample;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogProducer
{
	public static void producer() throws FileNotFoundException, IOException {
		String topicName = "LogFileTopic"; 
		String fileName = System.getProperty("user.home") + "/Desktop/LogExample/logFile.txt";
        Properties configProperties = new Properties();
        
		configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");
		configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		
        KafkaProducer<String, String> producer = new KafkaProducer<>(configProperties);
    
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String line;
		    while ((line = br.readLine()) != null) {
				ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
				producer.send(rec);
			}
		 }
		producer.close();
	}	 
}
