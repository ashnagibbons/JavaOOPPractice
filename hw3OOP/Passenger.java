//package hw3;


//public class Passenger{
public abstract class Passenger implements Eater{
	
	private String name;
	private int birthYear;
	private double weight;
	private char gender;
	private int numCarryOn;
	private double height;
	private int caloriesConsumed;
	private int caloriesAccumulator;
	
	public Passenger() {
		name = "";
		birthYear = 1900;
		weight = 0.0;
		height = 0.0;
		gender = 'u';
		numCarryOn = 0;
				
	}
	
	public Passenger (String name, int birthYear, double weight, double height, char gender, int numCarryOn) {
		this.name = name;
		this.birthYear = birthYear;
		
		if (weight < 0) {
			this.weight = -1;
		}
		else {
			this.weight = weight;
		}
		
		if (height < 0) {
			this.height = -1; 
		}
		else {
			this.height = height;
		}
		
		if (gender == 'f' ) {
			this.gender = 'f';
		}
		else if (gender == 'm') {
			this.gender = 'm';
		}
		else {
			this.gender = 'u';
		}
		
		if (numCarryOn < 0) {
			this.numCarryOn = 0;
		}
		else if (numCarryOn > 2) {
			this.numCarryOn = 2;
		}
		else {
			this.numCarryOn = numCarryOn;
		}
	}
	
	public int calculateAge(int currentYear) {
		if (currentYear < birthYear) {
			return -1;
		}
		else {
			int age = currentYear - birthYear;
			return age;
		}
	}
	
	public void gainWeight() {
		weight = weight + 1;
	}
	
	public double calculateBMI() {
		double bmi = (this.weight * 703) / (this.height * this.height);
		return bmi;
	}
	
	
	
	public void gainWeight(double input) {
		if (input < 0) {
			System.out.println("ERROR: please enter a positive amount of weight");
		}
		else {
			weight = weight + input;
		}
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public char getGender(){
		return gender;
	}
	
	public String getName(){
		return name;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public int getNumCarryOn() {
		return numCarryOn;
	}
	
	public boolean isFemale() {
		if (gender == 'f') {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isMale() {
		if (gender == 'm') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void loseWeight() {
		if (weight - 1 < 0) {
			System.out.println("ERROR: weight is already zero, cannot lose weight");
		}
		else {
		weight = weight - 1;
		}
		
	}
	
	public void loseWeight(double input) {
		if (weight - input < 0) {
			System.out.println("ERROR: resulting weight is less than zero, please enter smaller number");
		}
		else {
			weight = weight - input;
		}
	}
	
	public void printDetails() {
		System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d\n", name, birthYear, weight, height, gender, numCarryOn);
	}
	
	public double getHeight() {
	return height;
}

public void setHeight(double userHeight) {
	if (userHeight < 0) {
		height = -1;
	}
	else {
		height = userHeight;}
}
	
	@Override
	public String toString() {
		String myStr = String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d\n", name, birthYear, weight, height, gender, numCarryOn);
		return myStr;
	}
	
	@Override
	public boolean equals(Object myObj) { //you pass in something of object class to be able to use the equals method so it follows the rules (depends on what java version)
		if (myObj == null) {return false;}
		if (this == myObj) {return true;} //if it's the same object they equal each other
		if (myObj instanceof Passenger) { // make sure this is a passenger object
		
			Passenger passObj = (Passenger) myObj; //cast myObj to a new passenger object because we don't want to compare two objects of different classes
			if (this.birthYear == passObj.birthYear) {
				if (this.gender == passObj.gender) {
					if (this.name == passObj.name) {
						if (Math.abs(this.weight - passObj.weight) <= .5) {
							if (Math.abs(this.height - passObj.height) <= .5) {
								return true;
						}
					}
				}
			}
		}
		}
		
			return false;
		
	}
	
	public void setGender (char input) {
		if ((input == 'm')) {
			gender = 'm';
		}
		else if (input == 'f') {
			gender = 'f';
		}
		else {
			gender = 'u';
		}
	}
	
	public void setName(String input) {
		name = input;
	}
	
	public void setBirthYear(int input) {
		birthYear = input;
	}
	
	public void setWeight(double input) {
		if (input < 0) {
			weight = -1;
		}
		else {
			weight = input;
		}
	}
	
	public void setNumCarryOn (int input) {
		if (input < 0) {
			numCarryOn = 0;
		}
		else if (input > 2) {
			numCarryOn = 2;
		}
		else {
			numCarryOn = input;
		}
	}
	
	public int getCaloriesConsumed() {
		return caloriesConsumed;
	}
	
	public void setCaloriesConsumed(int cals) {
		caloriesConsumed = cals;
	}
	
	public int getCaloriesAccumulator() {
		return caloriesAccumulator;
	}
	
	public void setCaloriesAccumulator(int accumulatedCals) {
		caloriesAccumulator = accumulatedCals;
	}
	
	abstract double metabolizeAccumulatedCalories();
	
	/*public static Passenger[] resizePassengerArray(Passenger [] passenger) {
		passenger = new Passenger[(passenger.length)*2];
		return passenger;
	}
	
	private int caloriesConsumed = 0;
	private int caloriesAccumulator = 0;
	
	
	
	
	
	*/
			

}
