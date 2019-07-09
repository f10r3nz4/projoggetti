package com.progetto.ProjOggetti;

/**
 * <p>Nella classe pubblica <b>Language</b> si passano tre parametri di cui due tipi stringa ed un char.
 * Sono presenti il costruttore con super(), get e set.</p>
 */

public class Language {
	private String language;
	private String lang_preparation;
	private char lang_taught;
	
	public Language(String language, String lang_preparation, char lang_taught) {
		super();
		this.language = language;
		this.lang_preparation = lang_preparation;
		this.lang_taught = lang_taught;
		
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLang_preparation() {
		return lang_preparation;
	}

	public void setLang_preparation(String lang_preparation) {
		this.lang_preparation = lang_preparation;
	}

	public char getLang_taught() {
		return lang_taught;
	}

	public void setLang_taught(char lang_taught) {
		this.lang_taught = lang_taught;
	}

}
