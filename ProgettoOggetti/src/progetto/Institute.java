package progetto;

public abstract class Institute {
	protected String code;
	protected String country;
	
	public Institute(String code, String country) {
		super();
		this.code = code;
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
