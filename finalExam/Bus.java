//package cmp168final;

public class Bus extends Car implements Announcements{
	public Bus(int [] numSeatsPerRow) {
		super(2, (2 * numSeatsPerRow.length) - 1, numSeatsPerRow);
		numSeatsPerRow[0] = 1;
	}
	
	public Bus(Person driver, int[] numSeatsPerRow) {
		this(numSeatsPerRow);
		if (driver.hasDriverLicense()) {
			personsOnBoard[0][0] = driver;
		}
	}
	
	@Override
	public boolean canOpenDoor(Person p) {
		
		if (p == null) {
			return false;
		}
		if (isPersonDriver(p)) {
			return true;
		}
		if ((p.getAge() > 5) && (p.getHeight() > 40)) {//check math, use output statements
			//nt lastRow = -1;
			
			/*for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numSeatsPerRow[i]; j++) {
					if (personsOnBoard[i][j] == null) {
						if (j == 0) {
							lastRow = i -1;
							break;
						}
						else {
							lastRow = i;
							break;
						}
						
					}
				}
			}*/
			
			int [] myPosition = getLocationOfPersonInVehicle(p);
				
			if (myPosition[0] == numberOfRows - 1) {
				return true;
			}
			
		}
		return false;
	}

	public boolean canOpenWindow(Person p) {
		
		if (p==null) {
			return false;
		}
		return (super.canOpenWindow(p) && p.getAge() > 5);
		
		/*if (p.getAge() > 5) {
			
			int lastRowWithWindows;
			
			if (getNumWindows() < (2* numberOfRows)) {
				lastRowWithWindows = getNumDoors()/2;
			}
			else {
				lastRowWithWindows = personsOnBoard.length;
			}
			
			int [] myArr = getLocationOfPersonInVehicle(p);
			
			
			if (myArr[0] != -1 && myArr[1] != -1) {
			if (myArr[0] < lastRowWithWindows){
				if (myArr[1]==0 || myArr[1]==numSeatsPerRow[myArr[0]] - 1) {
				return true;
			}
			}
		}
		}
		
			return false;*/
	}
	
	@Override
	public String toString() {
		String myStr = "Bus is an extension of " + super.toString();
		return myStr;
	}
	
	public String departure() {
		String myStr = super.departure();
		myStr += "The Bus\n";
		return myStr;
	}
	
	public String arrival(){
		String myStr = super.arrival();
		myStr += "Of The Bus\n";
		return myStr;
	}
	
	public String doNotDisturbTheDriver() {
		String myStr = super.doNotDisturbTheDriver();
		myStr += "On The Bus\n";
		return myStr;
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("Baby", false, 1, 28);
		Person p2= new Person("Toddler", false, 2, 36);
		Person p3 = new Person("Young Tall Kiddo",false, 5, 41 );
		Person p4 = new Person("Short Kindergartener",false, 6, 40 );
		Person p5 = new Person("Just Right Kid",false, 6, 41 );
		Person p6 = new Person("Albert",false, 99, 67 );
		Person p7 = new Person("Ben",true, 51, 78 );
		Person p8 = new Person("Carol",false, 22, 64 );
		Person p9 = new Person("Dana",true, 47, 63 );
		Person p10 = new Person("Eric",true, 60, 72 );
		Person [] peeps = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};
		int [] numSeatsPerRow = {1,2,4,4};
		
  		Bus b = new Bus(numSeatsPerRow);
  		System.out.println(b.getNumDoors()+"\n\n");
  		System.out.println(b.getNumWindows()+"\n\n");//FIRST ROW ONLY HAS ONE WINDOW
  		
  		for (int i = 0; i < peeps.length; i++) {
			b.loadPassenger(peeps[i]);
			System.out.println(b.getLocationOfPersonInVehicle(peeps[i])[0] + " " + b.getLocationOfPersonInVehicle(peeps[i])[1]);
			System.out.println(b.canOpenDoor(peeps[i]));
			System.out.println(b.canOpenWindow(peeps[i]));
			System.out.println();
		}
  		

  	//if the person is on the bus (use is person in vehicle) and the person is over the age of five and the person is taller than 40
  		 //and if the person is the driver return true
  		//else 
  		//get number of people on board (check with zybook this method works) and use this method with the numSeatsPerRow array to
  		// get the location of the last person on board
  		//for can open door 
  		//if passed person is in same row as last person on board return true
  		//for can open window --> bus will always have numWindows < 2 x num rows because it's in the constructor so we have to compensate for that
  		//get location of passed person
  		//if passed person's row is less than or equal to last person's row
  		//and the person's column is 0 or the last valid index of seats in that particular row (use numSeatsPerRow) then return true

 
  		


  		


















	}

	
	
}
