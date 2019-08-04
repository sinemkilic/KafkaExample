# KafkaExample
File Reader and Save DB using Kafka

1. Komut satýrýnda "zkServer.cmd" komutu ile zookeeper çalýþtýrýlýr.

2. Zookeeper çalýþtýrýldýktan sonra Kafka server'ýn çalýþtýrýlmasý için aþaðýdaki komut çalýþtýrýlýr. 
	
	C:\dev\kafka_2.12-2.2.0\bin\windows>kafka-server-start.bat ..\..\config\server.properties

3. Komut satýrýndan producer'a giden mesajlarý dinlemek için aþaðýdaki komut kullanýlabilir.

	C:\dev\kafka_2.12-2.2.0\bin\windows>kafka-console-consumer --bootstrap-server localhost:9092 --from-beginning --topic <topicName>

4. Kafka server çalýþtýktan sonra proje Run.java sýnýfýndan çalýþtýrýlabilir. Projede öncelikle random verilerle bir dosya yaratýlýr. Sonra kafka producer'a gönderilen veriler consumer ile dinlenip database'e yazdýrýlýr.