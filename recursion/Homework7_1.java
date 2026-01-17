//package Homework7;

public class Homework7_1 {
	
	public static int fib(int n) {
		if (n==1) {
			return 1;
		}
		else if (n==0) {
			return 0;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
		
	}
	
	public static int getPowerOfXtoN(int xBase, int nExp) {
		if (nExp == 0) {
			return 1;
		}
		else if (nExp==1) {
			return xBase;
		}
		else {
			return xBase * getPowerOfXtoN(xBase, nExp-1);
		}
			
	}
	
	public static int binarySearch(String target, String[] words) {
		return helpBinarySearch(words, 0, words.length -1, target);
	}
	
	public static int helpBinarySearch(String arr[], int low, int high, String target) {
		
		if (high >= low) {
		int mid = (low + high)/2;
		
		if (arr[mid].equals(target)) {
			return mid;
		}
		
		if (arr[mid].compareTo(target) > 0) {
			return helpBinarySearch(arr, low, mid-1, target);
		}
		else {
			return helpBinarySearch(arr, mid+1, high, target);
		}
		}
		else {
			return -1;
		}
	
	}
	
	public static int organizeParade(int paradeLength) {
		if (paradeLength == 1) {
			return 2;
		}
		else if (paradeLength == 2) {
			return 3;
		}
		else {
			return organizeParade(paradeLength -1) + organizeParade(paradeLength-2);
		}
	}
	
	public static int numJarsNeeded(int candyCount, int jarCapacity) {
		int total;
		
		
		if (candyCount<=0) {
			total = 0;
		}
		else if (candyCount <= jarCapacity) {
			total = 1;
			
		}
		else {
			//int numDivisions = 0;
			int remainder = candyCount%2;
			int newCount = candyCount/2;
			//numDivisions++;
			
			total = ((numJarsNeeded(newCount, jarCapacity)) + numJarsNeeded(newCount+ remainder, jarCapacity)); //* numDivisions;	
			
		
			
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		//System.out.println((Math.log(8)/Math.log(2)));
		System.out.println(numJarsNeeded(16, 4));
	}

}
