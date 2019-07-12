package com.progetto.model;

/**
 * <p>Nella classe pubblica <b>Placement</b> sono presenti diversi parametri.
 * Si implementa il costruttore con super(), i get ed i set.</p>
 */

public class Placement {
	private String enterprise;
	private String country;
	private String sector;
	private String start;
	private int credits;
	private float grant;
	private char size;
	private float length;
	
	public Placement(String enterprise, String country, String sector, String start, int credits, float grant, char size,
			float length) {
		super();
		this.enterprise = enterprise;
		this.country = country;
		this.sector = sector;
		this.start = start;
		this.credits = credits;
		this.grant = grant;
		this.size = size;
		this.length = length;
		
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public float getGrant() {
		return grant;
	}

	public void setGrant(float grant) {
		this.grant = grant;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

}
