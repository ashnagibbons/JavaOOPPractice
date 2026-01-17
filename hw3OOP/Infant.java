//package hw3;

public class Infant extends Person implements Mover, Eater {
	public class InfantToy {
		private String infantToyName;
		private int infantToyRating;
		
		public InfantToy(String toyName, int toyRating) {
			infantToyName = toyName;
			infantToyRating = toyRating;
			
		}
		
		@Override
		public String toString() {
			String myStr = String.format("Toy Name: %20s\n Toy Rating: %1d\n", infantToyName, infantToyRating);
			return myStr;
		}
	}
	
	private InfantToy[] toys;
	private int numInfantToys;
	
	public Infant() {
		numInfantToys = 0;
		this.toys = new InfantToy[10]; 
	}
	
	public Infant(String name, int birthYear, double weight, double height, char gender, int numCarryOn) {
		super(name, birthYear, weight, height, gender, numCarryOn, 0);
		numInfantToys = 0;
		this.toys = new InfantToy[10];
	}
	
	public void addInfantToy(String name, int rating) {
		for (int i = 0; i < toys.length; i++) {
			if (toys[i] == null) {
				toys[i] = new InfantToy(name, rating);
				numInfantToys = numInfantToys + 1;
				break;
			}
		}
	}
	
	public String getInfantToyAsString(int index) {

		if (index < 0 || index > numInfantToys-1) {
			return "invalid index " + index;
		}
		else {
			return String.format("InfantToy: Toy Name: %20s | Rating %4d\n", toys[index].infantToyName, toys[index].infantToyRating);
		}
	}
	
	public int getNumInfantToys() {
		int count = 0;
		for (int i = 0; i < toys.length; i ++) {
			if (toys[i] != null) {
				count += 1;
			}
		}
		
		numInfantToys = count;
		
		return numInfantToys;
	}
	
	public String getInfantToyName(int index) {
		if (index < 0 || index > numInfantToys-1) {
			return "invalid index" + String.valueOf(index);
		}
		else {
			return toys[index].infantToyName;
		}
	}
	
	public int getInfantToyRating(int index) {
		if (index < 0 || index > numInfantToys-1) {
			return -1;
		}
		return toys[index].infantToyRating;
	}
	
	public int getHighestInfantToyRating() {
		
		int rating = 0;
		for (int i = 0; i < numInfantToys; i ++) {
			int currRating = toys[i].infantToyRating;
			if (currRating > rating) {
				rating = currRating;
			}
			
		}
		
		return rating;
	
	}
	
	
	@Override
	public void printDetails() {
		super.printDetails();
		System.out.printf("Infant: Number of Toys: %4d | Infant Toys:\n", getNumInfantToys());
		for (int i = 0; i < getNumInfantToys(); i++) {
			System.out.print(getInfantToyAsString(i));
		}
	}
	
	@Override
	public String toString() {
		String myStr = "";
		myStr = myStr + super.toString();
		
		for (int i = 0; i < getNumInfantToys(); i++) {
			myStr = myStr + getInfantToyAsString(i);
		}
		
		return myStr;
	}
	
	@Override
	double metabolizeAccumulatedCalories() {
		double weightGained = (double) this.getCaloriesAccumulator()/1200;
		this.gainWeight(weightGained);
		this.setCaloriesAccumulator(0);
		return weightGained;
	}
	
	@Override
	public String move() {
		return "flail arms and legs";
	}
	
	@Override
	public String move(int count) {
		String myStr = "";
		
		if (count <= 0) {
			return myStr;
		}
		else {
			for (int i = 0; i < count; i++) {
				 myStr = myStr + "flail arms and legs\n";
			}
		}
		
		return myStr;
	}
	
	@Override
	public void eat(Food food) {
		this.setCaloriesConsumed(this.getCaloriesConsumed() + food.getCalories());
		this.setCaloriesAccumulator(this.getCaloriesAccumulator() + food.getCalories());
		
	}

	@Override
	public void eat(Food[] foods) {
		for (int i = 0; i < foods.length; i++) {
			if (foods[i] != null) {
				this.setCaloriesConsumed(this.getCaloriesConsumed() + foods[i].getCalories());
				this.setCaloriesAccumulator(this.getCaloriesAccumulator() + foods[i].getCalories());
			}
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
