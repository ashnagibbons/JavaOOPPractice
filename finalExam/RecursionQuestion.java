//package cmp168final;

import java.util.Scanner;
//import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionQuestion {
	
	public static void main(String[] args) {
		
		//TODO create an array of cars based on the tests (length 10, ordered)
		//use the scanner nextLine() and then parse the line for ints (possible using another scanner that scans that string) to get the ints and add them to an array/string
		//the cars created should have arrays numSeatsPerRow of exactly the length of the string as well as the order of num seats in each row, so compare by row (check that 
		//equals method does this, because if not, we have to write this in the recursive method itself as the base case
		
		int[] arr0 = new int[] {2,2};
		int[] arr1 = new int[] {2,3};
		int[] arr2 = new int[] {2,2,3};
		int[] arr3 = new int[] {2,3,3};
		int[] arr4 = new int[] {2,3,4};
		int[] arr5 = new int[] {2,4,3};
	    int[] arr6 = new int[]{1,2,3,4};
		int[] arr7 = new int[]{1,2,3,4};
		int[] arr8 = new int[]{2,2,3,4};
		int[] arr9 = new int[] {3,4,5};
		
		Car c0 = new Car(2, 4, arr0);
		Car c1 = new Car(2, 4, arr1);
		Car c2 = new Car(2, 4, arr2);
		Car c3 = new Car(2, 4, arr3);
		Car c4 = new Car(2, 4, arr4);
		Car c5 = new Car(2, 4, arr5);
		Car c6 = new Car(2, 4, arr6);
		Car c7 = new Car(2, 4, arr7);
		Car c8 = new Car(2, 4, arr8);
		Car c9 = new Car(2, 4, arr9);
		
		Car[] myCars = new Car[10];
		
		myCars[0] = c0;
		myCars[1] = c1;
		myCars[2] = c2;
		myCars[3] = c3;
		myCars[4] = c4;
		myCars[5] = c5;
		myCars[6] = c6;
		myCars[7] = c7;
		myCars[8] = c8;
		myCars[9] = c9;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String lines ="";
		try {
			lines = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	        
	    String[] strs = lines.trim().split("\\s+");
	    int[] a = new int[strs.length];
	            
	    for (int i = 0; i < strs.length; i++) {
	    a[i] = Integer.parseInt(strs[i]);
	    //System.out.println(a[i]);
	    }
	    
	    Car myCar = new Car(2, 4, a);
	    
	    System.out.println("Looking for " + myCar.toString());
	    
	    binarySearch(myCars, myCar);
	    
	    
		
		/*Scanner scnr = new Scanner(System.in);
		int myInt;
		
		String numSeatsPerRow = scnr.next();
		String mySeats = "";
		
		Scanner strScnr = new Scanner(numSeatsPerRow);
		
		while (strScnr.hasNextInt()) {
			myInt = strScnr.nextInt();
			mySeats.concat(String.valueOf(myInt));
			
		}
		
		scnr.close();
		strScnr.close();
		
		System.out.println(mySeats);*/
		
	}
	
	public static int binarySearch(Car[] cars, Car c) {
		return helpBinarySearch(cars, 0, cars.length-1 , c);
	}
	
	public static int helpBinarySearch(Car[] cars, int low, int high, Car x) {
		
		if (high >= low) {
			int mid = (low + high)/2;
			System.out.println("s=" + low + ", e=" + high + ", mid=" + mid);
			
			int count = 0;
			int min = 0;
			
			if (x.numSeatsPerRow.length < cars[mid].numSeatsPerRow.length) {
				min = x.numSeatsPerRow.length;
			}
			else {
				min = cars[mid].numSeatsPerRow.length;
			}
			
			for (int i = 0; i < min; i++) {
				if (x.numSeatsPerRow[i] != cars[mid].numSeatsPerRow[i]) {
					count++;
				}
			}
			
			if (cars[mid].compareTo(x)==0 && count==0) {
				System.out.println("FOUND at " + mid + "\n\n");
				return mid;
			}
			else if (cars[mid].compareTo(x) > 0) {
				System.out.println("go left");
				return helpBinarySearch(cars, low, mid -1, x);
				
			}
			else {
				System.out.println("go right");
				return helpBinarySearch(cars, mid+1, high,x);
			}
		}
		System.out.println("s=" + low + ", e=" + high);
		System.out.println("Not Found\n");
		return -1;
	}
	
	

}
