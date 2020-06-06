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
            if (isExit(inuser)) {
                complete = true;
                return;
            }
            System.out.println("Enter Password: ");
            String password = input.nextLine();
            if (isExit(password)) {
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
                    boolean login = true;
                    displayAdminHome(login);
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

    public boolean isExit(String input) {
        if (input.toUpperCase().trim().equals("E")) {
            Scanner scan = new Scanner(System.in);
            boolean end = false;
            while (!end) {
                System.out.println("Confirm Exit? (Y/N)");
                String in = scan.nextLine().trim().toUpperCase();
                if (in.equals("Y")) {
                    end = true;
                    return true;
                }
                if (in.equals("N")) {
                    end = true;
                    return false;
                }
            }
        }
        return false;
    }

    public void displayAdminHome(boolean login) {
        Administrator a = new Administrator(userId, username, userType, userpw);
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            clrscr();
            if(login){
                System.out.println("You are logged in as Administrator");
            }
            System.out.println("Press L to log out\n");
            if (efs.hasMissionSelected()) {

                System.out.println("Selected Mission: " + efs.getSelectedMission().getMissionName() + "\nPress 1 to Select new Mission\n");
                if (efs.hasShuttleSelected()) {
                    System.out.println("Selected Shuttle: " + efs.getSelectedShuttle().getShuttleName()
                            + "Press 2 to Select a New Shuttle\nPress 3 to Create a Selection Criteria\n");
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
            if (in.equals("1")) {
                end = true;

                return;
            } else if (in.equals("2") && efs.hasMissionSelected()) {
                // if user selects 2. Select a New Shuttle
                end = true;

                return;
            } else if (in.equals("3") && efs.hasShuttleSelected()) {
                // If user selects 3. Create a Selection Criteria
                end = true;
                displayCriteriaInformation();
                return;
            } else if (in.equals("4") && efs.hasSelectionCriteria()) {
                // If user selects 4. Find N Best Candidates
                end = true;
                displayNBestCandidates();
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
                        login = false;
                        displayAdminHome(login);
                        return;
                    }
                }
            } else {
                System.out.println("Please enter a valid option");
            }
        }
    }

    public void gap(int a, int b) {
        for (int i = b; i <= a; i++) {
            System.out.print(" ");
        }
    }

    public void displayNBestCandidates() {
        //predefine a random mission//
        Mission mish = new Mission();
        SelectionCriteria sc = new SelectionCriteria();
        sc.setSelectionRangeOfAge("10-30");
        sc.setSelectionHealthRecords("None");
        ArrayList<String> quals = new ArrayList<String>();
        quals.add("MIT");
        quals.add("BDS");
        quals.add("BE");
        sc.setSelectionQualifications(quals);
        mish.setSelectionCriteria(sc);
        RequiredTitle rt = new RequiredTitle();
        rt.setRequiredTitleCount(5);
        rt.setRequiredTitleName("Doctor");
        ArrayList<RequiredTitle> rtlist = new ArrayList<RequiredTitle>();
        rtlist.add(rt);
        mish.setMissionTitles(rtlist);
        efs.setSelectedMission(mish);
        //predefine a random mission//
        clrscr();
        int count = efs.getRequiredTitleCount();
        ArrayList<Candidate> bestlist = efs.getNBestCandidates();
        System.out.println("Number of candidates required for mission: " + count);
        System.out.println(bestlist.size() + " best qualified candidates: ");
        System.out.println("\nID     Name             Age    Health Records           Qualifications");
        for (Candidate c : bestlist) {
            System.out.print(c.getUserId() + " ");
            gap(5, c.getUserId().length());
            System.out.print(c.getUserName() + " ");
            gap(15, c.getUserName().length());
            System.out.print(c.getCandAge() + " ");
            gap(5, String.valueOf(c.getCandAge()).length());
            System.out.print(c.getCandidateHealthRecords() + " ");
            gap(23, c.getCandidateHealthRecords().length());
            System.out.print(c.getCandidateQualifications() + " ");
            int qualsLength = 0;
            for (String s : c.getCandidateQualifications()) {
                qualsLength = qualsLength + s.length();
            }
            gap(25, qualsLength);
            System.out.println();
        }
        System.out.println("\nAdd these candidates to the mission? Y/N");
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        boolean login = true;
        while (!end) {
            String in = scan.nextLine();
            
            if (in.trim().toUpperCase().equals("Y")) {
                efs.setMissionCandidates(bestlist);
                System.out.println("Added Candidates to the Mission\n\n Press any key to return...");
                scan.nextLine();
                end = true;
                displayAdminHome(login);
                return;
            } else if (in.trim().toUpperCase().equals("N")) {
                end = true;
                displayAdminHome(login);
                return;
            }
        }
    }

