//package cmp168final;

public class Car extends Vehicle implements Comparable<Car>, Announcements{
	private int numDoors;
	private int numWindows;
	
	public Car(int numDoors, int numWindows) {
		super(2,2);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
		
	}
	
	public Car(int numDoors, int numWindows, int numSeatsPerRow) {
		super(2, numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	
	public Car(int numDoors, int numWindows, int[] numSeatsPerRow) {
		super(numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	
	public Car(int numDoors, int numWindows, Person driver, int[] numSeatsPerRow) {
		super(driver, numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}

	@Override
	public String departure() {
		// TODO Auto-generated method stub
		return "All Aboard\n";
	}

	@Override
	public String arrival() {
		// TODO Auto-generated method stub
		return "Everyone Out\n";
	}

	@Override
	public String doNotDisturbTheDriver() {
		// TODO Auto-generated method stub
		return "No Backseat Driving\n";
	}
	
	public boolean canOpenDoor(Person p) {//exceptions are occurring for this and for can open window, make more explicit if else's
		if (p.getAge() > 5) {
			
			int lastRowWithDoors;
			
			if (numDoors < (2 * numberOfRows)) {
				lastRowWithDoors = numDoors/2;
			}
			else {
				lastRowWithDoors = numberOfRows;
			}
			
			int [] myArr = getLocationOfPersonInVehicle(p);
			
			if (myArr[0] < lastRowWithDoors) {
				if (myArr[1] == 0 || myArr[1] == numSeatsPerRow[myArr[0]] - 1) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean canOpenWindow(Person p) {
		if (p!= null && this.isPersonInVehicle(p) && p.getAge() > 2) {
			
			int [] myArr = this.getLocationOfPersonInVehicle(p);
			
			if (numWindows < (2* numberOfRows) && (!(this instanceof Bus))) {
			
				return (myArr[0] <(numWindows/2) && (myArr[1]==0 || myArr[1]==numSeatsPerRow[myArr[0]]-1));
			}
			
			else {
				return (myArr[1]==0 || myArr[1]==numSeatsPerRow[myArr[0]]-1);
			}
		}
			return false;
	}
	
	public int getNumDoors() {
		return numDoors;
	}
	
	public int getNumWindows() {
		return numWindows;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o==null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (o instanceof Car) {
			Car myCar = (Car) o;
			
			if (this.numDoors == myCar.numDoors) {
				if (this.numWindows == myCar.numWindows) {
					if (this.maxSeatsPerRow == myCar.maxSeatsPerRow) {
						if (this.numberOfRows == myCar.numberOfRows) {
							
							int count = 0;
							
							for (int i = 0; i < this.numSeatsPerRow.length; i++) {
								if (this.numSeatsPerRow[i]!= myCar.numSeatsPerRow[i]) {
									count++;
								}
							}
							
							if (count == 0) {
								return true;
							}
							else {
								return false;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String myStr = String.format("Car: number of doors = %02d | number of windows = %02d | number of rows = %02d | ", numDoors, numWindows, numberOfRows);
		String seatsPerRowStr = "[";
		String namesStr = "[";
		
		for (int i = 0; i < numSeatsPerRow.length; i++) {
			seatsPerRowStr += String.valueOf(numSeatsPerRow[i]);
			if (i < numSeatsPerRow.length -1) {
				seatsPerRowStr += ",";
			}
		}
		seatsPerRowStr += "]";
		
		
		for (int i = 0; i < personsOnBoard.length; i++) {
			if (getPeopleInRow(i) != null) {
			
			for (int j = 0; j < getPeopleInRow(i).length; j++) {
				namesStr += getPeopleInRow(i)[j].getName();
				if (!(i + 1 >= personsOnBoard.length && j+1 >= getPeopleInRow(i).length)) {
					namesStr += ",";
				}//is not putting comma between multiple rows of passengers
				
			}
			
		}
		}
		
		
		namesStr += "]";
		
		myStr += String.format("seats per row = %s | ", seatsPerRowStr);
		myStr += String.format("names of people on board = %s\n", namesStr);
		
		return myStr;
		
	}

	@Override
	public int compareTo(Car c) {
		int callCount = 0;
		int passCount = 0;
		
		for (int i = 0; i < this.numSeatsPerRow.length; i++) {
			callCount += this.numSeatsPerRow[i];
		}
		for (int i = 0; i < c.numSeatsPerRow.length; i++) {
			passCount += c.numSeatsPerRow[i];
		}
		
		if (callCount < passCount) {
			return -1;
		}
		else if (callCount > passCount) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean loadPassenger(Person p) {
		
		
		
		if ((p.getAge() >= 5) && (p.getHeight() >= 36)) {
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numSeatsPerRow[i]; j++) {
					if (personsOnBoard[i][j] == null) {
						personsOnBoard[i][j] = p;
						return true;
					}
				}
			}
		}
		else {
			for (int i = 1; i < numberOfRows; i++) {
				for (int j = 0; j < numSeatsPerRow[i]; j++) {
					if (personsOnBoard[i][j] == null) {
						personsOnBoard[i][j] = p;
						return true;
					}
				}
			}
		}
		return false;
		
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		int numLoaded = 0;
		
		for (int i = 0; i < peeps.length; i++) {
			if (loadPassenger(peeps[i])) {
				numLoaded++;
			}
		}
		return numLoaded;
	}
	
	
}
