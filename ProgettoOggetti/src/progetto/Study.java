package progetto;

import java.util.Vector;

public class Study extends Institute{
	private String start;
	private float length;
	private float grant;
	private int credits;
	
	public Study(String start, float length, float grant, int credits, String code, String country) {
		super(code,country);
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
	
	public String getCode() {
		return super.getCode();
	}
	
	public String getCountry() {
		return super.getCountry();
	}
	
	public void countString(String request, Erasmus[] study) {
		int j=0;
		Vector<String> done= new Vector<String>();
		String value;
		boolean a=true;
		switch(request) {
			case "start":
					value=study[0].getStudy().getStart();
					while(a){
						for(int i=0; i<study.length;i++) {
							if(study[i].getStudy().getStart().equals(value))
								j++;
						}
						System.out.println(value+":"+j);
						done.add(value);
						a=false;
						int k=0;
						do {
							if(!done.contains(study[k].getStudy().getStart()))
								a=true;
							else
								k++;
						}while(k<study.length & a==false);		
					}
				break;
			case "code":
				value=study[0].getStudy().getCode();
				while(a){
					for(int i=0; i<study.length;i++) {
						if(study[i].getStudy().getCode().equals(value))
							j++;
					}
					System.out.println(value+":"+j);
					done.add(value);
					a=false;
					int k=0;
					do {
						if(!done.contains(study[k].getStudy().getCode()))
							a=true;
						else
							k++;
					}while(k<study.length & a==false);		
				}
			break;
			case "country":
				value=study[0].getStudy().getCountry();
				while(a){
					for(int i=0; i<study.length;i++) {
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
		return "Study [start=" + start + ", length=" + length + ", grant=" + grant + ", credits=" + credits + "]";
	}
	
	
}
