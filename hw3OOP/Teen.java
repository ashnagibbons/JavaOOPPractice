//package hw3;

public class Teen extends Person implements Mover, Eater{
	
	@Override
	public double metabolizeAccumulatedCalories() {
		double weightGained = (double) this.getCaloriesAccumulator()/5000;
		this.gainWeight(weightGained);
		this.setCaloriesAccumulator(0);
		return weightGained;
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return "run fast and jump";
	}

	@Override
	public String move(int count) {
		String myStr = "";
		
		if (count <= 0) {
			return myStr;
		}
		else {
			for (int i = 0; i < count; i++) {
				if (i == count -1 ) { 
					myStr = myStr + "run fast and jump";
				}
				else {
					myStr = myStr + "run fast and jump\n";
				}
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
