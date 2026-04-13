package com.mycompany.progpoepart1;  
import java.security.MessageDigest;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author katlego
 */
public class Progpoepart1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Login> user = new ArrayList<>();
    
         //User registration to create a new account
        System.out.println("Hello! Welcome to Chat-App. Please choose an option below to proceed.");
       
        while(true) {
        System.out.println("Main menu");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Choose an option");
            
        int option = scanner.nextInt(); //For user to choose option 1-3
          scanner.nextLine();
        
        //=REGISTRATION=
        switch(option){
            case 1 : {
                //For registration
                System.out.println("Enter your username: ");
                String username = scanner.nextLine();
                //To validate username:
                boolean validUsername = username.contains("_") && username.length()<=5;
                if(validUsername){
                    System.out.println("Username successfully captured.");
                }
                else{
                    System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore(_) and is no more than five characters in length.");
                    break;
                }
                System.out.println("Enter password: ");
                String password = scanner.nextLine();
                //To ensure password follows requirement:
                boolean validPassword = password.length()>=8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[^a-zA-Z0-9].*");
                if(validPassword){
                    System.out.println("Password successfully captured.");
                }
                else{
                    System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
                    break;
                }
                
                System.out.println("Enter a valid South African cellphone number: +27... ");
                String digits = scanner.nextLine();
                //To ensure that the user enters a valid South African number with +27 code using regex:
                String regex = "\\+27[6-8]\\d{8}";
                if(digits.matches(regex)) {
                    System.out.println("Cell phone number successfully added.");
                }
                else{
                    System.out.println("Cell phone number incorrectly formatted or does not contain international code. ");
                    break;
                }
                
                //To check if username exists before adding new user to the system
                boolean userExists = user.stream().anyMatch(u -> u.username.equals(username));
                if(userExists){
                    System.out.println("This username already exists; please choose another username.");
                    break;
                }
                
                //To add new user to the system:
                user.add(new Login(username, password, digits));
                System.out.println("Welcome " + username + "! You can now Log in.");
                System.out.println("Please select option 2 to Log in.");
                break;
                
            }
       
        case 2: { //=LOGIN=
           
            //For user to enter log in details :username and password
            System.out.println("Enter your username: ");
            String loginUsername = scanner.nextLine();
            System.out.println("Enter your password: ");
            String loginPassword = scanner.nextLine();
            
            /*
            To check if the details entered matches with details used in the registration
            */
            boolean loginValid = false;
            
            for (Login account : user){
                if(account.username.equals(loginUsername) && account.password.equals(loginPassword)){
                    
                    loginValid = true;
                    System.out.println("welcome " + loginUsername + " it is great to see you again!");
                break;
                }
                
            }
            if (!loginValid){
                System.out.println("Username or password incorrect, please try again.");             
            }  
            break;
        }
        
        case 3: {
            //If user chooses Exit
            System.out.println("Hope to see you again, goodbye!");
            scanner.close();
            return; }
        
        //If user choose an invalid option:
        default: System.out.println("Invalid! Please choose the correct option.");
            }
        } 
    }   
}  


     