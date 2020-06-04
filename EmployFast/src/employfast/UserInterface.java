/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.io.IOException;
import java.util.ArrayList;

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
    public static EmployFastSystem efs;

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
                complete = false;
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

                end = true;
                return;
            } else if (in.equals("2") && efs.hasShuttleSelected()) {
                end = true;
                return;
            } else if (in.equals("3") && efs.hasSelectionCriteria()) {
                end = true;
                return;
            } else if (in.equals("L") || in.equals("B")) {
                boolean lo = false;
                while (!lo) {
                    System.out.println("Confirm Logout? (Y/N)");
                    String s = scan.nextLine().trim().toUpperCase();
                    if (s.equals("Y")) {
                        lo = true;
                        displayLogin();
                        return;
                    } else if (s.equals("N")) {
                        lo = false;
                        displayAdminHome();
                        return;
                    }
                }
            } else {
                System.out.println("Please enter a valid option");
            }
        }
    }

    public void displayCoordinatorHome(EmployFastSystem efs) {
        this.efs = efs;
        displayCoordinatorHome();
    }

    public void displayShuttleInfo() {
        System.out.println("Shuttle Information");
        EmployFast ef = new EmployFast();
        ArrayList<Shuttle> list = ef.getShuttleList();
        System.out.println(list.get(0).getShuttleId() + "\n");
        System.out.println(list.get(0).getShuttleName());
        System.out.println("Press 1 to selected the first shuttle");
        Scanner in = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            String userInput = in.nextLine();
            if (userInput.equals("1")) {
                int index = Integer.valueOf(userInput) - 1;
                efs.setSelectedShuttle(list.get(0));
                end = true;
                return;
            } else {
                System.out.println("wrong input");
            }
        }
    }

    public void displayCoordinatorHome() {
        Coordinator c = new Coordinator(userId, username, userType, userpw);
        c.setEfs(efs);
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            clrscr();
            System.out.println("You are logged in as Coordinator\nPress L to log out\n\nPress 1 to Create a Mission\nPress 2 to Modify or View a Mission");
            String in = scan.nextLine();
            if (in.equals("1")) {
                end = true;
                c.createMission();
                return;
            } else if (in.equals("2")) {
                end = true;
                c.modifyMission();
                return;
            } else if (in.equals("L") || in.equals("B")) {
                boolean lo = false;
                while (!lo) {
                    System.out.println("Confirm Logout? (Y/N)");
                    String s = scan.nextLine().trim().toUpperCase();
                    if (s.equals("Y")) {
                        lo = true;
                        displayLogin();
                        return;
                    } else if (s.equals("N")) {
                        lo = false;
                        displayCoordinatorHome();
                        return;
                    }
                }
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

    public void getCriteriaInformation() {
        System.out.println("1. select range of Age\n" + "2. select Health Records\n" + "3. select Qualifications\n" + "Enter \"OK\" to finish criteria selection");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        Boolean finish = false;
        Boolean hasAge = false;
        Boolean hasHealth = false;
        Boolean hasQualification = false;
        ArrayList<String> qualifications = new ArrayList<>();
        while (finish = false) {
            boolean check = true;
            switch (input) {
                case "1":
                    System.out.println("Sample input \"20-40\"");
                    String rangeOfAge = scanner.nextLine().trim();
                    if (rangeOfAge.split("-").length == 2) {
                        String bothAge = rangeOfAge.split("-")[0] + rangeOfAge.split("-")[1];

                        for (int i = 0; i < bothAge.length(); i++) {
                            if (bothAge.charAt(i) < 48 || bothAge.charAt(i) > 57) {
                                check = false;

                            }
                        }

                    } else {
                        check = false;
                    }
                    if (check) {
                        efs.rangeOfAgeSetting(rangeOfAge);
                        hasAge = true;
                    } else {
                        System.out.println("Please enter a valid context.");
                    }
                    break;

                case "2":
                    System.out.println("health rank 1-5");
                    String healthRank = scanner.nextLine().trim();
                    if (healthRank.length() == 1) {
                        if (healthRank.charAt(0) < 49 || healthRank.charAt(0) > 53) {
                            check = false;
                        }
                    } else {
                        check = false;
                    }
                    if (check) {
                        efs.healthSetting(healthRank);
                        hasHealth = true;
                    } else {
                        System.out.println("Please enter a valid context.");
                    }
                    break;
                case "3":

                    System.out.println("Qualification List:\n" + "1.MIT 2.BE 3.ME 4.MBS 5.MBBS 6.BDS 7.MS\n" + "Please choose qualification in the list and input id.");
                    String qualification = scanner.nextLine().trim();
                    if (qualification.length() == 1) {
                        if (qualification.charAt(0) < 49 || qualification.charAt(0) > 55) {
                            check = false;
                        }
                    } else {
                        check = false;
                    }
                    if (check) {
                        for (int j = 49; j < 56; j++) {
                            for (int i = 0; i < qualification.length(); i++) {
                                if (qualification.charAt(i) == j) {
                                    qualifications.add(String.valueOf(qualification.charAt(i)));
                                    break;
                                }
                            }
                        }

                        efs.qualificationSetting(qualifications);
                        hasQualification = true;
                    } else {
                        System.out.println("Please enter a valid context.");
                    }
                    break;
                case "OK":
                    if (!hasAge) {
                        efs.rangeOfAgeSetting("none");
                    }
                    if (!hasHealth) {
                        efs.healthSetting("0");
                    }
                    if (!hasQualification) {
                        qualifications.add("none");
                        efs.qualificationSetting(qualifications);
                    }
                    finish = true;
            }
        }
    }
}
