/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

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
        efs = new EmployFastSystem();
        Scanner input = new Scanner(System.in);
        boolean complete = false;
        while (!complete) {
            clrscr();
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

    public void displayAdminHome(String userId, String userName, String userType, String userpw, EmployFastSystem efsys) {
        this.userId = userId;
        this.username = userName;
        this.userType = userType;
        this.userpw = userpw;
        this.efs = efsys;
        displayAdminHome();
    }

    public void displayAdminHome() {
        Administrator a = new Administrator(userId, username, userType, userpw);
        Coordinator c = new Coordinator();
        c.setEfs(efs);
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            clrscr();
            System.out.println("You are logged in as Administrator\nPress L to log out\n");
            if (efs.hasMissionSelected()) {
                System.out.println("Selected Mission: " + efs.getSelectedMission().getMissionName());
                efs.searchMissionCriteria();
            } else {
                System.out.println("Please begin by selecting a Mission");
            }
            if (efs.hasShuttleSelected()) {
                System.out.println("Selected Shuttle: " + efs.getSelectedShuttle().getShuttleName());
            } else if (efs.hasMissionSelected()) {
                System.out.println("Please Select a Shuttle");
            }

            if (efs.hasMissionSelected()) {
                System.out.println("\nPress 1 to View or Modify Mission");
                if (efs.hasShuttleSelected()) {
                    System.out.println("Press 2 to View or Modify Shuttle");
                    if (efs.hasSelectionCriteria()) {
                        System.out.println("Press 3 to View or Modify Selection Criteria");
                        System.out.println("Press 4 to Find N Best Candidates");
                    } else {
                        System.out.println("Press 3 to Create Selection Criteria");
                    }
                } else {
                    System.out.println("Press 2 to Select a Shuttle");
                }
            } else {
                System.out.println("\nPress 1 to Select a Mission");
            }

            String in = scan.nextLine().toUpperCase();
            if (in.equals("1")) {
                end = true;
                if (!efs.hasMissionSelected()) {
                    efs.setSelectedShuttle(null);
                    displayMissionList("choose");
                    return;
                } else {
                    String result = displayMenuChoices("View Mission", "Modify Mission");
                    if (result.equals("View Mission")) {
                        c.showOneMission(efs.getSelectedMission());
                        end = false;
                    }
                    if (result.equals("Modify Mission")) {
                        efs.setSelectedShuttle(null);
                        displayMissionList("modify");
                        return;
                    }
                }
            } else if (in.equals("2") && efs.hasMissionSelected()) {
                // if user selects 2. Select a New Shuttle
                end = true;
                if (!efs.hasShuttleSelected()) {
                    displayShuttleInfo();
                    return;
                } else if (efs.hasShuttleSelected()) {
                    String result = displayMenuChoices("View Selected Shuttle", "Choose New Shuttle");
                    if (result.equals("View Selected Shuttle")) {
                        displaySelectedShuttle(efs.getSelectedShuttle());
                        System.out.println("\nPress any key to continue...");
                        scan.nextLine();
                        end = false;
                    } else if (result.equals("Choose New Shuttle")) {
                        displayShuttleInfo();
                        return;
                    }
                }
            } else if (in.equals("3") && efs.hasShuttleSelected()) {
                // If user selects 3. Create a Selection Criteria
                end = true;
                if (!efs.hasSelectionCriteria()) {
                    displayNewSelectionCriteria();
                    return;
                } else if (efs.hasSelectionCriteria()) {
                    String result = displayMenuChoices("View Current Criteria", "Set New Criteria");
                    if (result.equals("View Current Criteria")) {
                        displayCurrentSelectionCriteria();
                        end = false;
                        System.out.println("Press anything to continue...");
                        scan.nextLine();
                    } else if (result.equals("Set New Criteria")) {
                        displayNewSelectionCriteria();
                        return;
                    }

                }
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
                        displayAdminHome();
                        return;
                    }
                }
            } else {
                System.out.println("Please enter a valid option");
            }
        }
    }

    public String displayMenuChoices(String dothis, String dothat) {
        clrscr();
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            System.out.println("Press B to go Back\n");
            System.out.println("Press 1 to " + dothis);
            System.out.println("Press 2 to " + dothat);
            String in = scan.nextLine().trim().toUpperCase();
            if (in.equals("B")) {
                if (userType.equals("admin")) {
                    displayAdminHome();
                    end = true;
                    break;
                }
                if (userType.equals("coordinator")) {
                    displayCoordinatorHome();
                    end = true;
                    break;
                }
                if (userType.equals("candidate")) {
                    displayCandidateHome();
                    end = true;
                    break;
                }
            }
            if (in.equals("1")) {
                return dothis;
            }
            if (in.equals("2")) {
                return dothat;
            } else {
                System.out.println("Please select a valid option");
                end = false;
            }
        }
        return "";
    }

    public void displayMissionList(String operation) {
        Coordinator c = new Coordinator();
        c.modifyMission(userId, username, userType, userpw, efs, operation);
    }

