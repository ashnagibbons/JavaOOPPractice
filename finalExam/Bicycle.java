//package cmp168final;

public class Bicycle extends Vehicle implements Comparable<Bicycle>{
	
	private double weight;
	private static final double ACCURACY_RANGE = 0.5;
	
	public Bicycle() {
		super(1,1);
		weight = 0;
	}
	
	public Bicycle(Person driver) {
		
		super(new int[]{1});
		if (driver != null && driver.getAge() >= 3) {
			personsOnBoard[0][0] = driver;
		}
		weight = 0;
	
	}
	
	public Bicycle(Person driver, double weight) {
		this(driver);
		
		if (weight < 0) {
			this.weight = 0;
		}
		else {
			this.weight = weight;
		}
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (o instanceof Bicycle) {
			Bicycle myBike = (Bicycle) o;
			if (Math.abs(this.weight - myBike.weight) <= ACCURACY_RANGE) {
				return true;
			}
		}
		return false;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double w) {
		if (w >= 0) {
			weight = w;
		}
		else {
			weight = 0;
		}
	}
	
	public void setDriver(Person p) throws InvalidDriverException {
		    
		if (p != null) {
		if (p.getAge() < 3) {
		        throw new InvalidDriverException("Driver must be at least 3 years old");
		    }
		    personsOnBoard[0][0] = p;
		}
	}

	
	public Person getDriver() {
		if (personsOnBoard != null) {
			return super.getDriver();
		}
		return null;
	}
	
	public String toString() {
		String myStr;
		if (getDriver() != null) {
			 myStr = "Bicycle [ rider= " + getDriver().getName() + " | weight= " + weight + " ]";

		}
		else {
			 myStr = "Bicycle [ rider= | weight= " + weight + " ]";
		}
		return myStr;
	}
	
	public int compareTo(Bicycle b) {
		if (this.getWeight() - b.getWeight() > ACCURACY_RANGE) {
			return 1;
		}
		else if (b.getWeight() - this.getWeight() > ACCURACY_RANGE) {
			return -1;
		}
		return 0;
	}

	@Override
	public boolean loadPassenger(Person p) {
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		return 0;
	}
	
	
	
	/*public static void main(String[] args) {
		Person myP = new Person("shasha", true, 45, 2);
		Bicycle myBike = null;
		try {
			myBike = new Bicycle(myP);
		} catch (InvalidDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(myBike.toString());
	}
	
		/*private double weight;
		private static final double ACCURACY_RANGE = 0.5;
		
		public Bicycle() {
		super(1,1); // 1 row, 1 seat
		weight =0;
	}
	    public Bicycle(Person driver) throws InvalidDriverException {
	        super(1, 1); // still initialize first
	        weight = 0;
	        setDriver(driver); // must call this to check age >= 3
	    }

	public Bicycle(Person driver, double weight) throws InvalidDriverException {
		super(1,1);
		this.weight = (weight <0) ? 0 : weight;
		setDriver(driver);
	}
	
	@Override
	public void setDriver(Person p) throws InvalidDriverException {
		if (p.getAge() <3) {
			throw new InvalidDriverException("Driver must be at least 3 years old");
		}
		personsOnBoard[0][0] =p;
	}
	
	@Override
	public boolean loadPassenger(Person p) {
		return false; // Bicycle can’t take passengers
	}
	
	@Override
	public int loadPassengers(Person[] peeps) {
		return 0;
	}
	
	@Override
	public String toString() {
		String ridername = (getDriver() !=null ? getDriver().getName() : "");
		return "Bicycle [rider= " + getDriver().getName() + "| weight= " + weight + "]";
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double w) {
		weight = (w < 0) ? 0 : w;
	}
	@Override
	public int compareTo(Bicycle b) {
		if (this.weight - b.weight > ACCURACY_RANGE) return 1;
		else if (b.weight - this.weight > ACCURACY_RANGE) return -1;
		return 0;
	}*/

	
	
	
}
