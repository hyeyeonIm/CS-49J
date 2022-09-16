package edu.sjsu.assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class printTimeDifferenceTest {
	int f = 1210;
	int s = 0120;
	
	@Test
	void testPrintTimeDifference() {
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
