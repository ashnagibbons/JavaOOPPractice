//package midterm168;

public class Doctor implements SeesPatients, Comparable<Doctor>{
	
	private static int numDoctors = 0;
	private String name;
	private int licenseNumber;
	private Patient[] patients;
	private int numberOfPatients;
	
	public Doctor (String name) {
		this.name = name;
		licenseNumber = ++numDoctors;
		patients = new Patient[MAX_PATIENTS];
		numberOfPatients = 0;
	}
	
	public static int getNumDoctors() {
		return numDoctors;
	}
	
	public int getLicenseNumber() {
		return licenseNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfPatients() {
		return numberOfPatients;
	}
	
	@Override
	public String toString() {
		String s = String.format("Doctor: name= %20s | license number= %06d | %s", name, licenseNumber, getPatientsAsString());
		return s;
	}
	
	public boolean equals(Object myObj) {
		if (myObj == null) {
			return false;
		}
		if (this == myObj) {
			return true;
		}
		if (myObj instanceof Doctor) {
			Doctor myDoc = (Doctor) myObj;
			if (this.name == myDoc.getName()) {
				if (this.numberOfPatients == myDoc.getNumberOfPatients()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public int compareTo(Doctor o) {
		if (this.numberOfPatients > o.getNumberOfPatients()) {
			return 1;
		}
		if (this.numberOfPatients < o.getNumberOfPatients()) {
			return -1;
		}
		return 0;
	}

	@Override
	public void addPatient(Patient p) throws PatientException {
		if (numberOfPatients >=MAX_PATIENTS) {
			throw new PatientException("Doctor is not accepting anymore patients");
		}
		else {
			patients[numberOfPatients] = p;
			numberOfPatients++;
		}
				
		
	}

	@Override
	public Patient[] getPatients() {
		return patients;
	}

	@Override
	public String getPatientsAsString() {
		String s = "patients= ";
		for (int i = 0; i < numberOfPatients; i++) {
			s += patients[i].toString();
			if (i != (numberOfPatients - 1)) {
				s += ", ";
			}
		}
		return s;
	}

	@Override
	public boolean isPatient(Patient p) {
		for (int i = 0; i < numberOfPatients; i++) {
			if (patients[i].equals(p)) {
				return true;
			}
		}
		return false;
		
	}

}
