package topsecret;

/** VALIDATOR
 *
 * This object contains the password validation function needed
 * in the user interface to validate the inputted password
 * 
 * @author adamiw
 */

public class Validator {
    
    protected Validator(){}
    
    protected boolean validatePassword(String password){
        boolean result=false; //default return answer is false (i.e. not a valid password)
        boolean lowerCase=false; //to check for lower case letters
        boolean upperCase=false; //to check for upper case letters
        boolean number=false; //to check for numbers
    
        if (password.length()>= 8){ //make sure password is at least 8 characters
            for(int i=0; i<password.length();i++){
                int ascii = (int)password.charAt(i); //get ascii code of character
                
                if(48 <= ascii && ascii <= 57)number=true; 
                if(65 <= ascii && ascii <= 90)upperCase=true;
                if(97 <= ascii && ascii <= 122)lowerCase=true;   
            }
            if(number & upperCase & lowerCase) //if the password contains a lower case, upper case and a number, then result is true
                result=true;
        }
        return result;
        }
    } 
