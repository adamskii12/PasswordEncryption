package topsecret;

import java.util.Scanner;

/** USER INTERFACE
 *  
 *  This class provides a basic user interface that 
 *  can encrypt and decrypt the user's password.
 * 
 *  @author adamiw
 */

public class UI {
    
    static Scanner user = new Scanner(System.in);
    static Encrypter encrypter = new Encrypter();
    static Decrypter decrypter = new Decrypter();
    static Validator validator = new Validator();
    
    public static void main(String[] args){
        String password = ""; //initialize user's password
        int answer=2; //initialize user's answer to prompts
        boolean validPassword=false; //initialize the validity of the user's password to false
    
        while (answer==2 || !validPassword){ //run the loop until the user enters a valid password and does not want to change it
            System.out.println("\nEnter the password to be encrypted: \nMust contain:\n    "
                    + "-at least 8 characters \n    -a lower case letter\n"
                    + "    -an upper case letter\n    -a number");
            password = user.next(); //stores user's input for password into the 'password' variable
    
            if(validator.validatePassword(password)) //checks if the password is valid
                validPassword=true;
            else //if the password is invalid, the user is asked to re=enter the password
                System.out.println("\nINVALID PASSWORD. Try again.\n"); 
        
    
            if(validPassword){ //if the password is valid, they are asked for confirmation of their password
                System.out.print("\nThe password you entered is:\n\n" + password + "\n\nCorrect? \n\n1)Yes \n2)No, change it\n\n");
                answer = user.nextInt(); //stores user's answer in the 'answer' variable
            }
        }  
        password=encrypter.encryptPassword(password); //encrypts password
        
        System.out.println("\nThe password encrypted is: \n\n"+ password);
        
        System.out.println("\nDecrypt password?\n\n 1)Yes\n 2)No, end program\n\n");
        answer=user.nextInt();
                
        if(answer==1) //if the user would like to decrypt the password to show it will return their unencrypted password
            System.out.println("The password decrypted is:\n\n"+decrypter.decryptPassword(password)); 
    }
}
