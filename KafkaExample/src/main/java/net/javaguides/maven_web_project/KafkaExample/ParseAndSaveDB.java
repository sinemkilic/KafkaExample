package net.javaguides.maven_web_project.KafkaExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class ParseAndSaveDB {
  
	public static void parse(String record) {
		
		String[] recordArray = record.split("\t"); 
		recordArray[0] = recordArray[0].replaceAll("^\\s+","");
		
        String connectionUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=KafkaDB;user=master;password=123456;";

        try{
        	Connection con = DriverManager.getConnection(connectionUrl);
        	PreparedStatement stmt = con.prepareStatement("insert into KAFKALOGS (timeStamp, logLevel, logCity, logDetail) values (?,?,?,?");
        	stmt.setString(1, recordArray[0]);
        	stmt.setString(2, recordArray[1]);
        	stmt.setString(2, recordArray[2]);
        	stmt.setString(2, recordArray[3]);
        	stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }			
	}
}
