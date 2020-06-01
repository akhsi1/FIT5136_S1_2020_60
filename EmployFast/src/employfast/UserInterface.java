/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.io.Console;
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
        clrscr();
        Scanner input = new Scanner(System.in);
        EmployFastSystem efs = new EmployFastSystem();
        boolean complete = false;
        while (!complete) {
            System.out.println("Enter E to exit\n\n");
            System.out.println("Welcome to Employ Fast! \n\n Please enter username: ");
            String inuser = input.nextLine();
            System.out.println("Enter Password: ");
            String password = input.nextLine();
            // Console code only works after compiling (Doesn't work in IDE)
//            Console con = System.console();
//            char[] pwchars = con.readPassword("Please enter pw");
//            String password = String.valueOf(pwchars);
            if (efs.verifyUser(inuser, password).equals("admin")) {
                usertype = "admin";
                complete = true;
                displayAdminHome();
                return;
            }
            if (efs.verifyUser(inuser, password).equals("coordinator")) {
                usertype = "coordinator";
                complete = true;
                displayCoordinatorHome();
                return;
            }
            if (efs.verifyUser(inuser, password).equals("candidate")) {
                usertype = "candidate";
                complete = true;
                displayCandidateHome();
                return;
            }

        }
    }

    public void displayAdminHome() {
        Administrator a = new Administrator(username, "1", userpw);
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            clrscr();
            System.out.println("You are logged in as Administrator\nPress 1 to Select a Shuttle\nPress 2 to Create Selection Criteria\nPress 3 to Find N Best Candidates");
            String in = scan.nextLine();
            if (in.equals("1")) {
                return;
            } else if (in.equals("2")) {
                return;
            } else if (in.equals("3")){
                return;
            }
            else {
                System.out.println("Please enter a valid option");
            }
        }
    }

    public void displayCoordinatorHome() {
        Coordinator c = new Coordinator(username, "1", userpw);
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            clrscr();
            System.out.println("You are logged in as Coordinator\nPress 1 to Create a Mission\nPress 2 to Modify or View a Mission");
            String in = scan.nextLine();
            if (in.equals("1")) {
                c.createMission();
                return;
            } else if (in.equals("2")) {
                c.modifyMission();
                return;
            } else {
                System.out.println("Please enter a valid option");
            }
        }
    }
    public void displayCandidateHome() {
        clrscr();
        System.out.println("You are logged in as Candidate\n\n Candidate features not yet implemented. \n\nPress any key to log out...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        displayLogin();
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
