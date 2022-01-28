package topsecret;

/** DECRYPTER
 *
 *  This object contains the necessary password
 *  decryption process needed in the user interface
 *  to decrypt the user's password
 * 
 *  @author adamiw
 */

public class Decrypter {
    
    protected Decrypter(){}
    
    //CHARACTER DECRYPTION 
    //
    //MODIFIES: character
    //EFFECTS: takes the encrypted character from the parameter and returns the character decrypted
    protected char decryptCharacter (char character){
        
        int ascii = (int) character; //get the ASCII code of the character and store it in variable ascii
        boolean done=false; //when the character is within the following ranges, this is set to done
                    
            
        if (55<=ascii && ascii<=59){ //if the ASCII code of the character is between 55-59, it was 0-4 pre-encryption, so decrease its ASCII code by 7
            ascii = ascii-7;
            done=true;
        }
                
        if (44<=ascii && ascii<=48 && done==false){ //if the ASCII code of the character is between 44-48, it was 5-9 pre-encryption, so increase its ASCII code by 9
            ascii = ascii+9;
            done=true;
        }   
                      
        if (76<=ascii && ascii<88 && done==false){ //if the ASCII code of the character is between 76-88, it was A-M pre-encryption, so decrease its ASCII code by 11
            ascii = ascii-11;
            done=true;
        }
                    
        if (61<=ascii && ascii<=73 && done==false){ //if the ASCII code of the character is between 61-73, it was N-Z pre-encryption, so increase its ASCII code by 17
            ascii = ascii+17;
            done=true;
        }
                    
        if (89<=ascii && ascii<=101 && done==false){ //if the ASCII code of the character is between 89-101, it was a-m pre-encryption, so increase its ASCII code by 8
            ascii = ascii+8;
            done=true;
        }
                    
        if (104<=ascii && ascii<=116 && done==false) //if the ASCII code of the character is between 104-116, it was n-z pre-encryption, so increase its ASCII code by 6
            ascii = ascii+6;
                
        character = (char) ascii; //change the decrypted ASCII code back to its character form

        return character; //return the decrypted character
        }
    
    //PASSWORD DECRYPTION 
    //
    //EFFECTS: takes encrypted password from the parameter, reverses the string, decrypts each character,
    //returns password decrypted
    protected String decryptPassword(String password){
        String decryptedPassword=""; //initializes our decrypted password
                
        for (int i=0;i<password.length();i++){
            char character = password.charAt(password.length()-i-1); //stores the last character of the encrypted password
 
            character = decryptCharacter(character); //decrypts character
                    
            decryptedPassword = decryptedPassword + character; //add the decrypted character to the decrypted password   
        }         
        
        return decryptedPassword; //returns password decrypted
    }
        
        
}
