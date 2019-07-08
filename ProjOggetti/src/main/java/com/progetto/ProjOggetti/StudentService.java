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
	
	
	@SuppressWarnings("finally")
	public  List<Student> getStudents(String param) {
		List<Student> check= new ArrayList<>();
		String[] attr=param.split("{|:{|: {|:[|: [|]}}:]}");
		if(param.isEmpty())
			return students;
		else {
			try {
				if(attr[0].charAt(0)=='$') {
					Method m=this.getClass().getMethod("filter"+attr[0]);
					for(Student student:students) {
						if((boolean)m.invoke(this,student,attr[1]))
							check.add(student);
					}
				}
				else {
				Method m=this.getClass().getMethod("filter"+attr[1]);
				for(Student student:students) {
					if((boolean)m.invoke(this,student,attr[0],attr[2]))
						check.add(student);
				}
			}
			return check;
			}catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				return check;
			}
		}
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
        return StudentService.getStudents(fieldName);
	} 
	
	@SuppressWarnings("finally")
	public HashMap<String,Double>retrieveStatistics(String param){
		HashMap<String,Double> statistics = new HashMap<>();
		try {
			List<Student> check= new ArrayList<>();
			String[] attr=param.split("{|:{|: {|:[|: [|]}}:]}");
			if(!param.isEmpty()) {
				if(attr[0].charAt(0)=='$') {
					Method m=this.getClass().getMethod("filter"+attr[0]);
					for(Student student:students) {
						if((boolean)m.invoke(this,student,attr[1]))
							check.add(student);
					}
				}
				else {
					Method m=this.getClass().getMethod("filter"+attr[1]);
					for(Student student:students) {
						if((boolean)m.invoke(this,student,attr[0],attr[2]))
							check.add(student);
					}
				}
			}else {
				check = students;
			}
			Method m = check.get(0).getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if(m.getReturnType().getName().equals("String")||m.getReturnType().getName().equals("char"))
				return check.get(0).countString(check,param);
			else{
				statistics.put("count",(double)students.get(0).countNum(check,param));
				statistics.put("avg", students.get(0).avg(check,param));
				statistics.put("min", students.get(0).min(check,param));
				statistics.put("max", students.get(0).max(check,param));
				statistics.put("std", students.get(0).dev_std(check,param));
				statistics.put("sum", students.get(0).sum(check,param));
			}
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
	
//Logical filters operators
	@SuppressWarnings("finally")
	public boolean filter$not(Student student, String param, String value) {
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if(m.invoke(student).toString()== value || (double)m.invoke(student)==Double.parseDouble(value))
				return false;
			else 
				return true;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return true;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$or(Student student, String param) {
		String[] or=param.split("{|:|: |}, {|}");
		try {
			Method m1=student.getClass().getMethod("get"+or[0].substring(0, 1).toUpperCase()+or[0].substring(1));
			Method m2=student.getClass().getMethod("get"+or[2].substring(0, 1).toUpperCase()+or[2].substring(1));
			if((m1.invoke(student).toString()== or[1] || (double)m1.invoke(student)==Double.parseDouble(or[1])) ||
					(m2.invoke(student).toString()== or[3] || (double)m2.invoke(student)==Double.parseDouble(or[3])))
				return true;
			else 
				return false;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return false;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$and(Student student, String param) {
		String[] and=param.split("{|:|: |}, {|}");
		try {
			Method m1=student.getClass().getMethod("get"+and[0].substring(0, 1).toUpperCase()+and[0].substring(1));
			Method m2=student.getClass().getMethod("get"+and[2].substring(0, 1).toUpperCase()+and[2].substring(1));
			if(and[0]!=and[2] &&(m1.invoke(student).toString()== and[1] || (double)m1.invoke(student)==Double.parseDouble(and[1])) &&
					(m2.invoke(student).toString()== and[3] || (double)m2.invoke(student)==Double.parseDouble(and[3])))
				return true;
			else 
				return false;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return false;
		}
	}
	
	//Conditional filter operators

	@SuppressWarnings("finally")
	public boolean filter$gt(Student student, String param, String value) {
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)>Double.parseDouble(value))
				return false;
			else 
				return true;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return true;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$lt(Student student, String param, String value) {
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)<Double.parseDouble(value))
				return false;
			else 
				return true;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return true;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$gte(Student student, String param, String value) {
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)>=Double.parseDouble(value))
				return false;
			else 
				return true;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return true;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$lte(Student student, String param, String value) {
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)<=Double.parseDouble(value))
				return false;
			else 
				return true;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return true;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$bt(Student student, String param, String value) {
		String[] val = value.split(",");
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)>=Double.parseDouble(val[0]) && (double)m.invoke(student)<=Double.parseDouble(val[1]))
				return false;
			else 
				return true;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return true;
		}
	}
}
