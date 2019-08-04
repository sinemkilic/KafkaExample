package net.javaguides.maven_web_project.KafkaExample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class LogCreator 
{
    public static void LogCreatorFunc()
    {
    	String fileName = System.getProperty("user.home") + "/Desktop/LogExample/"+"logFile.txt";
		int fileMaxSize = 2097152; //2 MB file
		
		String[] logLevels = { "INFO", "WARN","FATAL", "DEBUG", "ERROR" };
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Istanbul", "Hello-from-Istanbul");
		map.put("Tokyo", "Hello-from-Tokyo");
		map.put("Moskow", "Hello-from-Moskow");
		map.put("Beijing", "Hello-from-Beijing");
		map.put("London", "Hello-from-London");

		Object [] logData = map.keySet().toArray();
		
		File file = new File(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath())) 
        {
            while (file.length() < fileMaxSize) {
            	int randNum = new Random().nextInt(logLevels.length);
            	Object key = logData[new Random().nextInt(logData.length)];
            	String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Calendar.getInstance().getTime());
            	writer.write(timeStamp + "\t" + logLevels[randNum] + "\t" + key + "\t" + map.get(key) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}

