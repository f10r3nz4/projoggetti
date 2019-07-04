package com.progetto.ProjOggetti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Parsing2 {
	public void Function (String[] attr,List<Student> students) {
		//Input file which needs to be parsed
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
	        attr = line.split(DELIMITER);
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
}
