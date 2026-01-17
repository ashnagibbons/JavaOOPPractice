//package hw3;

public class Food {
	private String name;
	private int calories;
	
	public Food(String foodName, int foodCal) {
		name = foodName;
		calories = foodCal;
	}
	
	public void setName(String foodName) {
		name = foodName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCalories(int foodCal) {
		calories = foodCal;
	}
	
	public int getCalories() {
		return calories;
	}
	
	@Override
	public String toString() {
		String myStr = String.format("Food - name: %10s | calories: %4d", name, calories);
		return myStr;
	}
	
	@Override
	public boolean equals(Object myObj) {
		Food myFood = (Food)myObj;
		if (this.name == myFood.name) {
			if (this.calories == myFood.calories) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
}
