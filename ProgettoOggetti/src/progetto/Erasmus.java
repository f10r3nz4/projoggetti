package progetto;

import java.util.Vector;

public abstract class Erasmus {
	private String consortium;
	private char mob_type;
	private char sh_duration;
	private int subject_area;
	private int total_credits;
	private int special_needs;
	private boolean prev_partecipation;
	private Study study;
	private Placement placement;
	private Language language;

	public Erasmus(String consortium, char mob_type, char sh_duration, int subject_area, int total_credits, int special_needs,
			boolean prev_partecipation, Study study, Placement placement, Language language) {
		super();
		this.consortium = consortium;
		this.mob_type = mob_type;
		this.sh_duration = sh_duration;
		this.subject_area = subject_area;
		this.total_credits = total_credits;
		this.special_needs = special_needs;
		this.prev_partecipation = prev_partecipation;
		this.study = study;
		this.placement = placement;
		this.language = language;
	}

	public String getConsortium() {
		return consortium;
	}

	public void setConsortium(String consortium) {
		this.consortium = consortium;
	}

	public char getMob_type() {
		return mob_type;
	}

	public void setMob_type(char mob_type) {
		this.mob_type = mob_type;
	}

	public char getSh_duration() {
		return sh_duration;
	}

	public void setSh_duration(char sh_duration) {
		this.sh_duration = sh_duration;
	}

	public int getSubject_area() {
		return subject_area;
	}

	public void setSubject_area(int subject_area) {
		this.subject_area = subject_area;
	}

	public int getTotal_credits() {
		return total_credits;
	}

	public void setTotal_credits(int total_credits) {
		this.total_credits = total_credits;
	}

	public int getSpecial_needs() {
		return special_needs;
	}

	public void setSpecial_needs(int special_needs) {
		this.special_needs = special_needs;
	}

	public boolean isPrev_partecipation() {
		return prev_partecipation;
	}

	public void setPrev_partecipation(boolean prev_partecipation) {
		this.prev_partecipation = prev_partecipation;
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public Placement getPlacement() {
		return placement;
	}

	public void setPlacement(Placement placement) {
		this.placement = placement;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public void countString(String request, Erasmus[] erasmus){
		int j=0;
		Vector<String> done= new Vector<String>();
		boolean a=true;
		char type;
		switch(request) {
			case "consortium":
				String value=erasmus[0].getConsortium();
				while(a){
					for(int i=0; i<erasmus.length;i++) {
						if(erasmus[i].getConsortium().equals(value))
							j++;
					}
					System.out.println(value+":"+j);
					done.add(value);
					a=false;
					int k=0;
					do {
						if(!done.contains(erasmus[k].getConsortium()))
							a=true;
						else
							k++;
					}while(k<erasmus.length & a==false);		
				}
				break;
			case "mob_type":
				type='S';
				for(int i=0; i<erasmus.length;i++) {
					if(erasmus[i].getMob_type()==type)
						j++;
				}
				System.out.println("S:"+j);
				j=erasmus.length-j;
				System.out.println("P:"+j);
				break;
			case "sh_duration":
				type='T';
				for(int i=0; i<erasmus.length;i++) {
					if(erasmus[i].getSh_duration()==type)
						j++;
				}
				System.out.println("T:"+j);
				int s=j;
				j=0;
				type='F';
				for(int i=0; i<sh_duration;i++) {
					if(erasmus[i].getSh_duration()==type)
						j++;
				}
				System.out.println("F:"+j);
				s+=j;
				j=erasmus.length-s;
				System.out.println("?:"+j);
				break;
				
		}
	}
	
	@Override
	public String toString() {
		return "Erasmus [consortium=" + consortium + ", mob_type=" + mob_type + ", sh_duration=" + sh_duration
				+ ", subject_area=" + subject_area + ", credits=" + credits + ", special_needs=" + special_needs
				+ ", prev_partecipation=" + prev_partecipation + ", study=" + study + ", placement=" + placement
				+ ", language=" + language + "]";
	}
	
	
}
