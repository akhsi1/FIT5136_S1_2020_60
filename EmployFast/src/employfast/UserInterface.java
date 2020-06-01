/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akhsi
 */
class UserInterface {
private String usertype;
private String userpw;
private String username;

    public UserInterface() {
    }
    public void displayLogin() {
        Scanner input = new Scanner(System.in);
        EmployFastSystem efs = new EmployFastSystem();
        boolean complete = false;
        while (!complete) {
            System.out.println("Enter H to return to Home \nEnter B to go back \nEnter F to finish this Mission \nEnter L to log out \n \n");
            System.out.println("Welcome to Employ Fast! \n\n Please enter username: ");
            String inuser = input.nextLine();
            System.out.println("Enter Password: ");
            String password = input.nextLine();
            if (efs.verifyUser(inuser, password).equals("admin")){
                usertype = "admin";
                clrscr();
                displayAdminHome();
            }
            if (efs.verifyUser(inuser, password).equals("coordinator")){
                usertype = "coordinator";
                clrscr();
                displayCoordinatorHome();
                
            }
            if (efs.verifyUser(inuser, password).equals("candidate")){
                usertype = "candidate";
                clrscr();
                displayCandidateHome();
                       
            }
            
        }
    }
    
    public void displayAdminHome(){
        System.out.println("You are logged in as Administrator");
    }
    public void displayCoordinatorHome(){
        Scanner scan = new Scanner(System.in);
        System.out.println("You are logged in as Coordinator\nPress 1 to Create a Mission");
        String in = scan.nextLine();
        if (in.equals("1")){
            Coordinator c = new Coordinator(username, "1", userpw);
            c.createMission();
        }
    }
    public void displayCandidateHome(){
        System.out.println("You are logged in as Candidate");
    }

    public static void clrscr() {
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }
}
