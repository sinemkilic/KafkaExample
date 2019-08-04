# KafkaExample
File Reader and Save DB using Kafka

1. Komut sat�r�nda "zkServer.cmd" komutu ile zookeeper �al��t�r�l�r.

2. Zookeeper �al��t�r�ld�ktan sonra Kafka server'�n �al��t�r�lmas� i�in a�a��daki komut �al��t�r�l�r. 
	
	C:\dev\kafka_2.12-2.2.0\bin\windows>kafka-server-start.bat ..\..\config\server.properties

3. Komut sat�r�ndan producer'a giden mesajlar� dinlemek i�in a�a��daki komut kullan�labilir.

	C:\dev\kafka_2.12-2.2.0\bin\windows>kafka-console-consumer --bootstrap-server localhost:9092 --from-beginning --topic <topicName>

4. Kafka server �al��t�ktan sonra proje Run.java s�n�f�ndan �al��t�r�labilir. Projede �ncelikle random verilerle bir dosya yarat�l�r. Sonra kafka producer'a g�nderilen veriler consumer ile dinlenip database'e yazd�r�l�r.