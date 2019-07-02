package progetto;

import java.util.Arrays;
import java.util.Vector;

public class Student extends Erasmus{
	private String ID;
	private String nationality;
	private String study_level;
	private int age;
	private int n_years;
	private char gender;

	public Student(String consortium, char mob_type, char sh_duration, int subject_area, int credits, int special_needs,
			boolean prev_partecipation, Study study, Placement placement, Language language, String iD,
			String nationality, String study_level, int age, int n_years, char gender) {
		super(consortium, mob_type, sh_duration, subject_area, credits, special_needs, prev_partecipation, study,
				placement, language);
		ID = iD;
		this.nationality = nationality;
		this.study_level = study_level;
		this.age = age;
		this.n_years = n_years;
		this.gender = gender;
	}

	public String getID() {
		return ID;
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
	
	public String ControlloString(String request){
		switch(request) {
		case "ID":
				return this.getID();
		case "nationality":
				return this.getNationality();
		case "study_level":
				return this.getStudy_level();
		case "consortium":
				return super.getConsortium();
		case "start_study":
				return super.getStudy().getStart();
		case "enterprise":
			return super.getPlacement().getEnterprise();
		case "country":
			return super.getPlacement().getCountry();
		case "sector":
			return super.getPlacement().getSector();
		case "start_placement":
			return super.getPlacement().getStart();
		case "language":
			return super.getLanguage().getLanguage();
		case "lang_preparation":
			return super.getLanguage().getLang_preparation();
		}
	}
	
	public void count2(Student student[], String request) {
		int j=0;
		Vector<String> done= new Vector<String>();
		String value;
		boolean a=true;
		value=student[0].ControlloString(request);
		while(a){
			for(int i=0; i<student.length;i++) {
				if(student[i].ControlloString(request).equals(value))
					j++;
			}
			System.out.println(value+":"+j);
			done.add(value);
			a=false;
			int k=0;
			do {
				if(!done.contains(student[k].ControlloString(request)))
					a=true;
				else
					k++;
			}while(k<student.length & a==false);		
		}
	}
	
	public char ControlloChar(String request){
		switch(request) {
		case "gender":
				return this.getGender();
		case "mob_type":
				return super.getMob_type();
		case "sh_duration":
				return super.getSh_duration();
		case "size":
			return super.getPlacement().getSize();
	}
	
	public void countChar(Student student[], String request) {
		int j=0;
		Vector<char> done= new Vector<char>();
		String value;
		boolean a=true;
		value=student[0].ControlloChar(request);
		while(a){
			for(int i=0; i<student.length;i++) {
				if(student[i].ControlloChar(request).equals(value))
					j++;
			}
			System.out.println(value+":"+j);
			done.add(value);
			a=false;
			int k=0;
			do {
				if(!done.contains(student[k].ControlloChar(request)))
					a=true;
				else
					k++;
			}while(k<student.length & a==false);		
		}
	}
//Metodo per stringhe	
//Variante 1 di count(stampa tutti i valori conteggiati di tutti gli attributi)
	public void countString(String request, Student[] student) {
		
		int j=0;
		Vector<String> done= new Vector<String>();
		String value;
		boolean a=true;
		char type;
		switch(request) {
			case "ID":
					value=student[0].ID;
					while(a){
						for(int i=0; i<student.length;i++) {
							if(student[i].ID.equals(value))
								j++;
						}
						System.out.println(value+":"+j);
						done.add(value);
						a=false;
						int k=0;
						do {
							if(!done.contains(student[k].ID))
								a=true;
							else
								k++;
						}while(k<student.length & a==false);		
					}
				break;
			case "nationality":
				value=student[0].nationality;
				while(a){
					for(int i=0; i<student.length;i++) {
						if(student[i].nationality.equals(value))
							j++;
					}
					System.out.println(value+":"+j);
					done.add(value);
					a=false;
					int k=0;
					do {
						if(!done.contains(student[k].ID))
							a=true;
						else
							k++;
					}while(k<student.length & a==false);		
				}
				break;
			case "study_level":
				value=student[0].study_level;
				while(a){
					for(int i=0; i<student.length;i++) {
						if(student[i].study_level.equals(value))
							j++;
					}
					System.out.println(value+":"+j);
					done.add(value);
					a=false;
					int k=0;
					do {
						if(!done.contains(student[k].ID))
							a=true;
						else
							k++;
					}while(k<student.length & a==false);		
				}
				break;
			case "gender":
				type='M';
				for(int i=0; i<student.length;i++) {
					if(student[i].gender==type)
						j++;
				}
				System.out.println("M:"+j);
				j=student.length-j;
				System.out.println("F:"+j);
				break;
			default: break;
//Da implementare?				
/*			case "nationality":11
				for(int i=0; i<student.length,i++) {
					if(student[i].nationality.equals(value))
						j++;
				}
				System.out.println("Nationality "+value+":"+j);
				break;
			case "study_level":
				for(int i=0; i<student.length,i++) {
					if(student[i].study_level.equals(value))
						j++;
				}
				System.out.println("Level of Study "+value+":"+j);
				break;
			case "consortium":
				for(int i=0; i<student.length,i++) {
					if(student[i].nationality.equals(value))
						j++;
				}
				System.out.println("Consortium agreement "+value+":"+j);
				break;
			case "mob_type":
				for(int i=0; i<student.length,i++) {
					if(student[i].nationality.equals(value))
						j++;
				}
				System.out.println("Nationality "+value+":"+j);
				break;
			case "sh_duration":
				for(int i=0; i<student.length,i++) {
					if(student[i].nationality.equals(value))
						j++;
				}
				System.out.println("Nationality "+value+":"+j);
				break;*/
		}
	}
	//Variante 2 del count(prende tutti i valori di un attributo e poi li mette sul main per conteggiarne uno)
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
	
	//metodi per i numeri
	public void countNum(){
		
	}
	
	public void sum(String res) {
	}
	
	public void max() {
		
	}
	
	public void min() {
		
	}
	
	public void avg() {
		
	}
	
	public void dev_std() {
		
	}
	
	
}
