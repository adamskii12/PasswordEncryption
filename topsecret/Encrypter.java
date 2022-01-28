package topsecret;

/** ENCRYPTER
 *
 *  This object contains the necessary password
 *  encryption process needed in the user interface
 *  to encrypt the user's password
 * 
 *  @author adamiw
 */

public class Encrypter {
    
    protected Encrypter(){}
    
    
    //CHARACTER ENCRYPTION 
    // 
    //MODIFIES: character
    //EFFECTS: takes the character from the parameter and returns the character encrypted 
    protected char encryptCharacter (char character){
         
        int ascii = (int) character; //get the ASCII code of the character and store it in variable ascii
        boolean done=false; //when the character is within one the following ranges, this will be set to done
                    
        if (48<=ascii && ascii<=52){ //if the character is between 0-4, increase its ASCII code by 7
            ascii = ascii+7;
            done=true;
        }

        if (53<=ascii && ascii<=57 && done==false){ //if the character is between 5-9, decrease its ASCII code by 9
            ascii = ascii-9;
            done=true;
        }   
                    
        if (65<=ascii && ascii<=77 && done==false){ //if the character is between A-M, increase its ASCII code by 11
            ascii = ascii+11;
            done=true;
        }
                   
        if (78<=ascii && ascii<=90 && done==false){ //if the character is between N-Z, decrease its ASCII code by 17
            ascii = ascii-17;
            done=true;
        }
                    
        if (97<=ascii && ascii<=109 && done==false){ //if the character is between a-m, decrease its ASCII code by 8
            ascii = ascii-8;
            done=true;
        }
                    
        if (110<=ascii && ascii<=122 && done==false) //if the character is between n-z, decrease its ASCII code by 6
            ascii = ascii-6;

        character = (char) ascii; //change the encrypted ASCII code back to its character form

        return character; //return the encrypted character
    }
        
        
    //PASSWORD ENCRYPTION
    //
    //EFFECTS: Takes the password from the parameter, reverses the string, encrypts each character, then returns password encrypted 
    protected String encryptPassword(String password){
        String encryptedPassword=""; //initializes the encrypted password
                
        for (int i=0;i<password.length();i++){
            char character = password.charAt(password.length()-i-1); //stores the last character of the inputted password

            character = encryptCharacter(character); //encrypts character
                    
            encryptedPassword = encryptedPassword + character; //add the encrypted character to the encrypted password   
        }
        
        return encryptedPassword; //returns the resulting encrypted password
    }
}
