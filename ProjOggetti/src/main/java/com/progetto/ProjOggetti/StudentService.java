package com.progetto.ProjOggetti;

import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import ch.qos.logback.core.property.ResourceExistsPropertyDefiner;

@Component
public class StudentService{
	
	private static List<Student> students = new ArrayList<>();
	private static List<Attribute> attributes = new ArrayList<>();
	
	public static List<Student> getStudents() {
		return students;
	}

	public static List<Attribute> getAttributes() {
		return attributes;
	}

	static {
		
		String fileToParse = "SM_2012_13_20141103_01.csv";
		BufferedReader fileReader = null;
		
		//Delimiter used in CSV file
		final String DELIMITER = ";";
		try
		{
	        String line = "";
	        //Create the file reader
	        fileReader = new BufferedReader(new FileReader(fileToParse));
	        line = fileReader.readLine();
	        Field[] fields = students.get(0).getClass().getDeclaredFields();
	        String[] attrs = line.split(DELIMITER);
	        int i=0;
	        for(String attr : attrs)
	        {	
	           Method m = students.get(0).getClass().getMethod("get"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1));
	           Attribute newattribute = new Attribute(fields[i].getName(),attr,m.getReturnType().toString());
	           attributes.add(newattribute);
	           i++;
	        }
	        
	        //Read the file line by line
	        
	        while ((line = fileReader.readLine()) != null)
	        {
	            //Get all tokens available in line
	            String[] tokens = line.split(DELIMITER);
	            Study newstudy = new Study(tokens[20],Float.parseFloat(tokens[17]),Float.parseFloat(tokens[29]), Integer.parseInt(tokens[23]));
	            Placement newplacement = new Placement (tokens[13],tokens[14],tokens[16],tokens[21],Integer.parseInt(tokens[24]),Integer.parseInt(tokens[31]),tokens[15].charAt(0),Float.parseFloat(tokens[18]));
	            Institute newinstitute = new Institute (tokens[2],tokens[3],tokens[11],tokens[12]);
	            Language newlanguage = new Language (tokens[28],tokens[29],tokens[27].charAt(0));
	    //      Erasmus newerasmus = new Erasmus(tokens[22],tokens[10].charAt(0),tokens[19].charAt(0),Integer.parseInt(tokens[7]),Integer.parseInt(tokens[25]),Integer.parseInt(tokens[26]),tokens[32].charAt(0),newstudy,newplacement,newlanguage,newinstitute);
	            Student newstudent = new Student(tokens[22],tokens[10].charAt(0),tokens[19].charAt(0),Integer.parseInt(tokens[7]),Integer.parseInt(tokens[25]),Integer.parseInt(tokens[26]),tokens[32].charAt(0),newstudy,newplacement,newlanguage,newinstitute,tokens[0],tokens[1],tokens[6], tokens[8], Integer.parseInt(tokens[4]), Integer.parseInt(tokens[9]), tokens[5].charAt(0));
	            students.add(newstudent);
	            
	            //for(String token : tokens)
	            //{
	             //   if(i==0)
	            	//Print all tokens
	           //     System.out.println(token);
	            //}
	            
	        }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Attribute> retrieveDataAttribute(){
        return StudentService.getAttributes();
	} 
	
	public List<Student> retrieveDataStudent(String fieldName){
        return StudentService.getStudents();
	} 
	
	@SuppressWarnings("finally")
	public HashMap<String,Double>retrieveStatistics(String param){
		HashMap<String,Double> statistics = new HashMap<>();
		try {
		Method m = students.get(0).getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
		if(m.getReturnType().getName().equals("String")||m.getReturnType().getName().equals("char"))
			return students.get(0).countString(students,param);
		else
			statistics.put("count",(double)students.get(0).countNum(students,param));
			statistics.put("avg", students.get(0).avg(students,param));
			statistics.put("min", students.get(0).min(students,param));
			statistics.put("max", students.get(0).max(students,param));
			statistics.put("std", students.get(0).dev_std(students,param));
			statistics.put("sum", students.get(0).sum(students,param));
		}catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return statistics;
		}
	}
}
