package com.progetto.ProjOggetti;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
// import java.math.*;

public class Student extends Erasmus{
	private String ID;
	private String mobility_code;
	private String nationality;
	private String study_level;
	private int age;
	private int n_years;
	private char gender;

	public Student(String consortium, char mob_type, char sh_duration, int subject_area, int total_credits,
			int special_needs, char prev_partecipation, Study study, Placement placement, Language language,
			Institute institute, String iD, String mobility_code, String nationality, String study_level, int age,
			int n_years, char gender) {
		super(consortium, mob_type, sh_duration, subject_area, total_credits, special_needs, prev_partecipation, study,
				placement, language, institute);
		ID = iD;
		this.mobility_code = mobility_code;
		this.nationality = nationality;
		this.study_level = study_level;
		this.age = age;
		this.n_years = n_years;
		this.gender = gender;
	}

	public String getID() {
		return ID;
	}
	
	public String getMobility_code() {
		return mobility_code;
	}

	public void setMobility_code(String mobility_code) {
		this.mobility_code = mobility_code;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getStudy_level() {
		return study_level;
	}

	public void setStudy_level(String study_level) {
		this.study_level = study_level;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getN_years() {
		return n_years;
	}

	public void setN_years(int n_years) {
		this.n_years = n_years;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getConsortium() {
		return super.getConsortium();
	}

	public char getMob_type() {
		return super.getMob_type();
	}

	public char getSh_duration() {
		return super.getSh_duration();
	}

	public int getSubject_area() {
		return super.getSubject_area();
	}

	public int getTotal_credits() {
		return super.getTotal_credits();
	}

	public int getSpecial_needs() {
		return super.getSpecial_needs();
	}

	public char getPrev_partecipation() {
		return super.getPrev_partecipation();
	}
	
	public String getStudystart(){
		return super.getStudyStart();
	}
	
	public float getStudylength(){
		return super.getStudyLength();
	}
	
	public float getStudygrant(){
		return super.getStudyGrant();
	}
	
	public int getStudycredits(){
		return super.getStudyCredits();
	}
	
	public String getPlacemententerprise() {
		return super.getPlacementEnterprise();
	}
	
	public String getPlacementcountry() {
		return super.getPlacementCountry();
	}
	
	public String getPlacementsector() {
		return super.getPlacementSector();
	}
	
	public String getPlacementstart() {
		return super.getPlacementStart();
	}
	
	public int getPlacementcredits() {
		return super.getPlacementCredits();
	}
	
	public int getPlacementgrant() {
		return super.getPlacementGrant();
	}
	
	public char getPlacementsize() {
		return super.getPlacementSize();
	}
	
	public float getPlacementlength() {
		return super.getPlacementLength();
	}

	public String getLanguagelanguage() {
		return super.getLanguageLanguage();
	}
	
	public String getLang_preparation() {
		return super.getLanguageLang_preparation();
	}
	
	public char getLang_taught() {
		return super.getLanguageLang_taught();
	}
	
	public String getHome_code() {
		return super.getInstituteHome_code();
	}
	
	public String getHome_country() {
		return super.getInstituteHome_country();	
	}
	
	public String getHost_code() {
		return super.getInstituteHost_code();
	}
	
	public String getHost_country() {
		return super.getInstituteHost_country();
	}
	
	//effettuiamo un controllo sull'attributo String richiesto dall'utente in modo da proseguire con il conteggio
	
	//il metodo effettua il conteggio delle parole dell'attributo, viene richiamato dal main
	
	@SuppressWarnings("finally")
	public HashMap<String,Double> countString(List<Student> student, String request) {
		double j=0;
		HashMap<String,Double> done=new HashMap<>();
		try {
			for(Student item : student) {
				Method m=item.getClass().getMethod("get"+request.substring(0, 1).toUpperCase()+request.substring(1));
				String value=m.invoke(item).toString();
				j=0;
				for(Student students : student) {
					if(m.invoke(item).toString().equals(m.invoke(students).toString()))
						j++;
				}
				System.out.println(value+":"+j);
				String string=value.toString();
				done.put(string,j);		
			}
		}
		catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		finally {
			return done;
		}
	}
	
	//effettuiamo un controllo sull'attributo Char richiesto dall'utente in modo da proseguire con il conteggio
		
	//il metodo effettua il conteggio dei valori dell'attributo, viene richiamato dal main
	
	/*public void countChar(Student student[], String request) {
		int j;
		Vector<char> done= new Vector<char>();
		String value;
		boolean a=true;
		value=student[0].controlloChar(request);
		while(a){
			j=0;
			for(int i=0; i<student.length;i++) {
				if(student[i].controlloChar(request).equals(value))
					j++;
			}
			System.out.println(value+":"+j);
			done.add(value);
			a=false;
			int j=0;
			do {
				if(!done.contains(student[j].controlloChar(request)))
					a=true;
				else
					j++;
			}while(j<student.length & a==false);		
		}
	}*/
//Metodo per stringhe	
//Variante 1 di count(stampa tutti i valori conteggiati di tutti gli attributi)

	/* Variante 2 del count(prende tutti i valori di un attributo e poi li mette sul main per conteggiarne uno)
	public Vector<String> find (String request, Student[] student) {
		switch(request) {
			case "ID":
				Vector<String> results= new Vector<String>();
				for(int i=0;i<student.length;i++) {
					results.add(student[i].ID);
				}
				return results;
				break;
			case "nationality":
				Vector<String> results= new Vector<String>();
				for(int i=0;i<student.length;i++) {
					results.add(student[i].ID);
				}
				return results;
				break;
			case "age":
				Vector<String> results= new Vector<String>();
				for(int i=0;i<student.length;i++) {
					results.add(student[i].ID);
				}
				return results;
				break;
			case "n_years":break;
			case "gender":break;
			case "consortium":break;
			case "mob_type":break;
			case "sh_duration":break;
			case "subject_area":break;
			case "credits":break;
			case "special_needs":break;
			case "prev_partecipation":break;
			default: break;
		}
	}
	*/
	
	@SuppressWarnings("finally")
	public int countNum(List<Student> student,String request){
		int j=0;
		try {
			for(Student students : student) {
			
				Method m=students.getClass().getMethod("get"+request.substring(0, 1).toUpperCase()+request.substring(1));
				if(m.invoke(students).hashCode()!=0)
					j++;
			}
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		finally {
			return j;
		}
	}
	
	@SuppressWarnings("finally")
	public double sum(List<Student> student,String request) {
		int j=0;
		try {
			for(Student students: student) {			
				Method m=students.getClass().getMethod("get"+request.substring(0, 1).toUpperCase()+request.substring(1));
				Object a=m.invoke(students);
				j+=a.hashCode();
			}
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		finally {
			return j;
		}
	}
	
	@SuppressWarnings("finally")
	public double max(List<Student> student,String request) {
		double max=0;
		try {
			for(Student students: student) {	
				Method m=students.getClass().getMethod("get"+request.substring(0, 1).toUpperCase()+request.substring(1));
				max=m.invoke(students).hashCode();
				if(m.invoke(students).hashCode()>max)
					max=m.invoke(students).hashCode();
			}
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		finally {
			return max;
		}
	}
	
	@SuppressWarnings("finally")
	public double min(List<Student> student,String request) {
		double min=0;
		try {
			for(Student students: student) {	
				Method m=students.getClass().getMethod("get"+request.substring(0, 1).toUpperCase()+request.substring(1));
				min=m.invoke(students).hashCode();
				if(m.invoke(students).hashCode()<min)
					min=m.invoke(students).hashCode();
			}
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		finally {
			return min;
		}
	}
	
	public double avg(List<Student> student,String request) {
		double sum=this.sum(student,request);
		int count=this.countNum(student,request);
		return sum/count;
	}
	
	@SuppressWarnings("finally")
	public double dev_std(List<Student> student,String request) {
		double avg=this.avg(student,request);
		int count=this.countNum(student,request);
		double diff=0;
		try {
			for(Student students : student) {
				Method m=students.getClass().getMethod("get"+request.substring(0, 1).toUpperCase()+request.substring(1));
					diff+=Math.pow(m.invoke(students).hashCode()-avg,2);	
			}
		}catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		finally {
			if(diff!=0)
				return Math.sqrt(diff/count);
			else
				return diff;
		}
	}
}
