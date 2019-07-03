package com.example.demo;

public class Study {
	private String start;
	private float length;
	private float grant;
	private int credits;
	
	public Study(String start, float length, float grant, int credits) {
		this.start = start;
		this.length = length;
		this.grant = grant;
		this.credits = credits;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getGrant() {
		return grant;
	}

	public void setGrant(float grant) {
		this.grant = grant;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
}
