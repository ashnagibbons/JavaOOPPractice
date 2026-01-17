//package midterm168;

public class Pediatrician extends Doctor{
	private boolean hasPrivatePractice;
	private String hospitalName;
	
	public Pediatrician(String name) {
		super(name);
		hasPrivatePractice = false;
		hospitalName = "";
	}
	
	public Pediatrician(String name, boolean hasPrivatePractice, String hospitalName) {
		super(name);
		this.hasPrivatePractice = hasPrivatePractice;
		this.hospitalName = hospitalName;
	}
	
	public boolean hasPrivatePractice() {
		return hasPrivatePractice;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String hosName) {
		hospitalName = hosName;
	}
	
	public void addPatient(Patient p) throws PatientException{ 
		if (2025 - p.getBirthYear() >= 18) {
			throw new PatientException("Pediatricians only see patients under 18");
		}
		else {
			super.addPatient(p);
		}
	}
	
	public String toString() {
		String s = super.toString();
		String pp;
		if (hasPrivatePractice) {
			pp = "true";
		}
		else {
			pp = "false";
		}
		String newStr = String.format("\nPediatrician: %s | hospital name=%15s", pp, hospitalName);
		
		return s + newStr;
	}
	
	public boolean equals(Object myObj) {
		if (myObj == null) {
			return false;
		}
		if (this == myObj) {
			return true;
		}
		if (myObj instanceof Pediatrician) {
			Pediatrician myPed = (Pediatrician) myObj;
			if (super.equals(myPed)) {
				if (this.hasPrivatePractice == myPed.hasPrivatePractice) {
					if (this.hospitalName == myPed.hospitalName) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
