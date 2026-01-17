//package midterm168;

public class Gerontologist extends Doctor{
	private boolean performsHouseCalls;
	private double visitFee;
	
	public Gerontologist(String name) {
		super(name);
		performsHouseCalls = true;
		visitFee = 0.0;
	}
	
	public Gerontologist(String name, boolean performsHouseCalls, double visitFee) {
		super(name);
		this.performsHouseCalls = performsHouseCalls;
		this.visitFee = visitFee;
	}
	
	public boolean performsHouseCalls() {
		return performsHouseCalls;
	}
	
	public double getVisitFee() {
		return visitFee;
	}
	
	public void setPerformsHouseCalls(boolean houseCalls) {
		performsHouseCalls = houseCalls;
	}
	
	public void setVisitFee(double fee) {
		if (fee < 0) {
			visitFee = 0.0;
		}
		else {
			visitFee = fee;
		}
	}
	
	public void addPatient(Patient p) throws PatientException{
		if (2025 - p.getBirthYear() <= 65) {
			throw new PatientException("Georntologists only see patients over the age of 65");
		}
		else {
			super.addPatient(p);
		}
	}
	
	public String toString() {
		String s = super.toString();
		String newStr = String.format("\nGerontologist: %s | visit fee=%02.2f", (performsHouseCalls ? "performs house calls" : "no house calls"), visitFee);
		return s+newStr;

	}
	
	public boolean equals(Object myObj) {
		if (myObj == null) {
			return false;
		}
		if (this == myObj) {
			return true;
		}
		if (myObj instanceof Gerontologist) {
			Gerontologist myGer = (Gerontologist) myObj;
			if (super.equals(myGer)) {
				if (this.performsHouseCalls == myGer.performsHouseCalls) {
					if (Math.abs(this.visitFee - myGer.visitFee) < 0.05) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
