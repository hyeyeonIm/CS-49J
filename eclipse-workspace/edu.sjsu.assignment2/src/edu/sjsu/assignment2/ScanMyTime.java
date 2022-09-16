/**
 * @filename : ScanMyTime.java
 * @author : HyeyeonIm (hyeyeon.im@sjsu.edu)
 */

package edu.sjsu.assignment2;

import java.lang.NumberFormatException;
import java.util.Scanner; // For using Scanner


public class ScanMyTime {
	
	public static void main(String[] args) {
		/**
		 * @filename : main
		 * @param : f - first time (string -> integer)
		 * @param : s - second time (string -> integer)
		 * @exception : NumberFormatException
		 * @exception : Out of range (length is 4)
		 * @exception : 0 < hour < 24, 0 < minute < 60
		 */
		int f = 0; // Setting the initial value to prevent errors
		int s = 0;
		
		Scanner scanner = new Scanner(System.in);  // call scanner method
		
		while(true) {
			try {
				System.out.println("Please enter the first time(hhmm): ");
				String first=scanner.nextLine(); // read integer, first time
				
				// hhmm format's length is 4
				// hour is bigger than 0, smaller than 24
				// minute is bigger than 0, smaller than 60
				int f1 = Integer.valueOf(first); // test integer
				if (first.length()!=4 || f1<0 || f1/100>24 || f1%100 >60 ) {
					System.out.println("Invalid input! Program terminated!");
					continue; // go to first
				}
				else { // if f1 is satisfy all conditions
					f = Integer.valueOf(first);  // String to Integer
				}
			}
			// NumberFormatException : if format is not integer hhmm, then it can't change the integer (ex. 3.241)
			catch(NumberFormatException e) {
				System.out.println("Invalid input! Program terminated!");
				scanner.next(); // throw away the token
			}
			try {
				System.out.println("Please enter the second time(hhmm): ");
				String second=scanner.nextLine(); // read integer, first time
				int s1 = Integer.valueOf(second); // test integer
				if (second.length()!=4 || s1<0 || s1/100>24 || s1%100 >60 ) {
					System.out.println("Invalid input! Program terminated!");
					continue; // go to first
				}
				else {
					s = Integer.valueOf(second);  // String to Integer
				}
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid input! Program terminated!");
				scanner.next(); // throw away the token
			}
			printTimeDifference(f,s);
			break;
		}
		scanner.close();
	}	

	static void printTimeDifference(int f, int s) {
		/**
		 * @param : printTimeDifference : print the difference time between first, second time
		 * @return : String Type TimeDifference - if first time is bigger than second time, s_hour += 24
		 */
		
		// given
		int f_hour = f/100;    // make hour by divide (quotient)
		int f_min = f%100;     // make minute by divide (remainder)
		   
		int s_hour = s/100;
		int s_min = s%100;
		   
		int r_hour=0;  // result hour
		int r_min=0;   // result minute
		
		
		// when
		if (f_hour > s_hour || (f_hour == s_hour && f_min>s_min)){
			s_hour += 24;  // if f_hour is bigger than s_hour, s_hour += 24
			if (f_min>s_min) {
				   r_min = 60 + s_min-f_min;
				   r_hour = s_hour - f_hour-1;
			   }
			else {
				   r_min = s_min-f_min;
				   r_hour = s_hour - f_hour;
			   }
		   }
		else { // h_hour <= s_hour
			if (f_min>s_min) {
				r_min = 60 + s_min-f_min;
				r_hour = s_hour - f_hour-1;
				}
			else {
				r_min = s_min-f_min;
				r_hour = s_hour - f_hour;
				}
		}
		
		// then
		System.out.println(r_hour + " hour(s) " + r_min + " minute(s)");
	}
}
