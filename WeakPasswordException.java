/*
 
Class: CMSC204
Instructor: Huseyin Aygun       
Description: (Give a brief description for each Class)
Due: 02/06/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Kodjo Avougla
*/

public class WeakPasswordException extends Exception {
	
		public WeakPasswordException() {
			super ("The password has to be at least 6 characters long");
		}
		public WeakPasswordException(String message) {
			super (message);
		} 
	}