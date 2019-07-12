package com.progetto.service;
import com.progetto.model.Attribute;
import com.progetto.model.Institute;
import com.progetto.model.Language;
import com.progetto.model.Placement;
import com.progetto.model.Student;
import com.progetto.model.Study;

/*import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;*/
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;*/
import java.lang.reflect.*;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;*/
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ch.qos.logback.core.property.ResourceExistsPropertyDefiner;

@Component
public class StudentService{
	
	private static List<Student> students = new ArrayList<>();
	private static List<Attribute> attributes = new ArrayList<>();
	
//Stampa tutti i dati e permette di applicare filtri
	public List<Student> getStudents(String param) {
		if(param.isEmpty())
			return students;
		else {
			return doFilter(students,param,"");
		}
	}
//Parsing del file scaricato
	static {
	//Prendo il file dove effettuare il parsing e inizializzo un BufferedReader
		String fileToParse = "C:\\Users\\user\\git\\projoggetti\\ProjOggetti\\src\\main\\java\\com\\progetto\\controller\\dati-erasmus.csv";
		
	//Definisco l'elemento separatore
		final String DELIMITER = ";";
		try
		{
		//Creo il FileReader
			String line = "";
			String attrb = "";
			BufferedReader fileReader = new BufferedReader(new FileReader(fileToParse));
	        attrb = fileReader.readLine();
	        String[] attrs = attrb.split(DELIMITER);
	    //Leggo il file riga per riga e separo gli elementi
	        for (int i=0; i<500; i++)
	        {
	        	line = fileReader.readLine();
	        //Prendo tutti gli elementi separati da virgola e li inserisco in array di stringhe
	            String[] tokens = line.split(DELIMITER);
	        //Inserisco i valori in nuovi oggetti delle classi modellate
	            //tokens[17] tokens[30]
	            Study newstudy = new Study(tokens[20],Double.parseDouble("73.98"),Double.parseDouble("56.78"), Integer.parseInt(tokens[23]));
	           //(tokens[31])
	            Placement newplacement = new Placement (tokens[13],tokens[14],tokens[16],tokens[21],Integer.parseInt(tokens[24]),Float.parseFloat("3434.56"),tokens[15].charAt(0),Float.parseFloat(tokens[18]));
	            Institute newinstitute = new Institute (tokens[2],tokens[3],tokens[11],tokens[12]);
	            Language newlanguage = new Language (tokens[28],tokens[29],tokens[27].charAt(0));
	            Student newstudent = new Student(tokens[22],tokens[10].charAt(0),tokens[19].charAt(0),Integer.parseInt(tokens[7]),Integer.parseInt(tokens[25]),Float.parseFloat(tokens[26]),tokens[32].charAt(0),newstudy,newplacement,newlanguage,newinstitute,
	            					tokens[0],tokens[1],tokens[6], tokens[8], Integer.parseInt(tokens[4]), Integer.parseInt(tokens[9]), tokens[5].charAt(0));
	            students.add(newstudent);
	        }
	        Field[] fields = students.get(1).getClass().getFields();
	        int i=0;
	        
		    //Prendo l'intestazione di ogni colonna con un foreach e le salvo in un array
		      /* for(String attr : attrs)
		        {	
		    	   Method m = students.get(1).getClass().getMethod("get"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1));
		           Attribute newattribute = new Attribute(fields[i].getName(),attr,m.getReturnType().toString());		           		           
		           attributes.add(newattribute);
		           i++;
		        }*/
	        fileReader.close();
		}
	//Gestisco le eccezioni
		catch (NullPointerException  | SecurityException | IOException e) {
			e.printStackTrace();
		}
		/*catch (NoSuchMethodException e) {
			e.printStackTrace();
		}*/
	}
//Restituisce le intestazioni delle colonne
	public List<Attribute> retrieveDataAttribute(){
        return StudentService.attributes;
	} 
//Restituisce i dati degli studenti con eventuali filtri
	public List<Student> retrieveDataStudent(String fieldName){
        return this.getStudents(fieldName);
	} 
//Restituisce le statistiche di un attriburo passatogli per parametro
	@SuppressWarnings("finally")
	public HashMap<String,Double>retrieveStatistics(String param,String filter){
		HashMap<String,Double> statistics = new HashMap<>();
		List<Student> check= new ArrayList<>();
		//Controlla se gli è stato passato un parametro,se è vuoto utilizza students altrimenti applica un filtro adatto
			if(filter.isEmpty()) {
				check = students;
			}else {
				check = doFilter(check,param,filter);
			}
	//Gestisco le eccezioni di Method
		try{
		//Cerco la variabile passata come parametro e ne controllo il tipo
			Method m = students.get(0).getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if(m.getReturnType().equals(String.class)||m.getReturnType().equals(char.class))
				statistics = students.get(0).countString(check,param);
		//Nel caso di stringa manda l'unico metodo associatovi, se è un tipo numerico chiama i metodi per le statistiche previste
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
	//Dovendo restituire un HashMap, se vuota restituisce comunque generando un errore
		finally {
			return statistics;
		}
	}
//Gestisco i filtri prendendo 
	@SuppressWarnings("finally")
	public List<Student> doFilter(List<Student> students, String param,String filter) {
		List<Student> check= new ArrayList<>();
		String attr1;
		String attr2; 
		JSONObject a;
		try {
			if(filter.isEmpty())
			//Prendo le informazioni sul filtro da applicare dalla barra di ricerca
				a = (JSONObject) JSONValue.parseWithException(param);
			else 
				a = (JSONObject) JSONValue.parseWithException(filter);
			attr1=a.keySet().toString().substring(1,a.keySet().toString().length()-1);
		//Avvio un controllo sul nome del filtro
			if(attr1.charAt(0)=='$') {
				Method m=this.getClass().getMethod("filter"+attr1);
			//
				for(Student student:students) {
					if((boolean)m.invoke(this,student,a.get(attr1).toString()))
						check.add(student);
				}
			}
			else {
				JSONObject b = (JSONObject) (a.get(attr1));
				attr2=b.keySet().toString().substring(1,b.keySet().toString().length()-1);
				Method m=this.getClass().getMethod("filter"+attr2,Student.class,String.class,String.class);		
				for(Student student:students) {
					if((boolean)m.invoke(this,student,attr1,b.get(attr2).toString()))
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
//Logical filters operators
	@SuppressWarnings("finally")
	public boolean filter$not(Student student, String param, String value) {
		boolean a=true;
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if(m.invoke(student).toString().equals(value) || (double)m.invoke(student)==Double.parseDouble(value))
				a=false;
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$or(Student student, String param, String value) {
		String[] or=param.split(":|,");
		boolean a=false;
		try {
			Method m1=student.getClass().getMethod("get"+or[0].substring(0, 1).toUpperCase()+or[0].substring(1));
			Method m2=student.getClass().getMethod("get"+or[2].substring(0, 1).toUpperCase()+or[2].substring(1));
			if((m1.invoke(student).toString()== or[1] || (double)m1.invoke(student)==Double.parseDouble(or[1])) ||
					(m2.invoke(student).toString()== or[3] || (double)m2.invoke(student)==Double.parseDouble(or[3])))
				a = true;
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$and(Student student, String param, String value) {
		String[] and=param.split("{|:|: |}, {|}");
		boolean a=false;
		try {
			Method m1=student.getClass().getMethod("get"+and[0].substring(0, 1).toUpperCase()+and[0].substring(1));
			Method m2=student.getClass().getMethod("get"+and[2].substring(0, 1).toUpperCase()+and[2].substring(1));
			if(and[0]!=and[2] &&(m1.invoke(student).toString()== and[1] || (double)m1.invoke(student)==Double.parseDouble(and[1])) &&
					(m2.invoke(student).toString()== and[3] || (double)m2.invoke(student)==Double.parseDouble(and[3])))
				a = true; 
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$in(Student student, String param, String value) {
		String[] ins=value.substring(1,value.length()-1).split(",");
		boolean a=false;
		try {
			Method m1=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			for(String in:ins) {
				if(m1.invoke(student).toString().equals(in) || (double)m1.invoke(student)==Double.parseDouble(in))
					a = true;
			}
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$nin(Student student, String param, String value) {
		String[] ins=value.substring(1,value.length()-1).split(",");
		boolean a=true;
		try {
			Method m1=student.getClass().getMethod("get"+ins[0].substring(0, 1).toUpperCase()+ins[0].substring(1));
			for(String in:ins)
				if(m1.invoke(student).toString().equals(in) || (double)m1.invoke(student)==Double.parseDouble(in))
					a = false;
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
	
	//Conditional filter operators

	@SuppressWarnings("finally")
	public boolean filter$gt(Student student, String param, String value) {
		boolean a=false;
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)>Double.parseDouble(value))
				a = true;
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$lt(Student student, String param, String value) {
		boolean a=false;
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)<Double.parseDouble(value))
				a = true;
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$gte(Student student, String param, String value) {
		boolean a=false;
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)>=Double.parseDouble(value))
				a = true;
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$lte(Student student, String param, String value) {
		boolean a=false;
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)<=Double.parseDouble(value))
				a = true;
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean filter$bt(Student student, String param, String value) {
		String[] val =value.substring(1,value.length()-1).split(",");
		boolean a=false;
		try {
			Method m=student.getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
			if((double)m.invoke(student)>=Double.parseDouble(val[0]) && (double)m.invoke(student)<=Double.parseDouble(val[1]))
				a = true;
			return a;
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return a;
		}
	}
}
