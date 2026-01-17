package hw1;


import java.util.Scanner;

public class Grades {
	
	Scanner scnr = new Scanner(System.in);
	
	String allGrades;
	int currGrade;
	int count;
	int a;
	int aMinus;
	int bPlus;
	int b;
	int bMinus;
	int cPlus;
	int c;
	int cMinus;
	int d;
	int f;
	
	allGrades = scnr.nextLine();
	
	Scanner inSS = new Scanner(allGrades);
	
	currGrade = inSS.nextInt();
	
	while (currGrade >= 0) {
		count++;
		if ((currGrade <= 100) && (currGrade >= 93)) {
			a++;
		}
		else if (currGrade >= 90) {
			aMinus++;
		}
		else if (currGrade >= 87) {
			bPlus++;
		}
		else if (currGrade >= 83) {
			b++;
		}
		else if (currGrade >= 80) {
			bMinus++;
		}
		else if (currGrade >= 77) {
			cPlus++;
		}
		else if (currGrade >= 73) {
			c++;
		}
		else if (currGrade >= 70) {
			cMinus++;
		}
		else if (currGrade >= 60) {
			d++;
		}
		else {
			f++;
		}
		
		currGrade = inSS.nextInt();
	}
	
	System.out.println("Total number of grades: " + count);
	System.out.println("Number of A's  = " + a);
	System.out.println("Number of A-'s  = " + aMinus);
	System.out.println("Number of B+'s  = " + bPlus);
	System.out.println("Number of B's  = " + b);
	System.out.println("Number of B-'s  = " + bMinus);
	System.out.println("Number of C+'s  = " + cPlus);
	System.out.println("Number of C's  = " + c);
	System.out.println("Number of C-'s  = " + cMinus);
	System.out.println("Number of D's  = " + d);
	System.out.println("Number of F's  = " + f);
	
	
	

}
