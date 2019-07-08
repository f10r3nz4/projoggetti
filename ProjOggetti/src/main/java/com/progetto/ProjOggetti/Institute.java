package com.progetto.ProjOggetti;

/**
 * <p>La classe <b>Institute</b> è composta da tutti i valori che definiscono un Istuto scolastico
 * per quanto riguarda i dati in utilizzo.
 * E' una classe pubblica che prende quattro parametri di tipo stringa.
 * Sono poi presenti i consueti costruttore (con super()) e get e set.</p>
 */

public class Institute {
	private String home_code;
	private String home_country;
	private String host_code;
	private String host_country;

	public Institute(String home_code, String home_country, String host_code, String host_country) {
		super();
		this.home_code = home_code;
		this.home_country = home_country;
		this.host_code = host_code;
		this.host_country = host_country;
	}

	public String getHome_code() {
		return home_code;
	}

	public void setHome_code(String home_code) {
		this.home_code = home_code;
	}

	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
	}

	public String getHost_code() {
		return host_code;
	}

	public void setHost_code(String host_code) {
		this.host_code = host_code;
	}

	public String getHost_country() {
		return host_country;
	}

	public void setHost_country(String host_country) {
		this.host_country = host_country;
	}
	
}
