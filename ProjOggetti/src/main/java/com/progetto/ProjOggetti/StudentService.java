package com.progetto.ProjOggetti;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import ch.qos.logback.core.property.ResourceExistsPropertyDefiner;

@Component
public class StudentService {
	
	private static List<Student> students = new ArrayList<>();
	private static List<Attribute> attribute = new ArrayList<>();
	static {
	}
	
	public List<Attribute> retrieveData(){
        Field[] fields = students.get(0).getClass().getDeclaredFields();
        Method m = students.get(0).getClass().getMethod("get"+fields[0].getName().substring(0, 1).toUpperCase()+fields[0].getName().substring(1));
        m.getReturnType().toString();
        return attribute;
	} 
}
