//package hw3;

public class test {
	public static void main(String[] args) {
	
		Infant myBaby = new Infant("Babe", 2004, 1.0, 34.0, 'f', 0);
	
		Food favoriteFood = new Food("pizza", 1000);
	
		myBaby.eat(favoriteFood);
	
		System.out.print(myBaby.metabolizeAccumulatedCalories());
		
	}
}