//    public void displayEscapeOptions() {
//        System.out.println("Press L to Log Out\nPress H to go Home\nPress B to go Back");
//        Scanner scan = new Scanner(System.in);
//        boolean end = false;
//        while (!end) {
//            String in = scan.nextLine();
//            switch (in){
//                case "L":
//                    displayConfirmMessage("L");
//                    break;
//                case "H":
//                    displayConfirmMessage("H");
//                    break;
//            }
//            
//        }
//    }
//    
//    public void displayConfirmMessage(String type){
//        boolean end = false;
//        Scanner scan = new Scanner(System.in);
//        if (type.equals("L")){
//            while (!end){
//                System.out.println("Confirm Logout? Y/N");
//                String s = scan.nextLine().trim().toUpperCase();
//                if (s.equals("Y")){
//                    displayLogin();
//                }
//            }
//        }
//        if (type.equals("H")){
//            while (!end){
//                System.out.println("Confirm Logout? Y/N");
//                String s = scan.nextLine().trim().toUpperCase();
//                if (s.equals("Y")){
//                    if (userType.equals("Admin")){
//                        displayAdminHome();
//                    }
//                    if (userType.equals("Coordinator")){
//                        displayCoordinatorHome();
//                    }
//                    if (userType.equals("Candidate")){
//                        displayCandidateHome();
//                    }
//                }
//            }
//        }
//    }

    public void displayCoordinatorHome(EmployFastSystem efs) {
        this.efs = efs;
        displayCoordinatorHome();
    }

    public void displayShuttleInfo() {
        System.out.println("Shuttle Information");
        EmployFast ef = new EmployFast();
        ArrayList<Shuttle> list = ef.getShuttleList();
//        System.out.println(list.get(0).getShuttleId() + ": " + list.get(0).getShuttleName());
        System.out.println("Enter shuttle ID to select the shuttle");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("ID: " + list.get(i).getShuttleId() + " Name: " + list.get(i).getShuttleName()
                    + "Manu. Year: " + list.get(i).getShuttleManuYear() + "Fuel Capacity: " + list.get(0).getShuttleFuelCapacity() + "Travel Speed: " + list.get(0).getShuttleTravelSpeed() + "Passenger Capacity: " + list.get(0).getShuttlePassengerCapacity()
                    + "Cargo Capacity" + list.get(0).getShuttleCargoCapacity() + " Country: " + list.get(i).getShuttleOriginCountry());
        }
//        System.out.println(list.get(0).getShuttleManuYear());
//        System.out.println(list.get(0).getShuttleFuelCapacity());
//        System.out.println(list.get(0).getShuttleTravelSpeed());
//        System.out.println(list.get(0).getShuttlePassengerCapacity());
//        System.out.println(list.get(0).getShuttleCargoCapacity());
//        System.out.println(list.get(0).getShuttleOriginCountry());
        Scanner in = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            String userinput = in.nextLine();
            for (Shuttle s : list) {
                if (userinput.equals(s.getShuttleId())) {
                    System.out.println("name" + s.getShuttleName());

                    efs.getSelectedMission().setShuttle(s);
                    end = true;
                }
            }
        }
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

    public void displayCriteriaInformation() {
        clrscr();
        System.out.println("1. select range of Age\n" + "2. select Health Records\n" + "3. select Qualifications\n" + "Enter \"OK\" to finish criteria selection"
                +"Enter \"B\" to back to last screen");
        Scanner scanner = new Scanner(System.in);
        boolean login = false;
        String input = scanner.nextLine().trim().toUpperCase();
        boolean finish = false;
        boolean hasAge = false;
        boolean hasHealth = false;
        boolean hasQualification = false;
        ArrayList<String> qualifications = new ArrayList<>();
        while (!finish) {
            boolean check = true;
            switch (input) {
                case ("1"):
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

                case ("2"):
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
                case ("3"):
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
                case ("OK"):
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
                    displayAdminHome(login);
                    break;
                case ("B"):
                    
                    displayAdminHome(login);
                default:
                    System.out.println("Select a valid input");
                    finish = false;
                    input = scanner.nextLine();
                    break;
            }
        }
    }
}
