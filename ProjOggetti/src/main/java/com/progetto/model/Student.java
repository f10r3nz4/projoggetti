package com.progetto.model;
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
	private String id;
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
	 * @param consortium CONSORTIUM_AGREEMENT_NUMBER
	 * @param mob_type MOBILITY_TYPE
	 * @param sh_duration SHORT_DURATION_CDE
	 * @param subject_area STUDENT_SUBJECT_AREA
	 * @param total_credits TOTAL_ECTS_CREDITS_AMT
	 * @param special_needs SPECIAL_NEEDS_SUPPLEMENT_VALUE
	 * @param prev_partecipation PREVIOUS_PARTECIPATION CDE
	 * @param qualification QUALIFICATION_AT_HOST_CDE
	 * @param study Classe Study
	 * @param placement Classe Placement
	 * @param language Classe Language
	 * @param institute Classe Institute</p>
	 * 
	 * <p>-Parametri di Studente
	 * @param id STUDENT_ID
	 * @param mobility_code ID_MOBILITY_CDE
	 * @param nationality STUDENT_NATIONALITY_CDE
	 * @param study_level STUDENT_STUDY_LEVEL_CDE
	 * @param age STUDENT_AGE_VALUE
	 * @param n_years NUM_YRS_HIGER_EDUCAT_VALUE
	 * @param gender STUDENT_GENDER_CDE</p>
	 * 
	 * Abbiamo poi implementato i vari get e set sia della classe che della superclasse.
	 */

	
	public Student(String consortium, char mob_type, char sh_duration, int subject_area, int total_credits,
			float special_needs, char prev_partecipation, char qualification, Study study, Placement placement, Language language,
			Institute institute, String id, String mobility_code, String nationality, String study_level, int age,
			int n_years, char gender) {
		super(consortium, mob_type, sh_duration, subject_area, total_credits, special_needs, prev_partecipation, qualification, study,
				placement, language, institute);
		this.id = id;
		this.mobility_code = mobility_code;
		this.nationality = nationality;
		this.study_level = study_level;
		this.age = age;
		this.n_years = n_years;
		this.gender = gender;
	}	
	
	public String getId() {
		return id;
	}
	
	public String getMobility_code() {
		return mobility_code;
	}

	public String getNationality() {
		return nationality;
	}

	public String getStudy_level() {
		return study_level;
	}

	public int getAge() {
		return age;
	}

	public int getN_years() {
		return n_years;
	}

	public char getGender() {
		return gender;
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
	
	public char getQualification() {
		return super.getQualification();
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
	 * student suddividendoli per valore e restituendo una HashMap di essi
	 * 
	 * @param student ArrayList di studenti
	 * @param request Attributo da contare
	 * @return HashMap che hanno come nome i valori dell'attributo e come valore il
	 * conteggio delle volte che compaiono nel dataset</p>
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
	 * student suddividendoli per valore e restituendo una HashMap di essi
	 * 
	 * @param student ArrayList di studenti
	 * @param request Attributo da contare
	 * @return Conteggio dell'attributo</p>
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
	 * @param student ArrayList di studenti
	 * @param request Attributo con valori da sommare
	 * @return Somma dei valori dell'attributo</p>
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
	 * @param student ArrayList di studenti
	 * @param request Attributo da controllare
	 * @return Il valore massimo dell'elemento</p>
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
	 * @param student ArrayList di studenti
	 * @param request Attributo da controllare
	 * @return Il valore minimo dell'elemento</p>
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
	 * @param student ArrayList di studenti
	 * @param request Attributo da controllare
	 * @return La media dei valori dell'elemento</p>
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
	 * @param student ArrayList di studenti
	 * @param request Attributo da controllare
	 * @return La deviazione standard dei valori dell'elemento</p>
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
