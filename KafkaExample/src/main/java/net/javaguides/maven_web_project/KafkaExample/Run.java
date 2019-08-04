package net.javaguides.maven_web_project.KafkaExample;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Run {
	public static void main( String[] args ) throws Exception
    {
		LogCreator.LogCreatorFunc();
		LogProducer.producer();
		LogConsumer.consumer();
    }
}
