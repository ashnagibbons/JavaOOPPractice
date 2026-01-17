//package cmp168final;

public abstract class Vehicle {
	protected Person[][] personsOnBoard;
	protected int numberOfRows;
	protected int maxSeatsPerRow;
	protected int[] numSeatsPerRow;
	
	public Vehicle(int numRows, int numSeatsPerRow) {
		personsOnBoard = new Person[numRows][numSeatsPerRow];
		numberOfRows = numRows;
		maxSeatsPerRow = numSeatsPerRow;
		this.numSeatsPerRow = new int[numberOfRows];
		for (int i = 0; i<this.numSeatsPerRow.length; i++) {
			this.numSeatsPerRow[i] = numSeatsPerRow;
		}
		
	}
	
	public Vehicle(int[] numSeatsPerRow) {
		
		if (numSeatsPerRow == null || numSeatsPerRow.length ==0) {
			this.numSeatsPerRow = new int[] {1};
		}
		else {
			this.numSeatsPerRow = numSeatsPerRow;
		}
		
		int max = 0;
		for (int i = 0; i <numSeatsPerRow.length; i++) {
			if (max < numSeatsPerRow[i]) {
				max = numSeatsPerRow[i];
			}
		}
		
		//System.out.println(numSeatsPerRow.length);
		
		this.maxSeatsPerRow = max;
		personsOnBoard = new Person[numSeatsPerRow.length][max];
		numberOfRows = numSeatsPerRow.length;
		
		
		/*for (int i = 0; i < personsOnBoard.length; i++) {
			for (int j = 0; j < personsOnBoard[i].length; j++) {
				System.out.println(j);
			}
		}*/
	}
	
	public Vehicle(Person driver, int[] numSeatsPerRow) {
		this(numSeatsPerRow);
		if (driver != null && driver.hasDriverLicense()) {
			personsOnBoard[0][0] = driver;
		}
	}
	
	public abstract boolean loadPassenger(Person p);
	
	public abstract int loadPassengers(Person[] peeps);
	
	public void setDriver(Person p) throws InvalidDriverException {
		if (p.hasDriverLicense()) {
			this.personsOnBoard[0][0] = p;
		}
		else {
			throw new InvalidDriverException();
		}
	}
	
	public Person getDriver() {
		return personsOnBoard[0][0];
	}
	
	public boolean hasDriver() {
		if (personsOnBoard[0][0] != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getNumberOfAvailableSeats() {
		int count = 0;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numSeatsPerRow[i]; j++) {
				if (personsOnBoard[i][j]==null) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public int getNumberOfAvailableSeatsInRow(int row) {
		int count = 0;
		if ((row < 0) || (row >= personsOnBoard.length)) {
			return -1;
		}
		else {
			for (int i = 0; i < numSeatsPerRow[row]; i++) {
				if (personsOnBoard[row][i] == null) {
					count++;
				}
			}
			return count;
		}
	}
	
	public int getNumberOfPeopleOnBoard() {
		int count = 0;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < personsOnBoard[i].length; j++) {
				if (personsOnBoard[i][j]!=null) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public int getNumberOfPeopleInRow(int row) {
		int count = 0;
		if ((row < 0) || (row >= personsOnBoard.length)) {
			return -1;
		}
		else {
			for (int i = 0; i < personsOnBoard[row].length; i++) {
				if (personsOnBoard[row][i] != null) {
					count++;
				}
			}
			return count;
		}
	}
	
	public Person getPersonInSeat(int row, int col) {
		if (row < 0 || row >= numberOfRows || col >= personsOnBoard[row].length || col < 0) {
			return null;
		}
		
		return personsOnBoard[row][col];
	}
	
	public int[] getLocationOfPersonInVehicle(Person p) {
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numSeatsPerRow[i]; j++) {
				if (personsOnBoard[i][j] != null && personsOnBoard[i][j].equals(p)) {
					return new int[] {i, j};
					
				}
			}
		}
		return new int[] {-1, -1};	
	}
	
	public Person[] getPeopleInRow(int row) {
		if ((row < 0) || (row >= personsOnBoard.length)) {
			return null;
		}
		else {
			int count = 0;
			
			for (int i = 0; i < personsOnBoard[row].length; i++) {
				if (personsOnBoard[row][i] != null) {
					count++;
				}
				
			}
			
			if (count == 0 ) {
				return null;
			}
			else {
			
			Person [] myArr = new Person[count];
			
			for (int i = 0; i < myArr.length; i++) {
				myArr[i] = personsOnBoard[row][i].clone();
			}
			
			return myArr;
			}
		}
	}
	
	public Person[][] getPeopleOnBoard() {
		Person[][] myArr = new Person[this.numberOfRows][this.maxSeatsPerRow];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				if (personsOnBoard[i][j] != null) {
					myArr[i][j] = personsOnBoard[i][j].clone();
				}
			}
		}
		
		return myArr;
	}
	
	public boolean isPersonInVehicle(Person p) {
		for (int i = 0; i < personsOnBoard.length; i++) {
			for (int j = 0; j < personsOnBoard[i].length; j++) {
				if (p.equals(personsOnBoard[i][j])) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isPersonDriver(Person p) {
		if (personsOnBoard[0][0] != null && personsOnBoard[0][0].equals(p) && p.hasDriverLicense()) {
			return true;
		}
		else {
			return false;
		}
	}
		

}
