/**
 * 
 * @author Class: CMSC204
Instructor: 
Description: (Give a brief description for each Class)
Due: 02/06/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Kodjo Avougla
 *
 */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class PasswordCheckerUtility {

	public PasswordCheckerUtility() {}

	/**
	 * this method checks if the passwords are the same, and t
	 * throws an exception if they are not
	 * @param password
	 * @param password
	 * @throws UnmatchedException
	 */
	
	public static void comparePassword(String password,String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException("Passwords do not match");
		}
	}
	/** this method checks if the passwords are the same
     * and returns false if they are not the same
     * 
     * @param password
     * @param password
     * @return
     */
	public static boolean comparePasswordWithReturn(String password,String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	 /**
     * this method checks if the password is at least 
     * 6 characters or higher
     * if not it throws and exception
     * @param password
     * @return
     * @throws LengthException
     */
	public static boolean isValidLength(String password)throws LengthException{
		 if((password.length()< 6)) {
			 throw new LengthException("Password must be at least 6 characters long");	 
		 }
			 return true;
	}
	/**
     * this method checks if the password has an uppercase
     * character and throws an exception if it does not
     * @param password
     * @return
     * @throws NoUpperAlphaException
     */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		for(int i=0;i<=password.length();i++) {
			if(Character.isUpperCase(password.charAt(i))) {
			return true;}
		}
		throw new NoUpperAlphaException("Password must contain an uppercase alpha");
	}
	/**
     * this method checks if the password has 
     * a lowercase character if so it returns true
     * if not it throws an exception
     * @param password
     * @return
     * @throws NoLowerAlphaException
     */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		for(int i=0;i<=password.length();i++) {
			if(Character.isLowerCase(password.charAt(i))) {
			return true;}
		}
		throw new NoLowerAlphaException("Password must contain a lowercase alpha");
	}
	/**
     * this method checks if the password contains 
     * a digit if so then it returns true
     * if not it throws an exception
  	 *	
     * @param password
     * @return
     * @throws NoDigitException
     */
	public static boolean hasDigit(String password) throws NoDigitException{
		for(int i=0;i<=password.length();i++) {
			if(Character.isDigit(password.charAt(i))) {
			return true;}
		}
		throw new NoDigitException("Password must contain a digit");
	}
	/**
     * This method checks if there are 3 characters in a row that are
     * the same, if so then they should throw an exception
     * if not it returns true
     * @param password
     * @return
     * @throws InvalidSequenceException
     */
	public static boolean NoSameCharInSequence(String password)throws InvalidSequenceException{
		for (int i=0;i<=password.length();i++) {
			char currentPassword= password.charAt(i);
			if(currentPassword == password.charAt(i+1)&& currentPassword==password.charAt(i+2))
				throw new InvalidSequenceException("Password should not contain more than two identical characters in sequence");
		}
		return false;
		
	}
	/**
     * this method checks if the password contains a special 
     * character and throws an exception if it does not
     * it returns true if the password contains a specialChar
     * @param password
     * @return
     * @throws NoSpecialCharacterException
     */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
        if(matcher.matches()) {
            throw new NoSpecialCharacterException();
        }
        return true; }
    /**
     * this method checks a variety of situations of the password
     * if they fail a test case then they throw the respective 
     * exception, if they pass every test case then the method return true
     * 
     * @param password
     * @return
     * @throws LengthException
     * @throws NoUpperAlphaException
     * @throws NoLowerAlphaException
     * @throws NoDigitException
     * @throws NoSpecialCharacterException
     * @throws InvalidSequenceException
     * @throws WeakPasswordException
     */
    public static boolean isValidPassword(String password)
            throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
            NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        	
        isValidLength(password);
        hasUpperAlpha(password);
        hasLowerAlpha(password);
        hasDigit(password);
        hasSpecialChar(password);
        NoSameCharInSequence(password);
        return true;
}
   
/**
 * this method checks if the password contains between 6 and nine 
 * characters if so it returns true
 * if not it returns false
 * @param password
 * @return
 */
    public static boolean hasBetweenSixandNineChars(String password) {
        if(password.length()>=6 && password.length()<=9) {
            return true;
        }
        return false; 
    }
    /**
     * this method checks if the password is valid,it doesn't throw any exception,
     * and if it is between 6 and 9 characters
     * if so then the method throws a weak password exception
     * if the password doens't throw an exception then it is sufficient 
     * and the method returns true
     * @param password
     * @return
     * @throws WeakPasswordException
     */
    public static boolean isWeakPassword(String password) throws WeakPasswordException{    	
    	try {
    		if(isValidPassword(password)) {
    			if(hasBetweenSixandNineChars(password)) {
    				throw new WeakPasswordException();
    			} else {
    				return false;
    			}
    		} else {
    			return false;
    		}
    	} catch(WeakPasswordException e) {
    		throw new WeakPasswordException();
    	} catch(Exception e) {
    		return false;
    	}
    }
    /**
     * this method returns an arrayList in which contains invalid passwords +
     * the exception message that they produce 
     * the error messages that these 
     * @param passwords
     * @return
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> incorrectPassword = new ArrayList<>(); 
        for(int i =0; i<passwords.size(); i++){
            try{
                isValidPassword(passwords.get(i));
            }
            catch (Exception e) {
                incorrectPassword.add(passwords.get(i) +" " + e.getMessage());
            }
           
        }
        return incorrectPassword;
    }
}


