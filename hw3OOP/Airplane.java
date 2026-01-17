//package hw3;

public class Airplane {
	private Passenger [] passengers;
	private String airplaneName;
	private int numPassengers;
	
	public Airplane() {
		airplaneName = "";
		passengers = new Passenger[100];
		numPassengers = 0;
	}
	
	public Airplane(String name) {
		this();
		airplaneName = name; 
	}
	
	public Airplane(int length) {
		this();
		if (length < 0) {
			passengers = new Passenger[0];
		}
		else {
			passengers = new Passenger[length];
		}
		//numPassengers = 0;
	}
	
	public Airplane(String name, int length) {
		this();
		airplaneName = name;
		if (length < 0) {
			passengers = new Passenger[0];
		}
		else {
			passengers = new Passenger[length];
		}
		//numPassengers = 0;
	}
	
	
	public void resizePassengerArray() {
		Passenger[] tempArray = new Passenger[passengers.length*2];
		for (int i = 0; i < passengers.length; i++) {
			tempArray[i] = passengers[i];
		}
		
		/*Passenger [] passengers = new Passenger[tempArray.length];
		for (int i = 0; i < passengers.length; i++) {
			passengers[i] = tempArray[i];
		} */
		
		passengers = tempArray;
	}
	
	public void addPassenger(Passenger a) {
		int index = -1;
		
		checkLoop: 
		do {
			for (int i = 0; i < passengers.length; i ++) {
				if (passengers[i] == null) {
					index = i;
					break checkLoop;
				}
			}			
			resizePassengerArray();
			
		}while (index == -1);
	
		
		 passengers[index] = a;
		 numPassengers = numPassengers + 1;
							
	}
	
	

	public String getAirplaneName() {
		return airplaneName;
	}
	
	public Passenger getPassenger(int index) {
		if ((index < 0) || (index >= passengers.length)) {
			return null;
		}
		else {
			return passengers[index];
		}
		
	}
	
	public int getNumPassengers() {
		return numPassengers;
	}
	
	public Passenger getFirstPassenger() {
		return passengers[0];
	}
	
	public Passenger getLastPassenger() {
		Passenger result = new Passenger();
		
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] != null) {
				result = passengers[i];
			}
		}
		return result;
	}
	
	public Passenger[] getPassengers() {
		return passengers;
	}
	
	public void setAirplaneName(String name) {
		airplaneName = name;
	}
	
	public void printAllDetails() {
		
		System.out.printf("AirplaneName: %20s | Number of Passengers: %4d | Airplane Size: %4d\n", 
				airplaneName, numPassengers, passengers.length);
		
		for (int i = 0; i < numPassengers; i++) {
			passengers[i].printDetails();
		}
	}
	
	public Passenger removePassenger(int index) {
		if ((index >= 0)&&(index< numPassengers)) {
			
			Passenger myPass = passengers[index];
			
			for (int i = index; i < numPassengers -1; i++) {
				passengers[i] = passengers[i+1];
			}
			
			passengers[numPassengers -1 ] = null;
			
			
			/*if (index == passengers.length - 1) {
				passengers[index] = null;
			}
			else {
				for (int i = index; i < passengers.length-1; i++) {
					passengers[i] = passengers[i+1];
				}
				passengers[passengers.length -1] = null;
			} */
			
			numPassengers = numPassengers -1;
			return myPass;
			
		}
		else {
			return null;
		}
		 
	}
	
	public void removeAllPassengers() {
		for (int i = 0; i < passengers.length; i++) {
			passengers[i] = null;
		}
	}
	
	public double getTotalWeightOfAllPassengers() {
		double sum = 0;
		double weight = 0;
		
		for (int i = 0; i < passengers.length; i ++) {
			if (passengers[i] != null) {
				weight = passengers[i].getWeight();
				sum = sum + weight;
			}
		}
		
		return sum;
	}
	
	public double getAverageWeightOfAllPassengers() {
		//double sum = getTotalWeightOfAllPassengers();
		double sum = 0;
		int count = 0;
		
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] != null) {
				sum = sum + passengers[i].getWeight();
				count = count + 1;
			}
		}
		return sum/count;
	}
	
	public int getNumberOfPassengersAboveWeight(double minWeight) {
		int count = 0;
		double weight = 0;
		
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] != null) {
				weight = passengers[i].getWeight();
				if (weight > minWeight) {
					count = count + 1;
				}
			}
		}
		
		return count;
	}
	
	public int getNumberOfPassengersBelowWeight(double maxWeight) {
		int count = 0;
		double weight = 0;
		
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] != null) {
				weight = passengers[i].getWeight();
				if (weight < maxWeight) {
					count = count + 1;
				}
			}
		}
		
		return count;
	}
	
	public void increaseWeightOfAllPassengers() {
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] != null) {
				passengers[i].gainWeight();
			}
		}
	}
	
	public void increaseWeightOfAllPassengers(double weight) {
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] != null) {
				passengers[i].gainWeight(weight);
			}
		}
	}
	
	
	
}
