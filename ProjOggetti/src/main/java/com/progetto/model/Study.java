package com.progetto.model;

/**
 * <p>La classe pubblica <b>Study</b> viene usata analogamente a <b>Placement</b>,
 * vengono passati dei parametri e si definiscono costruttore e getter e setters.</p>
 */

public class Study {
	private String start;
	private double length;
	private double grant;
	private int credits;
	
	public Study(String start, double length, double grant, int credits) {
		this.start = start;
		this.length = length;
		this.grant = grant;
		this.credits = credits;
	}

	public String getStart() {
		return start;
	}

	public double getLength() {
		return length;
	}

	public double getGrant() {
		return grant;
	}

	public int getCredits() {
		return credits;
	}
}
