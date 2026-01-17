//package hw3;

abstract class Person extends Passenger{
	private int numOffspring;
	
	public Person() {
		super();
		numOffspring = 0;
	}
	
	public Person (int offspring) {
		super();
		numOffspring = offspring;
	}
	
	public Person(String name, int birthYear, double weight, double height, char gender, int numCarryOn, int numOffspring) {
		super(name, birthYear, weight, height, gender, numCarryOn);
		if (numOffspring < 0) {
			this.numOffspring = 0;
		}
		else {
			this.numOffspring = numOffspring;
		}
	}
	
	public void setNumOffspring (int numOffspring) {
		if (numOffspring >= 0) {
			this.numOffspring = numOffspring;
		}
		else {
			this.numOffspring = 0;
		}
	}
	
	public int getNumOffspring() {
		return numOffspring;
	}
	
	@Override
	public void printDetails() {
		System.out.print("Person: ");
		super.printDetails();
		System.out.printf("Number of Offspring: %4d\n", numOffspring);
		
	}
	
	@Override
	public String toString() {
		
		String myStr = super.toString() + String.format("Person: Number of Offspring: %4d\n", numOffspring);
		return myStr;
	}
	
	
	@Override
	public boolean equals(Object myObj) {
		Person myPerson = (Person) myObj;
		if (super.equals(myPerson)) {
			if (this.numOffspring == myPerson.numOffspring) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
}
