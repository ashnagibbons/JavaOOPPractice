//package Array;

public class Array {
	
	public static int sum(int[] arr) {
		int sum = 0;
		int i;
		
		for (i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		
		//System.out.print("Sum of whole array = ");
		return sum;
	}

	public static int sum(int[] arr, int firstIndex, int lastIndex) {
		int sum = 0;
		int i;
		
		if ((firstIndex < 0) || (lastIndex > arr.length - 1) || (firstIndex > lastIndex)) {
			return -666;
		}
		
		else {
			for (i = firstIndex; i <= lastIndex; i++) {
				sum = sum + arr[i];
			}
		
			System.out.print("Sum of elements " + firstIndex + "-" + lastIndex + " = ");
			return sum;
		}
	}	
	
	public static double average(int[] arr) {
		double sum = 0.0;
		int count = 0;
		int i;
		double avg;
		
		for (i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			count = count + 1;
		}
		
		avg = sum/count;
		
		System.out.print("Average of whole array = "); 
		return avg;
		
	}
	
	public static double average(int[] arr, int firstIndex, int lastIndex) {
		double sum = 0.0;
		int count = 0;
		int i;
		double avg;
		
		if ((firstIndex < 0) || (lastIndex > arr.length - 1) || (firstIndex > lastIndex)) {
			return -666;
		}
		
		else {
			for (i = firstIndex; i <= lastIndex; i++) {
				sum = sum + arr[i];
				count = count + 1;
			}
		
			avg = sum/count;
		
			System.out.print("Average of elements " + firstIndex + "-" + lastIndex + " = ");
			return avg;
		}
	}

	public static int maxValue(int[] arr) {
		int i;
		int maxVal = arr[0];
		
		for (i = 1; i < arr.length; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}
		
		System.out.print("Max of whole array = ");
		return maxVal;
	}
	
	public static int maxValue(int[] arr, int firstIndex, int lastIndex) {
		int i;
		int maxVal;
		maxVal = 0;
		
		if ((firstIndex < 0) || (lastIndex > arr.length - 1) || (firstIndex > lastIndex)) {
			return -666;
		}
		
		else {
			for (i = firstIndex; i <= lastIndex; i++) {
				if (arr[i] > maxVal) {
					maxVal = arr[i];
				}
			}
			
			System.out.print("Max of elements " + firstIndex + "-" + lastIndex + " = ");
			return maxVal;
		}
	}
	
	public static int indexOfFirstMaxValue(int[] arr) {
		int i;
		int indexMaxVal = 0;
		int maxVal = arr[0];
		
		
		for (i = 1; i < arr.length; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
				indexMaxVal = i;
			}
		}
		
		System.out.print("Index of first Max of whole array = ");
		return indexMaxVal;
	}
	
	public static int indexOfFirstMaxValue(int[] arr, int firstIndex, int lastIndex) {
		
		if ((firstIndex < 0) || (firstIndex >= (arr.length)) || (lastIndex < 0) || (lastIndex >= (arr.length)) || (firstIndex > lastIndex)) {
			return -1;
		}
		
		else {
			int i;
			int indexMaxVal = 0;
			int maxVal = arr[firstIndex];
			
			for (i = firstIndex; i <= lastIndex; i++) {
				if (arr[i] > maxVal) {
					maxVal = arr[i];
					indexMaxVal = i;
				}
			}
			
			System.out.print("Index of first Max of elements " + firstIndex + "-" + lastIndex + " = ");
			return indexMaxVal;
		}
	}
	
	public static int numberOfBelowAverageElements(int[] arr) {
		double sum = 0.0;
		int count = 0;
		int i;
		double avg;
		int numBelowAvg = 0;
		
		avg = average(arr);
		/*for (i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			count = count + 1;
		}
		
		avg = sum/count;*/
		
		for (i = 0; i < arr.length; i++) {
			if (arr[i] < avg) {
				numBelowAvg = numBelowAvg + 1;
			}
		}
		
		System.out.print("Count of elements below average of whole array = ");
		return numBelowAvg;
	}
	
