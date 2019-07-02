package progetto;

public class Language {
	private String language;
	private String lang_preparation;
	private boolean lang_taught;
	
	public Language(String language, String lang_preparation, boolean lang_taught) {
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

	public boolean isLang_taught() {
		return lang_taught;
	}

	public void setLang_taught(boolean lang_taught) {
		this.lang_taught = lang_taught;
	}

	@Override
	public String toString() {
		return "Language [language=" + language + ", lang_preparation=" + lang_preparation + ", lang_taught="
				+ lang_taught + "]";
	}

}
