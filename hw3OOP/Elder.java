//package hw3;

public class Elder extends Person implements Mover, Eater{
	public double metabolizeAccumulatedCalories() {
		double weightGained = (double) this.getCaloriesAccumulator()/300;
		this.gainWeight(weightGained);
		this.setCaloriesAccumulator(0);
		return weightGained;
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return "ouch my back wait for me";
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
					myStr = myStr + "ouch my back wait for me";
				}
				else {
					myStr = myStr + "ouch my back wait for me\n";
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