	public static int numberOfBelowAverageElements(int[] arr, int firstIndex, int lastIndex) {
		double sum = 0.0;
		int count = 0;
		int i;
		double avg;
		int numBelowAvg = 0;
		
		if ((firstIndex < 0) || (lastIndex > arr.length - 1) || (firstIndex > lastIndex)) {
			return -666;
		}
		
		else {
		
			for (i = firstIndex; i <= lastIndex; i++) {
				sum = sum + arr[i];
				count = count + 1;
			}
		
			avg = sum/count;
		
			for (i = firstIndex; i <= lastIndex; i++) {
				if (arr[i] < avg) {
					numBelowAvg = numBelowAvg + 1;
				}
			}
			
			System.out.print("Count of elements below average of elements " + firstIndex + "-" + lastIndex + " = ");
			return numBelowAvg;
		}
	}
	
	public static void rotateElements(int[] arr) {
		int i;
		int lastVal = arr[arr.length -1];

		for (i = arr.length - 1; i > -1; i--) {
			if (i > 0) {
				arr[i] = arr[i-1];
			}
			else {
				break;
			}
		}
		
		arr[0] = lastVal;
		
		System.out.println("Rotating once");
		System.out.print("Your array = {");
		
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		
		System.out.println("}");
		
	}
	
	public static void rotateElements(int[] arr, int rotationCount) {
		int i;
		int [] lastCountVals = new int [rotationCount];
		
		for (i = 0; i < rotationCount; i++) {
			lastCountVals[i] = arr[i + (arr.length - rotationCount)];
		}
		
		for (i = arr.length - 1; i >= rotationCount; i--) {
			if (i > 0) {
				arr[i] = arr[i - rotationCount];
			}
			else {
				break;
			}
		}
		
		for (i = 0; i < rotationCount; i++) {
			arr[i] = lastCountVals[i];
		}
		
		System.out.println("Rotating " + rotationCount + " more times");
		System.out.print("Your array = {");
		
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		
		System.out.println("}");
		
		
	}
	
	public static void reverseArray(int[] arr) {
		int i;
		int tempVal;
		int halfLength = arr.length / 2;
		
		for (i = 0; i < halfLength; i++) {
			tempVal = arr[i];
			arr[i] = arr[arr.length - (1 + i)];
			arr[arr.length - (1 + i)] = tempVal;
		}
		
		System.out.println("Reversing the array");
		System.out.print("Your array = {");
		
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		
		System.out.println("}");
	}
	
	public static void main(String[] args) {
		int[] myArray = {45, 22, 18, 89, 82, 79, 15, 69, 100, 55, 48, 72, 16, 98, 57, 75, 44, 32, 21, 14, 7, 16, 49, 58, 72};
		int sumArray;
		int sumSomeArray;
		double avgArray;
		double avgSomeArray;
		int maxArray;
		int maxInRange;
		int indexOfMax;
		int indexOfMaxInRange;
		int countBelowAvg;
		int countBelowAvgInRange;
		
		sumArray = sum(myArray);
		System.out.println(sumArray);
		System.out.println();
		
		sumSomeArray = sum(myArray, 12, 18);
		System.out.println(sumSomeArray);
		System.out.println();
		
		avgArray = average(myArray);
		System.out.println(avgArray);
		System.out.println();
		
		avgSomeArray = average(myArray, 12, 18);
		System.out.println(avgSomeArray);
		System.out.println();
		
		maxArray = maxValue(myArray);
		System.out.println(maxArray);
		System.out.println();
		
		maxInRange = maxValue(myArray, 12, 18);
		System.out.println(maxInRange);
		System.out.println();
		
		indexOfMax = indexOfFirstMaxValue(myArray);
		System.out.println(indexOfMax);
		System.out.println();
		
		indexOfMaxInRange = indexOfFirstMaxValue(myArray, 12, 18);
		System.out.println(indexOfMaxInRange);
		System.out.println();
		
		countBelowAvg = numberOfBelowAverageElements(myArray);
		System.out.println(countBelowAvg);
		System.out.println();
		
		countBelowAvgInRange = numberOfBelowAverageElements(myArray, 12, 18);
		System.out.println(countBelowAvgInRange);
		System.out.println();
		
		rotateElements(myArray);
		System.out.println();
		
		rotateElements(myArray, 5);
		System.out.println();
		
		reverseArray(myArray);
		System.out.println();

			
		
		
	}
	















}