//    public void displayMissionList(){
//        ArrayList<Mission> missionList = new ArrayList<Mission>();
//        Coordinator c = new Coordinator();
//        ArrayList<String> missionIDs = c.readFileData("missionID");
//        for (int i = 0; i < missionIDs.size(); i ++)
//        {
//            missionList.add(c.readMission(missionIDs.get(i)));
//        }
//    }
    public void gap(int a, int b) {
        for (int i = b; i <= a; i++) {
            System.out.print(" ");
        }
    }

    public void displayNBestCandidates() {
        Scanner scan = new Scanner(System.in);
        //predefine a random mission for TESTING PURPOSES//
//        Mission mish = new Mission();
//        SelectionCriteria sc = new SelectionCriteria();
//        sc.setSelectionRangeOfAge("10-30");
//        sc.setSelectionHealthRecords("None");
//        ArrayList<String> quals = new ArrayList<String>();
//        quals.add("MIT");
//        quals.add("BDS");
//        quals.add("BE");
//        sc.setSelectionQualifications(quals);
//        mish.setSelectionCriteria(sc);
//        RequiredTitle rt = new RequiredTitle();
//        rt.setRequiredTitleCount(5);
//        rt.setRequiredTitleName("Doctor");
//        ArrayList<RequiredTitle> rtlist = new ArrayList<RequiredTitle>();
//        rtlist.add(rt);
//        mish.setMissionTitles(rtlist);
//        mish.setMissionID("35");
//        mish.setMissionName("Mission Apollo");
//        efs.setSelectedMission(mish);
        //predefine a random mission FOR TESTING PURPOSES//
        clrscr();
        if (efs.getRequiredTitleCount() == 0) {
            System.out.println("Please set Required Title Count for Mission. Press any Key to Continue...");
            scan.nextLine();
            displayAdminHome();
            return;
        }
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
        boolean end = false;
        while (!end) {
            String in = scan.nextLine();
            if (in.trim().toUpperCase().equals("Y")) {
                efs.setMissionCandidates(bestlist);
                System.out.println("Added Candidates to the Mission\n\n Press any key to return...");
                scan.nextLine();
                end = true;
                displayAdminHome();
                return;
            } else if (in.trim().toUpperCase().equals("N")) {
                end = true;
                displayAdminHome();
                return;
            }
        }
    }

    public void displayCoordinatorHome(EmployFastSystem efs) {
        this.efs = efs;
        displayCoordinatorHome();
    }

    public void displaySelectedShuttle(Shuttle s) {
        clrscr();
        System.out.println();
        System.out.print("Name: ");
        gap(25, 6);
        System.out.println(s.getShuttleName());
        System.out.print("Manufacture Year: ");
        gap(25, 18);
        System.out.println(s.getShuttleManuYear());
        System.out.print("Passenger Capacity: ");
        gap(25, 20);
        System.out.println(s.getShuttlePassengerCapacity());
        System.out.print("Fuel Capacity: ");
        gap(25, 15);
        System.out.println(s.getShuttleFuelCapacity());
        System.out.print("Cargo Capacity: ");
        gap(25, 16);
        System.out.println(s.getShuttleCargoCapacity());
        System.out.print("Travel Speed: ");
        gap(25, 14);
        System.out.println(s.getShuttleTravelSpeed());
        System.out.print("Country of Origin: ");
        gap(25, 19);
        System.out.println(s.getShuttleOriginCountry());
    }

    public void displayShuttleInfo() {
        clrscr();
        System.out.println();
        Scanner in = new Scanner(System.in);
        System.out.println("ID    Name                       Year   Passenger Capacity");
        EmployFast ef = new EmployFast();
        ArrayList<Shuttle> list = ef.getShuttleList();
        int count = 0;
        boolean finish = false;
        int i = 0;
        while (!finish) {
            if (i < list.size()) {
                System.out.print(list.get(i).getShuttleId() + " ");
                gap(5, list.get(i).getShuttleId().length());
                System.out.print(list.get(i).getShuttleName() + " ");
                gap(25, list.get(i).getShuttleName().length());
                System.out.print(list.get(i).getShuttleManuYear() + " ");
                gap(5, String.valueOf(list.get(i).getShuttleManuYear()).length());
                System.out.print(list.get(i).getShuttlePassengerCapacity());
                gap(5, list.get(i).getShuttlePassengerCapacity().length());
                System.out.println();
                i++;
                if (i % 10 == 0 || i == list.size()) {
                    boolean end = false;
                    System.out.println("\n<-- Press P for Previous Page, N for Next Page ->>");
                    System.out.println("\nPress B to go Back");
                    System.out.println("\nEnter Shuttle ID to view full information");
                    while (!end) {
                        String input = in.nextLine().trim().toUpperCase();
                        switch (input) {
                            case "N":
                                clrscr();
                                System.out.println();
                                System.out.println("ID    Name                       Year   Passenger Capacity");
                                end = true;
                                break;
                            case "P":
                                clrscr();
                                System.out.println();
                                System.out.println("ID    Name                       Year   Passenger Capacity");
                                i -= 10 + i % 10;
                                end = true;
                                break;
                            case "B":
                                displayAdminHome();
                                return;
                            default:
                                for (Shuttle sh : list) {
                                    if (sh.getShuttleId().equals(input)) {
                                        displaySelectedShuttle(sh);
                                        System.out.println("\nSelect this Shuttle? Y/N");
                                        boolean yesno = false;
                                        while (!yesno) {
                                            String userinput = in.nextLine().trim().toUpperCase();
                                            if (userinput.equals("Y")) {
                                                efs.setSelectedShuttle(sh);
                                                ef.writeToMission(efs.getSelectedShuttle().getShuttleId(), efs.getSelectedMission().getMissionID());
                                                displayAdminHome();
                                                return;
                                            } else if (userinput.equals("N")) {
                                                displayShuttleInfo();
                                                return;
                                            } else {
                                                System.out.println("Please Enter Y or N");
                                            }
                                        }
                                    }
                                    end = false;
                                }
                        }
                    }
                }
            } else {
                i -= i % 10;
            }
        }
//        System.out.println(list.get(0).getShuttleManuYear());
//        System.out.println(list.get(0).getShuttleFuelCapacity());
//        System.out.println(list.get(0).getShuttleTravelSpeed());
//        System.out.println(list.get(0).getShuttlePassengerCapacity());
//        System.out.println(list.get(0).getShuttleCargoCapacity());
//        System.out.println(list.get(0).getShuttleOriginCountry());
//        boolean end = false;
//        while (!end) {
//            String userinput = in.nextLine();
//            for (Shuttle s : list) {
//                if (userinput.equals(s.getShuttleId())) {
//                    System.out.println("name" + s.getShuttleName());
//
//                    efs.getSelectedMission().setShuttle(s);
//                    end = true;
//                }
//            }
//        }
//        while (!end) {
//            String userInput = in.nextLine();
//            if (userInput.equals("1")) {
//                int index = Integer.valueOf(userInput) - 1;
//                efs.setSelectedShuttle(list.get(0));
//                end = true;
//                return;
//            } else {
//                System.out.println("wrong input");
//            }
//        }
    }

    public void displayCoordinatorHome() {
        Coordinator c = new Coordinator(userId, username, userType, userpw);
        c.setEfs(efs);
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            clrscr();
            System.out.println("You are logged in as Coordinator\nPress L to log out\n\nPress 1 to Create a Mission\nPress 2 to Modify or View a Mission");
            String in = scan.nextLine().trim().toUpperCase();
            if (in.equals("1")) {
                end = true;
                c.createMission();
                return;
            } else if (in.equals("2")) {
                c.modifyMission(userId, username, userType, userpw, efs, "modify");
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

    public void displayCurrentSelectionCriteria() {
        clrscr();
        SelectionCriteria current = efs.getSelectedMission().getSelectionCriteria();
        System.out.println("Current Selection Criteria: ");
        System.out.print("Range of Age: ");
        gap(22, 14);
        System.out.println(current.getSelectionRangeOfAge());
        System.out.print("Health Records: ");
        gap(22, 16);
        System.out.println(current.getSelectionHealthRecords());
        System.out.print("Qualifications: ");
        gap(22, 16);
        System.out.println(current.getSelectionQualifications());
    }

    public void displayNewSelectionCriteria() {
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        efs.setSelectionMissionId();
        while (!end) {
            clrscr();
            System.out.println("1. Set range of Age\n" + "2. Set Health Records\n" + "3. Set Qualifications\n" + "Enter \"OK\" to finish criteria selection"
                    + ". Enter \"B\" to go Back");
            String in = scan.nextLine().trim().toUpperCase();
            switch (in) {
                case "1":
                    boolean ageEnd = false;
                    while (!ageEnd) {
                        clrscr();
                        System.out.println("Press B to go Back\n");
                        System.out.println("Enter Range of Age (e.g. 20-40)");
                        String userinput = scan.nextLine().trim().toUpperCase();
                        if (userinput.contains("-")) {
                            String[] s = userinput.split("-");
                            if (s.length == 2) {
                                if (isInt(s[0]) && isInt(s[1])) {
                                    int min = Integer.parseInt(s[0]);
                                    int max = Integer.parseInt(s[1]);
                                    if (min <= max) {
                                        efs.rangeOfAgeSetting(userinput);
                                        ageEnd = true;
                                        System.out.println("Range of Age Successfully added to Mission Criteria\n Press any key to continue...");
                                        scan.nextLine();
                                    }
                                }
                            }
                        } else if (userinput.equals("B")) {
                            displayNewSelectionCriteria();
                            ageEnd = true;
                            return;
                        } else {
                            System.out.println("Input format error. Press any key to try again...");
                            scan.nextLine();
                        }
                    }
                    break;
                case "2":
                    boolean healthEnd = false;
                    while (!healthEnd) {
                        clrscr();
                        System.out.println("Press B to go Back\n");
                        System.out.println("Enter a Health Record (e.g. Asthma) to prevent \ncandidates with this health problem to be selected");
                        String input = scan.nextLine().trim();
                        if (input.toUpperCase().equals("B")) {
                            healthEnd = true;
                            end = true;
                            displayNewSelectionCriteria();
                            return;
                        } else {
                            if (input.equals("") || input.toUpperCase().equals("NONE")) {
                                input = "None";
                            }
                            efs.healthSetting(input);
                            System.out.println("Successfully added Health Record to Mission Criteria");
                            System.out.println("Press any key to continue...");
                            healthEnd = true;
                            scan.nextLine();
                        }
                    }
                    break;
                case "3":
                    ArrayList<Qualification> list = new ArrayList<Qualification>();
                    list.add(new Qualification("1", "MIT"));
                    list.add(new Qualification("2", "ME"));
                    list.add(new Qualification("3", "MDS"));
                    list.add(new Qualification("4", "MBA"));
                    list.add(new Qualification("5", "BDS"));
                    list.add(new Qualification("6", "MS"));
                    list.add(new Qualification("7", "MBBS"));
                    list.add(new Qualification("8", "BE"));
                    ArrayList<String> selectedQualifications = new ArrayList<String>();
                    String qualifications = "";
                    boolean qualsEnd = false;
                    while (!qualsEnd) {
                        clrscr();
                        System.out.println("Press B to go Back\n");
                        System.out.println("1. MIT\n2. ME\n3. MDS\n4. MBA\n5. BDS\n6. MS\n7. MBBS\n8. BE");
                        System.out.println("Select a number to add the Qualification");
                        System.out.println("Currently Selected: " + selectedQualifications + " Press C to clear selections\n\nPress OK to finish");
                        String input = scan.nextLine().trim().toUpperCase();
                        for (Qualification c : list) {
                            if (input.equals(c.getQualificationId())) {
                                if (!selectedQualifications.contains(c.getQualificationName())) {
                                    selectedQualifications.add(c.getQualificationName());
                                }
                            }
                        }
                        if (input.equals("C")) {
                            selectedQualifications.clear();
                        }
                        if (input.equals("B")) {
                            boolean backEnd = false;
                            while (!backEnd) {
                                System.out.println("Confirm Back? Your selections will not be saved. Y/N");
                                String userinput = scan.nextLine();
                                if (userinput.equals("Y")) {
                                    qualsEnd = true;
                                    backEnd = true;
                                } else if (userinput.equals("N")) {
                                    qualsEnd = false;
                                    backEnd = true;
                                } else {
                                    System.out.println("Please enter Y/N");
                                    qualsEnd = false;
                                    backEnd = false;
                                }
                            }
                        }
                        if (input.equals("OK")) {
                            efs.qualificationSetting(selectedQualifications);
                            System.out.println("Successfully Added " + selectedQualifications + " to the Mission Criteria");
                            System.out.println("Press any key to continue...");
                            qualsEnd = true;
                            scan.nextLine();
                        }
                    }
                    break;
                case "OK":
                    end = true;
                    EmployFast ef = new EmployFast();
                    ef.writeSelectionCriteria(efs.getSelectedMission().getSelectionCriteria());
                    displayAdminHome();
                    break;
                case "B":
                    boolean backEnd = false;
                    while (!backEnd) {
                        System.out.println("Confirm Back? Your selections will not be saved. Y/N");
                        String userinput = scan.nextLine().trim().toUpperCase();
                        if (userinput.equals("Y")) {
                            end = true;
                            displayAdminHome();
                            return;
                        } else if (userinput.equals("N")) {
                            end = true;
                        } else {
                            System.out.println("Please enter Y/N");
                        }
                    }
                    break;
                default:
                    System.out.println("Please enter a correct option");
                    System.out.println("Press any key to continue...");
                    scan.nextLine();
                    end = false;
            }

        }
    }

    public boolean isInt(String input) {
        boolean check = true;
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            check = false;
        }
        return check;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public static EmployFastSystem getEfs() {
        return efs;
    }

    public static void setEfs(EmployFastSystem efs) {
        UserInterface.efs = efs;
    }

}
