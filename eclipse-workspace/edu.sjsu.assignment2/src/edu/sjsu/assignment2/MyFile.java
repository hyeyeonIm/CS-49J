package edu.sjsu.assignment2;
/**
 * @filename : MyFile.java
 * @author : HyeyeonIm
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; // For using Scanner

public class MyFile {
	public static void writePrimes(String file1,String file2) {
		/**
		 * @param : writePrimes
		 * @param : inputFile : open file1
		 * @exception : NumberFormatException
		 * @exception : FileNotFoundException
		 */
		File inputFile = new File(file1);
		try {
			Scanner in = new Scanner(inputFile);
			PrintWriter out = new PrintWriter(file2);
			
			while (in.hasNextLine()) {
				// scan the current line
				String input = in.nextLine();
				Scanner reader = new Scanner(input);
				reader.useDelimiter(",");
			
				// Write each word in separate lines
				while (reader.hasNext()) {
					String word = reader.next();
					try {
						int n = Integer.valueOf(word); // string to integer
						if(isPrime(n)==true) {
							out.println(n);
						}
					}
					catch(NumberFormatException e) {
						// System.out.println("NumberFormatException, Couldn't change to integer")
					}
				}
			reader.close();  // Close Scanner
			}
			in.close();   // Close Scanner
			out.close();  // Close PrintWriter
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException, Couldn't find the file");
		}

	}
	
	public static boolean isPrime(int n) { // isPrime method
		/**
		 * @param : isPrime - check the prime number
		 * @param : b - boolean
		 * @return : b - prime : true / not prime : false
		 */
		if(n == 1) {return false;}
		boolean b = true;
		for(int i=2; i<n; i++) {
			if(n%i == 0) {
				b = false;
				break;
			}
		}
		return b;
	} 	
	public static void main(String[] args) {
		/**
		 * @param : main
		 * @param : file1 : address of file1
		 * @param : file2 : address of file2
		 */
		MyFile file = new MyFile();
		String file1 = "C:\\Users\\enhye\\Desktop\\file1.txt";
        String file2 = "C:\\Users\\enhye\\Desktop\\file2.txt";
		file.writePrimes(file1,file2);
	}
}
