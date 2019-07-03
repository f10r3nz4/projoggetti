package com.progetto.ProjOggetti;

public abstract class Erasmus {
	private String consortium;
	private char mob_type;
	private char sh_duration;
	private int subject_area;
	private int total_credits;
	private int special_needs;
	private char prev_partecipation;
	private Study study;
	private Placement placement;
	private Language language;
	private Institute institute;

	public Erasmus(String consortium, char mob_type, char sh_duration, int subject_area, int total_credits,
			int special_needs, char prev_partecipation, Study study, Placement placement, Language language,
			Institute institute) {
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
		this.institute = institute;
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

	public char getPrev_partecipation() {
		return prev_partecipation;
	}

	public void setPrev_partecipation(char prev_partecipation) {
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
	
	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	public String getStudyStart() {
		return this.getStudy().getStart();
	}
	
	public float getStudyLength() {
		return this.getStudy().getLength();
	}
	
	public float getStudyGrant() {
		return this.getStudy().getGrant();
	}
	
	public int getStudyCredits() {
		return this.getStudy().getCredits();
	}
	
	public String getPlacementEnterprise() {
		return this.getPlacement().getEnterprise();
	}
	
	public String getPlacementCountry() {
		return this.getPlacement().getCountry();
	}
	
	public String getPlacementSector() {
		return this.getPlacement().getSector();
	}
	
	public String getPlacementStart() {
		return this.getPlacement().getStart();
	}
	
	public int getPlacementCredits() {
		return this.getPlacement().getCredits();
	}
	
	public int getPlacementGrant() {
		return this.getPlacement().getGrant();
	}
	
	public char getPlacementSize() {
		return this.getPlacement().getSize();
	}
	
	public float getPlacementLength() {
		return this.getPlacement().getLength();
	}
	
	public String getLanguageLanguage() {
		return this.getLanguage().getLanguage();
	}
	
	public String getLanguageLang_preparation() {
		return this.getLanguage().getLang_preparation();
	}
	
	public char getLanguageLang_taught() {
		return this.getLanguage().getLang_taught();
	}

	public String getInstituteHome_code() {
		return this.getInstitute().getHome_code();
	}
	
	public String getInstituteHome_country() {
		return this.getInstitute().getHome_country();	
	}
	
	public String getInstituteHost_code() {
		return this.getInstitute().getHost_code();
	}
	
	public String getInstituteHost_country() {
		return this.getInstitute().getHost_country();
	}
	
	@Override
	public String toString() {
		return "Erasmus [consortium=" + consortium + ", mob_type=" + mob_type + ", sh_duration=" + sh_duration
				+ ", subject_area=" + subject_area + ", total_credits=" + total_credits + ", special_needs="
				+ special_needs + ", prev_partecipation=" + prev_partecipation + ", study=" + study + ", placement="
				+ placement + ", language=" + language + ", institute=" + institute + "]";
	}
}
