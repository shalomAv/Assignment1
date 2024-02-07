/*
 
Class: CMSC204
Instructor: Eivazi
Description: (Give a brief description for each Class)
Due: 02/06/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Kodjo Avougla
*/

public class NoDigitException extends Exception {
	
		public NoDigitException() {
			super ("The password has to be at least 6 characters long");
		}
		public NoDigitException(String message) {
			super (message);
		} 
	}