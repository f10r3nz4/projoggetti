package com.progetto.Classi;
/**
 * <p>Classe che descrive uno <b>Studente</b>
 * estende la classe <b>Erasmus</b> e tutti i suoi attributi</p>
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
	
	/**Costruttore delle classe composto da:
	 * 
	 * <p>-Parametri ereditati da Erasmus
	 * 
	 * @param consortium
	 * @param mob_type
	 * @param sh_duration
	 * @param subject_area
	 * @param total_credits
	 * @param special_needs
	 * @param prev_partecipation
	 * @param study
	 * @param placement
	 * @param language
	 * @param institute</p>
	 * 
	 * <p>-Parametri di Studente
	 * @param iD
	 * @param mobility_code
	 * @param nationality
	 * @param study_level
	 * @param age
	 * @param n_years
	 * @param gender</p>
	 * 
	 * Abbiamo poi implementato i vari get e set sia della classe che della superclasse.
	 */

	
	public Student(String consortium, char mob_type, char sh_duration, int subject_area, int total_credits,
			float special_needs, char prev_partecipation, Study study, Placement placement, Language language,
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

	public float getSpecial_needs() {
		return super.getSpecial_needs();
	}

	public char getPrev_partecipation() {
		return super.getPrev_partecipation();
	}
	
	public String getStudystart(){
		return super.getStudyStart();
	}
	
	public double getStudylength(){
		return super.getStudyLength();
	}
	
	public double getStudygrant(){
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
	
	public float getPlacementgrant() {
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
	
	/**
	 * I vari metodi con l'utilizzo di "<i>@SuppressWarnings("finally")</i>" attravero la quale si potranno richiedere vari filtri predefiniti.
	 * 
	 * Metodo <b><i>countString</i></b>
	 * <p>Conta tutti i valori di @param request di tipo stringa di ogni Student di 
	 * @param student suddividendoli per valore e restituendo una HashMap di essi
	 * 
	 * @param student
	 * @param request
	 * @return</p>
	 * 
	 * 
	 */
	
	//il metodo effettua il conteggio delle parole dell'attributo, viene richiamato dal main
	@SuppressWarnings("finally")
	public HashMap<String,Double> countString(List<Student> student, String request) {
		double j=0;
		HashMap<String,Double> done=new HashMap<>();
		try {
			for(Student student1 : student) {
				Method m=student1.getClass().getMethod("get"+request.substring(0, 1).toUpperCase()+request.substring(1));
				String value=m.invoke(student1).toString();
				if(!done.containsKey(value)) {
					j=0;
					for(Student student2 : student) {
						if(value.equals(m.invoke(student2).toString()))
							j++;
					}
				done.put(value,j);
				}
			}
			return done;
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
	
	
	/**
	 * Metodo <b><i>countNum</i></b>
	 * <p>Conta tutti i valori di @param requestdi tipo numerico di ogni Student di 
	 * @param student suddividendoli per valore e restituendo una HashMap di essi
	 * 
	 * @param student
	 * @param request
	 * @return</p>
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
	
	/**
	 * Metodo <b><i>sum</i></b>
	 * <p>Calcola la somma dei valori di @param request di ogni Student di @param student
	 * 
	 * @param student
	 * @param request
	 * @return</p>
	 */
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
	
	/**
	 * Metodo <b><i>max</i></b>
	 * <p>Trova il valore massimo di @param request di ogni Student di @param student
	 * 
	 * @param student
	 * @param request
	 * @return</p>
	 */
	@SuppressWarnings("finally")
	public double max(List<Student> student,String request) {
		double max=0;
		try {
			for(Student students: student) {	
				Method m=students.getClass().getMethod("get"+request.substring(0, 1).toUpperCase()+request.substring(1));
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
	
	
	/**
	 * Metodo <b><i>min</i></b>
	 * 
	 * <p>Trova il valore minimo di @param request di ogni Student di @param student
	 * 
	 * @param student
	 * @param request
	 * @return</p>
	 */
	@SuppressWarnings("finally")
	public double min(List<Student> student,String request) {
		double min=Double.MAX_VALUE;
		try {
			for(Student students: student) {	
				Method m=students.getClass().getMethod("get"+request.substring(0, 1).toUpperCase()+request.substring(1));
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
	
	/**
	 * Metodo <b><i>avg</i></b>
	 * 
	 * <p>Calcola la media dei valori di @param request di ogni Student di @param student
	 * 
	 * @param student
	 * @param request
	 * @return</p>
	 */
	public double avg(List<Student> student,String request) {
		double sum=this.sum(student,request);
		int count=this.countNum(student,request);
		return sum/count;
	}
	
	
	/**
	 * Metodo <b><i>dev_std</i></b>
	 * 
	 * <p>Calcola la deviazione standard dei valori di @param request di ogni Student 
	 * di @param student
	 * 
	 * @param student
	 * @param request
	 * @return</p>
	 */
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
