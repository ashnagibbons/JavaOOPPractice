//package hw3;

public class Driver {
	 public static void main(String[] args) {
		Airplane myPlane = new Airplane();
		Passenger pass1 = new Passenger("Albert", 1879, 198.5, 'm', 2);
		Passenger pass2 = new Passenger("Grace", 1906, 105, 'f', 1);
		Passenger pass3 = new Passenger("Tim", 1955, 216.3, 'm', 2);
		Passenger pass4 = new Passenger("Steve", 1955, 160, 'm', 2);
		Passenger pass5 = new Passenger("Sergey", 1973, 165.35, 'm', 1);
		
		myPlane.addPassenger(pass1);
		myPlane.addPassenger(pass2);
		myPlane.addPassenger(pass3);
		myPlane.addPassenger(pass4);
		myPlane.addPassenger(pass5);
		
		myPlane.printAllDetails();
		
		//myPlane.removePassenger(0);
		
		//myPlane.printAllDetails();
	 }
	
	
}
