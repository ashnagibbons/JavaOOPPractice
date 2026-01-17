package minesweeper;

public class DayEnd {
		 static void timeHour(int hours) {
		 int timeLeft;
		 try {
		 if (hours > 23) { 
		 throw new Exception("Invalid Hour!");
		 }
		 timeLeft = 24 - hours;
		 System.out.println("Time Left: "+timeLeft);
		 }


		 catch (Exception excpt) {
		 System.out.println("Oops");
		 System.out.println(excpt.getMessage());
		 }
		 }


		 public static void main(String[] args) {
		 timeHour(23);
		 }
		}

