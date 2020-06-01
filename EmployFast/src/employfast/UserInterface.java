/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.io.IOException;

import java.util.Scanner;

/**
 *
 * @author akhsi
 */
class UserInterface {

    private String userId;
    private String username;
    private String userType;
    private String userpw;
    private EmployFastSystem efs;

    public UserInterface() {
        efs = new EmployFastSystem();
    }

    public void displayLogin() {
        clrscr();
        efs = new EmployFastSystem();
        Scanner input = new Scanner(System.in);
        boolean complete = false;
        while (!complete) {
            System.out.println("Enter E to exit\n\n");
            System.out.println("Welcome to Employ Fast! \n\n Please enter username: ");
            String inuser = input.nextLine();
            if (inuser.toUpperCase().equals("E")) {
                complete = true;
                return;
            }
            System.out.println("Enter Password: ");
            String password = input.nextLine();
            if (password.toUpperCase().equals("E")) {
                complete = true;
                return;
            }
            // Console code only works after compiling (Doesn't work in IDE)
//            Console con = System.console();
//            char[] pwchars = con.readPassword("Please enter pw");
//            String password = String.valueOf(pwchars);
            User u = efs.verifyUser(inuser, password);
            if (u.getUserId() != "" && u.getUserName() != "" && u.getUserType() != "") {

                if (u.getUserType().equals("admin")) {
                    userType = "admin";
                    complete = true;
                    displayAdminHome();
                    return;
                }
                if (u.getUserType().equals("coordinator")) {
                    userType = "coordinator";
                    complete = true;
                    displayCoordinatorHome();
                    return;
                }
                if (u.getUserType().equals("candidate")) {
                    userType = "candidate";
                    complete = true;
                    displayCandidateHome();
                    return;
                }
            } else {
                System.out.println("Wrong username or password entered \nPress any key to try again...");
                complete=false;
                input.nextLine();

            }
        }
    }
    public void displayAdminHome() {
        Administrator a = new Administrator(userId, username, userType, userpw);
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            clrscr();
            System.out.println("You are logged in as Administrator\nPress L to log out\n");
            if (efs.hasMissionSelected()) {
                System.out.println("Selected Mission: " + efs.getSelectedMission().getMissionName() + "\nPress 1 to Select new Mission\n");
                if (efs.hasShuttleSelected()) {
                    System.out.println("Selected Shuttle: " + efs.getSelectedShuttle().getShuttleName()
                            + "\nPress 2 to Select a New Shuttle\nPress 3 to Create a Selection Criteria\n");
                    if (efs.hasSelectionCriteria()) {
                        System.out.println("Press 4 to Find N Best Candidates\n");
                    }
                } else {
                    System.out.println("Press 2 to Select a Shuttle\n");
                }
            } else {
                System.out.println("Press 1 to Select a Mission");
            }

            String in = scan.nextLine().toUpperCase();
            if (in.equals("1") && efs.hasMissionSelected()) {
                end=true;
                return;
            } else if (in.equals("2") && efs.hasShuttleSelected()) {
                end=true;
                return;
            } else if (in.equals("3") && efs.hasSelectionCriteria()) {
                end = true;
                return;
            } else if (in.equals("L") || in.equals("B")) {
                end = true;
                displayLogin();
            } else {
                System.out.println("Please enter a valid option");
            }
        }
    }

    public void displayCoordinatorHome() {
        Coordinator c = new Coordinator(userId, username, userType, userpw);
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            clrscr();
            System.out.println("You are logged in as Coordinator\nPress L to log out\n\nPress 1 to Create a Mission\nPress 2 to Modify or View a Mission");
            String in = scan.nextLine();
            if (in.equals("1")) {
                end=true;
                c.createMission();
                return;
            } else if (in.equals("2")) {
                end=true;
                c.modifyMission();
                return;
            } else if (in.equals("L") || in.equals("B")) {
                end=true;
                displayLogin();
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
