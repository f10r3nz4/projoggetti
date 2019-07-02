package progetto;

import java.util.Vector;

public class Placement {
	private String enterprise;
	private String country;
	private String sector;
	private String start;
	private int credits;
	private int grant;
	private char size;
	private float length;
	
	public Placement(String enterprise, String country, String sector, String start, int credits, int grant, char size,
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

	public int getGrant() {
		return grant;
	}

	public void setGrant(int grant) {
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
	
	public void countString(String request, Erasmus[] placement) {
		
		int j=0;
		Vector<String> done= new Vector<String>();
		String value;
		boolean a=true;
		switch(request) {
			case "enterprise":
					value=placement[0].getPlacement().getEnterprise();
					while(a){
						for(int i=0; i<placement.length;i++) {
							if(placement[i].getPlacement().getEnterprise().equals(value))
								j++;
						}
						System.out.println(value+":"+j);
						done.add(value);
						a=false;
						int k=0;
						do {
							if(!done.contains(placement[k].getPlacement().getEnterprise()))
								a=true;
							else
								k++;
						}while(k<placement.length & a==false);		
					}
				break;
			case "country":
				value=placement[0].getPlacement().getCountry();
				while(a){
					for(int i=0; i<placement.length;i++) {
						if(placement[i].getPlacement().getCountry().equals(value))
							j++;
					}
					System.out.println(value+":"+j);
					done.add(value);
					a=false;
					int k=0;
					do {
						if(!done.contains(placement[k].getPlacement().getCountry()))
							a=true;
						else
							k++;
					}while(k<placement.length & a==false);		
				}
			break;
			case "sector":
				value=placement[0].getPlacement().getSector();
				while(a){
					for(int i=0; i<placement.length;i++) {
						if(placement[i].getPlacement().getSector().equals(value))
							j++;
					}
					System.out.println(value+":"+j);
					done.add(value);
					a=false;
					int k=0;
					do {
						if(!done.contains(placement[k].getPlacement().getSector()))
							a=true;
						else
							k++;
					}while(k<placement.length & a==false);		
				}
			break;
			case "start":
				value=placement[0].getPlacement().getStart();
				while(a){
					for(int i=0; i<placement.length;i++) {
						if(study[i].getStudy().getCountry().equals(value))
							j++;
					}
					System.out.println(value+":"+j);
					done.add(value);
					a=false;
					int k=0;
					do {
						if(!done.contains(study[k].getStudy().getCountry()))
							a=true;
						else
							k++;
					}while(k<study.length & a==false);		
				}
			break;
		}
		
	}
	
	@Override
	public String toString() {
		return "Placement [enterprise=" + enterprise + ", country=" + country + ", sector=" + sector + ", start="
				+ start + ", credit=" + credit + ", grant=" + grant + ", size=" + size + ", length=" + length + "]";
	}
	
	
}
