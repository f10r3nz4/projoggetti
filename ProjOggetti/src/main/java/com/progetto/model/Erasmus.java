package com.progetto.model;

/** <p>Classe astratta che racchiude gli attributi specifici di un'esperienza Erasmus, fra i parametri
 * si hanno anche degli oggetti di classi più "<i>piccole</i>"</p>*/

public abstract class Erasmus {
	private String consortium;
	private char mob_type;
	private char sh_duration;
	private int subject_area;
	private int total_credits;
	private float special_needs;
	private char prev_partecipation;
	private char qualification;
	private Study study;
	private Placement placement;
	private Language language;
	private Institute institute;
	 
	
	/**
	 * Chiamiamo il <b>costruttore</b> con super(), in quanto Erasmus andrà poi ad estendere la macro-classe Student.
	 * Oltre al costruttore ed un toString di controllo finale, implementiamo il get ed i set con particolare attenzione
	 * ai singoli valori generalizzati nel data-set.
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
	 * @param institute Classe Institute
	 */
	public Erasmus(String consortium, char mob_type, char sh_duration, int subject_area, int total_credits,
			float special_needs, char prev_partecipation, char qualification, Study study, Placement placement,
			Language language, Institute institute) {
		super();
		this.consortium = consortium;
		this.mob_type = mob_type;
		this.sh_duration = sh_duration;
		this.subject_area = subject_area;
		this.total_credits = total_credits;
		this.special_needs = special_needs;
		this.prev_partecipation = prev_partecipation;
		this.qualification = qualification;
		this.study = study;
		this.placement = placement;
		this.language = language;
		this.institute = institute;
	}

	public String getConsortium() {
		return consortium;
	}

	public char getMob_type() {
		return mob_type;
	}

	public char getSh_duration() {
		return sh_duration;
	}

	public int getSubject_area() {
		return subject_area;
	}

	public int getTotal_credits() {
		return total_credits;
	}

	public float getSpecial_needs() {
		return special_needs;
	}

	public char getPrev_partecipation() {
		return prev_partecipation;
	}

	public char getQualification() {
		return qualification;
	}

	public Study getStudy() {
		return study;
	}

	public Placement getPlacement() {
		return placement;
	}

	public Language getLanguage() {
		return language;
	}
	
	public Institute getInstitute() {
		return institute;
	}
	
	public String getStudyStart() {
		return this.getStudy().getStart();
	}
	
	public double getStudyLength() {
		return this.getStudy().getLength();
	}
	
	public double getStudyGrant() {
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
	
	public float getPlacementGrant() {
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
}
