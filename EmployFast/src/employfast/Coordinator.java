/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author akhsi
 */
public class Coordinator extends User {

    public Coordinator() {
        super();
    }

    public Coordinator(String userId, String userName, String userType, String password) {
        super(userId, userName, userType, password);
    }

    public void createMission() {
        Mission mission = new Mission();
        Scanner input = new Scanner(System.in);
        boolean complete = false;
        boolean back = false;
        do {
            System.out.println("Enter H to return to Home \nEnter B to go back \nEnter F to finish this Mission \nEnter L to log out \n \n");
            System.out.println("1. Mission ID \n 2. Mission name \n 3. Mission description \n 4. Country of origin \n 5. Countries allowed \n 6. Coordinator’s name \n  7. Coordinator’contact information \n"
                    + "8. Job(s) \n 9. Employment requirements \n 10.Cargo requirements \n 11.Launch date \n 12.Location of the destination \n 13.Duration of the mission \n 14.Status of the mission \n"
                    + "\n Please press number to choose which attribute you want to change or \"Enter\" to finish");
            String in = input.nextLine();
            in.toUpperCase();
            switch (in) {
                case "1":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Mission ID");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionID(in);
                    }
                    break;
                case "2":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Mission name");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionName(in);
                    }
                    break;
                case "3":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Mission description");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionDesc(in);
                    }
                    break;
                case "4":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Country of origin");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionCountryOrigin(in);
                    }
                    break;
                case "5":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Countries allowed");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionCountriesAllowed(in);
                    }
                    break;
                case "6":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input  Coordinator’s name");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionCoordinatorName(in);
                    }
                    break;
                case "7":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Coordinator’contact information");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionCoordinatorContact(in);
                    }
                    break;
                case "8":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Job Name");
                    String jobName = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        System.out.println("Please input Job Description");
                        String jobDescription = input.nextLine();
                        complete = backChoose(in.toUpperCase())[0];
                        back = backChoose(in.toUpperCase())[1];
                        if (!complete && !back) {
                            mission.getMissionJobs().add(new Job(jobName, jobDescription));
                        }
                    }

                    break;
                case "9":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Employment requirement title name");
                    String requiredTitleName = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        System.out.println("Please input number of employees for the Employment requirement title");
                        String requiredTitleCount = input.nextLine();
                        complete = backChoose(in.toUpperCase())[0];
                        back = backChoose(in.toUpperCase())[1];
                        if (!complete && !back) {
                            mission.getMissionTitles().add(new RequiredTitle(requiredTitleName, Integer.parseInt(requiredTitleCount)));
                        }
                    }
                    break;
                case "10":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please choose type of cargo requirements \n 1.For  the journey \n 2.For the mission \n 3.For other missions");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        switch (in) {
                            case "1":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("You choose cargo requirements for the journey \n Please input cargo ID");
                                String cargoID = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    System.out.println("You choose cargo requirements for the journey \n Please input cargo name");
                                    String cargoName = input.nextLine();
                                    complete = backChoose(in.toUpperCase())[0];
                                    back = backChoose(in.toUpperCase())[1];
                                    if (!complete && !back) {
                                        System.out.println("You choose cargo requirements for the journey \n Please input the availbel number of this cargo");
                                        String cargoQuantityAvail = input.nextLine();
                                        complete = backChoose(in.toUpperCase())[0];
                                        back = backChoose(in.toUpperCase())[1];
                                        if (!complete && !back) {
                                            System.out.println("You choose cargo requirements for the journey \n Please input the required number of this cargo");
                                            String cargoQuantityReq = input.nextLine();
                                            complete = backChoose(in.toUpperCase())[0];
                                            back = backChoose(in.toUpperCase())[1];
                                            if (!complete && !back) {
                                                mission.getMissionCargoForJourney().add(new Cargo(cargoID, cargoName, Integer.parseInt(cargoQuantityAvail), Integer.parseInt(cargoQuantityReq)));
                                            }
                                        }
                                    }
                                }
                                break;
                            case "2":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("You choose cargo requirements for the mission \n Please input cargo ID");
                                cargoID = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    System.out.println("You choose cargo requirements for the mission \n Please input cargo name");
                                    String cargoName = input.nextLine();
                                    complete = backChoose(in.toUpperCase())[0];
                                    back = backChoose(in.toUpperCase())[1];
                                    if (!complete && !back) {
                                        System.out.println("You choose cargo requirements for the mission \n Please input the availbel number of this cargo");
                                        String cargoQuantityAvail = input.nextLine();
                                        complete = backChoose(in.toUpperCase())[0];
                                        back = backChoose(in.toUpperCase())[1];
                                        if (!complete && !back) {
                                            System.out.println("You choose cargo requirements for the mission \n Please input the required number of this cargo");
                                            String cargoQuantityReq = input.nextLine();
                                            complete = backChoose(in.toUpperCase())[0];
                                            back = backChoose(in.toUpperCase())[1];
                                            if (!complete && !back) {
                                                mission.getMissionCargoForMission().add(new Cargo(cargoID, cargoName, Integer.parseInt(cargoQuantityAvail), Integer.parseInt(cargoQuantityReq)));
                                            }
                                        }
                                    }
                                }
                                break;
                            case "3":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("You choose cargo requirements for other missions \n Please input cargo ID");
                                cargoID = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    System.out.println("You choose cargo requirements for other missions \n Please input cargo name");
                                    String cargoName = input.nextLine();
                                    complete = backChoose(in.toUpperCase())[0];
                                    back = backChoose(in.toUpperCase())[1];
                                    if (!complete && !back) {
                                        System.out.println("You choose cargo requirements for other missions \n Please input the availbel number of this cargo");
                                        String cargoQuantityAvail = input.nextLine();
                                        complete = backChoose(in.toUpperCase())[0];
                                        back = backChoose(in.toUpperCase())[1];
                                        if (!complete && !back) {
                                            System.out.println("You choose cargo requirements for other missions \n Please input the required number of this cargo");
                                            String cargoQuantityReq = input.nextLine();
                                            complete = backChoose(in.toUpperCase())[0];
                                            back = backChoose(in.toUpperCase())[1];
                                            if (!complete && !back) {
                                                mission.getMissionCargoForOtherMissions().add(new Cargo(cargoID, cargoName, Integer.parseInt(cargoQuantityAvail), Integer.parseInt(cargoQuantityReq)));
                                            }
                                        }
                                    }
                                }
                                break;
                            default:
                                System.out.println("Please input valid character or number");
                                break;
                        }
                    }
                    break;
                case "11":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Launch date");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionLaunchDate(in);
                    }
                    break;
                case "12":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Location of the destination");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionDestinationLocation(in);
                    }
                    break;
                case "13":

                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Duration of the mission (Months)");
                    do {
                        in = input.nextLine();
                    } while(!in.matches("[0-9]+"))
                    ;
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        mission.setMissionDurationMonths(Integer.parseInt(in));
                    }

                    break;
                case "14":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Status of the mission \n a. Planning phase (selected by default) \n b. Departed Earth \n c. Landed on Mars \n"
                            + "d. Mission in progress \n e. Returned to Earth \n f. Mission completed");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase())[0];
                    back = backChoose(in.toUpperCase())[1];
                    if (!complete && !back) {
                        if (in.equals("")) {
                            mission.setMissionStatus("a. Planning phase");
                        } else {
                            mission.setMissionStatus(in);
                        }
                    }
                    break;
                case "H":
                    clrscr();
                    System.out.println("Are you sure to return to HomePage? Y(yes)/N(no)");
                    in = input.nextLine();
                    if (in.toUpperCase().equals("Y")) {
                        complete = true;
                    }
                    break;
                case "B":
                    clrscr();
                    break;
                case "L":
                    clrscr();
                    System.out.println("Are are sure to logout? Y(yes)/N(no)");
                    in = input.nextLine();
                    if (in.toUpperCase().equals("Y")) {
                        complete = true;
                    }
                    break;
                case "F":
                    clrscr();
                    System.out.println("Finish this creating Mission activity? Y(yes)/N(no)");
                    in = input.nextLine();
                    if (in.toUpperCase().equals("Y")) {
                        complete = true;
                    }
                    break;
                default:
                    System.out.println("Please input valid character or number");
                    break;
            }
        } while (!complete);
        storeMission(mission);
    }

    //For read mission. if one attribute has mutilple values,eg job,the file name(database) should with Mission ID.
    public void viewMission() {
        ArrayList<String> missionID = readFileData("missionID");
        ArrayList<String> missionName = readFileData("missionName");
        ArrayList<String> missionDesc = readFileData("missionDesc");
        ArrayList<String> missionCountryOrigin = readFileData("missionCountryOrigin");
        ArrayList<String> missionCountriesAllowed = readFileData("missionCountriesAllowed");
        ArrayList<String> missionCoordinatorName = readFileData("missionCoordinatorName");
        ArrayList<String> missionCoordinatorContact = readFileData("missionCoordinatorContact");
        ArrayList<String> jobName = readFileData("jobName" + missionID);
        ArrayList<String> jobDescription = readFileData("jobDescription" + missionID);
        ArrayList<String> requiredTitleName = readFileData("requiredTitleName" + missionID);
        ArrayList<String> requiredTitleCount = readFileData("requiredTitleCount" + missionID);
        ArrayList<String> cargoIDJ = readFileData("cargoIDForJourney" + missionID);
        ArrayList<String> cargoNameJ = readFileData("cargoNameForJourney" + missionID);
        ArrayList<String> cargoQuantityAvailJ = readFileData("cargoQuantityAvailForJourney" + missionID);
        ArrayList<String> cargoQuantityReqJ = readFileData("cargoQuantityReqForJourney" + missionID);
        ArrayList<String> cargoIDM = readFileData("cargoIDForMission" + missionID);
        ArrayList<String> cargoNameM = readFileData(" cargoNameForMission" + missionID);
        ArrayList<String> cargoQuantityAvailM = readFileData("cargoQuantityAvailForMission" + missionID);
        ArrayList<String> cargoQuantityReqM = readFileData("cargoQuantityReqForMission" + missionID);
        ArrayList<String> cargoIDO = readFileData("cargoIDForOtherMissions" + missionID);
        ArrayList<String> cargoNameO = readFileData("cargoNameForOtherMissions" + missionID);
        ArrayList<String> cargoQuantityAvailO = readFileData("cargoQuantityAvailForOtherMissions" + missionID);
        ArrayList<String> cargoQuantityReqO = readFileData("cargoQuantityReqForOtherMissions" + missionID);
        ArrayList<String> missionLaunchDate = readFileData("missionLaunchDate");
        ArrayList<String> missionDestinationLocation = readFileData("missionDestinationLocation");
        ArrayList<String> missionDurationMonths = readFileData("missionDurationMonths");
        ArrayList<String> missionStatus = readFileData("missionStatus");
        String job = "";
        String Titles = "";
        String CargoForJourney = "";
        String CargoForMission = "";
        String CargoForOtherMissions = "";
        for (int i = 0; i < jobName.size(); i++) {
            job = "job name :  " + jobName.get(i) + "job description:  " + jobDescription.get(i) + "\n";
        }
        for (int i = 0; i < requiredTitleName.size(); i++) {
            Titles = "title name:  " + requiredTitleName.get(i) + "title count number:  " + requiredTitleCount.get(i) + "\n";
        }
        for (int i = 0; i < cargoIDJ.size(); i++) {
            CargoForJourney = "cargo ID for journey:  " + cargoIDJ.get(i) + "cargo name for journey:  " + cargoNameJ.get(i) + "cargo quantity available for journey:  "
                    + cargoQuantityAvailJ.get(i) + "cargo quantity required for journey:  " + cargoQuantityReqJ.get(i) + "\n";
        }
        for (int i = 0; i < cargoIDM.size(); i++) {
            CargoForMission = "cargo ID for mission:  " + cargoIDM.get(i) + "cargo name for mission:  " + cargoNameM.get(i) + "cargo quantity available for mission:  "
                    + cargoQuantityAvailM.get(i) + "cargo quantity required for mission:  " + cargoQuantityReqM.get(i) + "\n";
        }
        for (int i = 0; i < cargoIDO.size(); i++) {
            CargoForOtherMissions = "cargo ID for other missions:  " + cargoIDO.get(i) + "cargo name for other missions:  " + cargoNameO.get(i) + "cargo quantity available for other missions:  "
                    + cargoQuantityAvailO.get(i) + "cargo quantity required for other missions:  " + cargoQuantityReqO.get(i) + "\n";
        }
        for (int i = 0; i < missionID.size(); i++) {
            System.out.println("Mission ID :  " + missionID.get(i));
            System.out.println("Mission Name:  " + missionName.get(i));
            System.out.println("Mission Description :  " + missionDesc.get(i));
            System.out.println("Mission Country of origin :  " + missionCountryOrigin.get(i));
            System.out.println("Mission Countries allowed :  " + missionCountriesAllowed.get(i));
            System.out.println("Mission coordinator's name :  " + missionCoordinatorName.get(i));
            System.out.println("Mission coordinator's contact:  " + missionCoordinatorContact.get(i));
            System.out.println("Mission Job(s) :  \n" + job);
            System.out.println("Employment requirements :  \n" + Titles);
            System.out.println("Cargo requirements For the journey :  \n" + CargoForJourney);
            System.out.println("Cargo requirements For the mission :  \n" + CargoForMission);
            System.out.println("Cargo requirements For other missions :  \n" + CargoForOtherMissions);
            System.out.println("Mission Launch date :  " + missionLaunchDate.get(i));
            System.out.println("Mission Location (coordinates or address) of the destination :  " + missionDestinationLocation.get(i));
            System.out.println("Mission Duration of the mission :  " + missionDurationMonths.get(i));
            System.out.println("Mission Status of the mission :  " + missionStatus.get(i));
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public void modifyMission() {
        Scanner input = new Scanner(System.in);
        boolean complete = false;
        boolean back = false;
        Mission mission = new Mission();
        int index = 0;
        do {
            viewMission();
            System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
            System.out.println("Please input the Mission ID which you want to change");
            String in = input.nextLine();
            complete = backChoose(in.toUpperCase())[0];
            back = backChoose(in.toUpperCase())[1];
            if (!complete && !back) {
                boolean find = false;
                ArrayList<String> missionID = readFileData("missionID");
                for (String s : missionID) {
                    if (s.equals(in)) {
                        index = missionID.indexOf(s);
                        find = true;
                    }
                }
                if (find) {
                    mission = readMission(missionID.get(index));
                    do {
                        clrscr();
                        System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                        System.out.println("1. Mission ID \n 2. Mission name \n 3. Mission description \n 4. Country of origin \n 5. Countries allowed \n 6. Coordinator’s name \n  7. Coordinator’contact information \n"
                                + "8. Job(s) \n 9. Employment requirements \n 10.Cargo requirements \n 11.Launch date \n 12.Location of the destination \n 13.Duration of the mission \n 14.Status of the mission \n"
                                + "\n Please enter number to choose which attribute you want to change or \"Enter\" to finish");
                        in = input.nextLine();
                        in.toUpperCase();
                        switch (in) {
                            case "1":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Mission ID:  " + mission.getMissionID());
                                System.out.println("Please input Mission ID");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    mission.setMissionID(in);
                                }
                                break;
                            case "2":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Mission name:  " + mission.getMissionName());
                                System.out.println("Please input Mission name");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    mission.setMissionName(in);
                                }
                                break;
                            case "3":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Mission description:  " + mission.getMissionDesc());
                                System.out.println("Please input Mission description");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    mission.setMissionDesc(in);
                                }
                                break;
                            case "4":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Country of origin:  " + mission.getMissionCountryOrigin());
                                System.out.println("Please input Country of origin");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    mission.setMissionCountryOrigin(in);
                                }
                                break;
                            case "5":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Countries allowed:  " + mission.getMissionCountriesAllowed());
                                System.out.println("Please input Countries allowed");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    mission.setMissionCountriesAllowed(in);
                                }
                                break;
                            case "6":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Coordinator’s name:  " + mission.getMissionCoordinatorName());
                                System.out.println("Please input  Coordinator’s name");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    mission.setMissionCoordinatorName(in);
                                }
                                break;
                            case "7":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Coordinator’contact information:  " + mission.getMissionCoordinatorContact());
                                System.out.println("Please input Coordinator’contact information");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    mission.setMissionCoordinatorContact(in);
                                }
                                break;
                            case "8":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original job names as list: ");
                                for (int i = 0; i < mission.getMissionJobs().size(); i++) {
                                    int s = i + 1;
                                    System.out.println(s + ".  " + mission.getMissionJobs().get(i).getJobName() + ": " + mission.getMissionJobs().get(i).getJobDescription());
                                }
                                System.out.println("Please choose number to change(delete) or add a new job name(input add)");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    if (in.toUpperCase().equals("ADD")) {
                                        System.out.println("Please input Job Name");
                                        String jobName = input.nextLine();
                                        complete = backChoose(in.toUpperCase())[0];
                                        back = backChoose(in.toUpperCase())[1];
                                        if (!complete && !back) {
                                            System.out.println("Please input Job Description");
                                            String jobDescription = input.nextLine();
                                            complete = backChoose(in.toUpperCase())[0];
                                            back = backChoose(in.toUpperCase())[1];
                                            if (!complete && !back) {
                                                mission.getMissionJobs().add(new Job(jobName, jobDescription));
                                            }
                                        }
                                    } else if (isInt(in) && Integer.parseInt(in) <= mission.getMissionJobs().size()) {
                                        int jobIndex = Integer.parseInt(in) - 1;
                                        System.out.println("Please choose 1. Job name 2. Job description to change");
                                        in = input.nextLine();
                                        complete = backChoose(in.toUpperCase())[0];
                                        back = backChoose(in.toUpperCase())[1];
                                        if (!complete && !back) {
                                            switch (in) {
                                                case "1":
                                                    System.out.println("Please input the modified value for job name, if you want to delete, please enter nothing");
                                                    in = input.nextLine();
                                                    complete = backChoose(in.toUpperCase())[0];
                                                    back = backChoose(in.toUpperCase())[1];
                                                    if (!complete && !back) {
                                                        if (in.equals("")) {
                                                            mission.getMissionJobs().remove(jobIndex);
                                                        } else {
                                                            mission.getMissionJobs().get(jobIndex).setJobName(in);
                                                        }
                                                        System.out.println("Success");
                                                    }
                                                    break;
                                                case "2":
                                                    System.out.println("Please input the modified value for job description, if you want to delete, please enter nothing");
                                                    in = input.nextLine();
                                                    complete = backChoose(in.toUpperCase())[0];
                                                    back = backChoose(in.toUpperCase())[1];
                                                    if (!complete && !back) {
                                                        mission.getMissionJobs().get(jobIndex).setJobDescription(in);
                                                        System.out.println("Success");
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Please input 1 or 2");
                                                    break;
                                            }
                                        }
                                    }

                                }
                                break;

                            case "9":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original employment requirements as list: ");
                                for (int i = 0; i < mission.getMissionTitles().size(); i++) {
                                    int s = i + 1;
                                    System.out.println(s + ".  " + mission.getMissionTitles().get(i).getRequiredTitleName() + ": " + mission.getMissionTitles().get(i).getRequiredTitleCount());
                                }
                                System.out.println("Please choose number to change(delete) or add a new employment requirement(input add)");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    if (in.toUpperCase().equals("ADD")) {

                                        System.out.println("Please input Employment requirement title name");
                                        String requiredTitleName = input.nextLine();
                                        complete = backChoose(in.toUpperCase())[0];
                                        back = backChoose(in.toUpperCase())[1];
                                        if (!complete && !back) {
                                            System.out.println("Please input number of employees for the Employment requirement title");
                                            String requiredTitleCount = input.nextLine();
                                            complete = backChoose(in.toUpperCase())[0];
                                            back = backChoose(in.toUpperCase())[1];
                                            if (!complete && !back) {
                                                mission.getMissionTitles().add(new RequiredTitle(requiredTitleName, Integer.parseInt(requiredTitleCount)));
                                            }
                                        }
                                    } else if (isInt(in) && Integer.parseInt(in) <= mission.getMissionTitles().size()) {
                                        int titleIndex = Integer.parseInt(in) - 1;
                                        System.out.println("Please choose 1. Title name 2. Title count number to change");
                                        in = input.nextLine();
                                        complete = backChoose(in.toUpperCase())[0];
                                        back = backChoose(in.toUpperCase())[1];
                                        if (!complete && !back) {
                                            switch (in) {
                                                case "1":
                                                    System.out.println("Please input the modified value for Title name, if you want to delete, please enter nothing");
                                                    in = input.nextLine();
                                                    complete = backChoose(in.toUpperCase())[0];
                                                    back = backChoose(in.toUpperCase())[1];
                                                    if (!complete && !back) {
                                                        if (in.equals("")) {
                                                            mission.getMissionTitles().remove(titleIndex);
                                                        } else {
                                                            mission.getMissionTitles().get(titleIndex).setRequiredTitleName(in);
                                                        }
                                                        System.out.println("Success");
                                                    }
                                                    break;
                                                case "2":
                                                    System.out.println("Please input the modified value for Title count number, please enter a number equal or greater than 0");
                                                    in = input.nextLine();
                                                    complete = backChoose(in.toUpperCase())[0];
                                                    back = backChoose(in.toUpperCase())[1];
                                                    if (!complete && !back) {
                                                        if (isInt(in)) {
                                                            mission.getMissionTitles().get(titleIndex).setRequiredTitleCount(Integer.parseInt(in));
                                                            System.out.println("Success");
                                                        } else {
                                                            System.out.println("please enter a number equal or greater than 0");
                                                        }
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Please input 1 or 2");
                                                    break;
                                            }
                                        }
                                    }
                                }
                                break;
                            case "10":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Please choose type of cargo requirements \n 1.For  the journey \n 2.For the mission \n 3.For other missions");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    switch (in) {
                                        case "1":
                                            clrscr();
                                            System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                            System.out.println("You choose cargo requirements for the journey. Original Cargo requirements for the journey as list: ");
                                            for (int i = 0; i < mission.getMissionCargoForJourney().size(); i++) {
                                                int s = i + 1;
                                                System.out.println(s + ".  cargoID:  " + mission.getMissionCargoForJourney().get(i).getCargoID() + "  cargoName: " + mission.getMissionCargoForJourney().get(i).getCargoName()
                                                        + "  cargo avaible quantity: " + mission.getMissionCargoForJourney().get(i).getCargoQuantityAvail() + "  cargo required quantity:  " + mission.getMissionCargoForJourney().get(i));
                                            }
                                            System.out.println("Please choose number to change(delete) or add a new cargo requirements for the journey(input add)");
                                            in = input.nextLine();
                                            complete = backChoose(in.toUpperCase())[0];
                                            back = backChoose(in.toUpperCase())[1];
                                            if (!complete && !back) {
                                                if (in.toUpperCase().equals("ADD")) {

                                                    System.out.println("You choose cargo requirements for the journey \n Please input cargo ID");
                                                    String cargoID = input.nextLine();
                                                    complete = backChoose(in.toUpperCase())[0];
                                                    back = backChoose(in.toUpperCase())[1];
                                                    if (!complete && !back) {
                                                        System.out.println("You choose cargo requirements for the journey \n Please input cargo name");
                                                        String cargoName = input.nextLine();
                                                        complete = backChoose(in.toUpperCase())[0];
                                                        back = backChoose(in.toUpperCase())[1];
                                                        if (!complete && !back) {
                                                            System.out.println("You choose cargo requirements for the journey \n Please input the availbel number of this cargo");
                                                            String cargoQuantityAvail = input.nextLine();
                                                            complete = backChoose(in.toUpperCase())[0];
                                                            back = backChoose(in.toUpperCase())[1];
                                                            if (!complete && !back) {
                                                                System.out.println("You choose cargo requirements for the journey \n Please input the required number of this cargo");
                                                                String cargoQuantityReq = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    mission.getMissionCargoForJourney().add(new Cargo(cargoID, cargoName, Integer.parseInt(cargoQuantityAvail), Integer.parseInt(cargoQuantityReq)));
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else if (isInt(in) && Integer.parseInt(in) <= mission.getMissionCargoForJourney().size()) {
                                                    int cargoJIndex = Integer.parseInt(in) - 1;
                                                    System.out.println("Please choose 1. cargo ID 2. cargo Name 3. cargo avaible quantity number 4. cargo require quantity number");
                                                    in = input.nextLine();
                                                    complete = backChoose(in.toUpperCase())[0];
                                                    back = backChoose(in.toUpperCase())[1];
                                                    if (!complete && !back) {
                                                        switch (in) {
                                                            case "1":
                                                                System.out.println("Please input the modified value for cargo ID, if you want to delete, please enter nothing");
                                                                in = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    if (in.equals("")) {
                                                                        mission.getMissionCargoForJourney().remove(cargoJIndex);
                                                                    } else {
                                                                        mission.getMissionCargoForJourney().get(cargoJIndex).setCargoID(in);
                                                                    }
                                                                    System.out.println("Success");
                                                                }
                                                                break;
                                                            case "2":
                                                                System.out.println("Please input the modified value for cargo Name, if you want to delete, please enter nothing");
                                                                in = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    mission.getMissionCargoForJourney().get(cargoJIndex).setCargoName(in);
                                                                    System.out.println("Success");
                                                                }
                                                                break;
                                                            case "3":
                                                                System.out.println("Please input the modified value for cargo avaible quantity number, please enter a number equal or greater than 0");
                                                                in = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    if (isInt(in)) {
                                                                        mission.getMissionCargoForJourney().get(cargoJIndex).setCargoQuantityAvail(Integer.parseInt(in));
                                                                        System.out.println("Success");
                                                                    } else {
                                                                        System.out.println("please enter a number equal or greater than 0");
                                                                    }
                                                                }
                                                                break;
                                                            case "4":
                                                                System.out.println("Please input the modified value for cargo required quantity number, please enter a number equal or greater than 0");
                                                                in = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    if (isInt(in)) {
                                                                        mission.getMissionCargoForJourney().get(cargoJIndex).setCargoQuantityReq(Integer.parseInt(in));
                                                                        System.out.println("Success");
                                                                    } else {
                                                                        System.out.println("please enter a number equal or greater than 0");
                                                                    }
                                                                }
                                                                break;
                                                            default:
                                                                System.out.println("Please input 1 , 2 ,3 or 4");
                                                                break;
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        case "2":
                                            clrscr();
                                            System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                            System.out.println("You choose cargo requirements for the Mission. Original Cargo requirements for the mission as list: ");
                                            for (int i = 0; i < mission.getMissionCargoForMission().size(); i++) {
                                                int s = i + 1;
                                                System.out.println(s + ".  cargoID:  " + mission.getMissionCargoForMission().get(i).getCargoID() + "  cargoName: " + mission.getMissionCargoForMission().get(i).getCargoName()
                                                        + "  cargo avaible quantity: " + mission.getMissionCargoForMission().get(i).getCargoQuantityAvail() + "  cargo required quantity:  " + mission.getMissionCargoForMission().get(i));
                                            }
                                            System.out.println("Please choose number to change(delete) or add a new cargo requirements for the Mission(input add)");
                                            in = input.nextLine();
                                            complete = backChoose(in.toUpperCase())[0];
                                            back = backChoose(in.toUpperCase())[1];
                                            if (!complete && !back) {
                                                if (in.toUpperCase().equals("ADD")) {
                                                    System.out.println("You choose cargo requirements for the mission \n Please input cargo ID");
                                                    String cargoID = input.nextLine();
                                                    complete = backChoose(in.toUpperCase())[0];
                                                    back = backChoose(in.toUpperCase())[1];
                                                    if (!complete && !back) {
                                                        System.out.println("You choose cargo requirements for the mission \n Please input cargo name");
                                                        String cargoName = input.nextLine();
                                                        complete = backChoose(in.toUpperCase())[0];
                                                        back = backChoose(in.toUpperCase())[1];
                                                        if (!complete && !back) {
                                                            System.out.println("You choose cargo requirements for the mission \n Please input the availbel number of this cargo");
                                                            String cargoQuantityAvail = input.nextLine();
                                                            complete = backChoose(in.toUpperCase())[0];
                                                            back = backChoose(in.toUpperCase())[1];
                                                            if (!complete && !back) {
                                                                System.out.println("You choose cargo requirements for the mission \n Please input the required number of this cargo");
                                                                String cargoQuantityReq = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    mission.getMissionCargoForMission().add(new Cargo(cargoID, cargoName, Integer.parseInt(cargoQuantityAvail), Integer.parseInt(cargoQuantityReq)));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (isInt(in) && Integer.parseInt(in) <= mission.getMissionCargoForMission().size()) {
                                                int cargoMIndex = Integer.parseInt(in) - 1;
                                                System.out.println("Please choose 1. cargo ID 2. cargo Name 3. cargo avaible quantity number 4. cargo require quantity number");
                                                in = input.nextLine();
                                                complete = backChoose(in.toUpperCase())[0];
                                                back = backChoose(in.toUpperCase())[1];
                                                if (!complete && !back) {
                                                    switch (in) {
                                                        case "1":
                                                            System.out.println("Please input the modified value for cargo ID, if you want to delete, please enter nothing");
                                                            in = input.nextLine();
                                                            complete = backChoose(in.toUpperCase())[0];
                                                            back = backChoose(in.toUpperCase())[1];
                                                            if (!complete && !back) {
                                                                if (in.equals("")) {
                                                                    mission.getMissionCargoForMission().remove(cargoMIndex);
                                                                } else {
                                                                    mission.getMissionCargoForMission().get(cargoMIndex).setCargoID(in);
                                                                }
                                                                System.out.println("Success");
                                                            }
                                                            break;
                                                        case "2":
                                                            System.out.println("Please input the modified value for cargo Name, if you want to delete, please enter nothing");
                                                            in = input.nextLine();
                                                            complete = backChoose(in.toUpperCase())[0];
                                                            back = backChoose(in.toUpperCase())[1];
                                                            if (!complete && !back) {
                                                                mission.getMissionCargoForMission().get(cargoMIndex).setCargoName(in);
                                                                System.out.println("Success");
                                                            }
                                                            break;
                                                        case "3":
                                                            System.out.println("Please input the modified value for cargo avaible quantity number, please enter a number equal or greater than 0");
                                                            in = input.nextLine();
                                                            complete = backChoose(in.toUpperCase())[0];
                                                            back = backChoose(in.toUpperCase())[1];
                                                            if (!complete && !back) {
                                                                if (isInt(in)) {
                                                                    mission.getMissionCargoForMission().get(cargoMIndex).setCargoQuantityAvail(Integer.parseInt(in));
                                                                    System.out.println("Success");
                                                                } else {
                                                                    System.out.println("please enter a number equal or greater than 0");
                                                                }
                                                            }
                                                            break;
                                                        case "4":
                                                            System.out.println("Please input the modified value for cargo required quantity number, please enter a number equal or greater than 0");
                                                            in = input.nextLine();
                                                            complete = backChoose(in.toUpperCase())[0];
                                                            back = backChoose(in.toUpperCase())[1];
                                                            if (!complete && !back) {
                                                                if (isInt(in)) {
                                                                    mission.getMissionCargoForMission().get(cargoMIndex).setCargoQuantityReq(Integer.parseInt(in));
                                                                    System.out.println("Success");
                                                                } else {
                                                                    System.out.println("please enter a number equal or greater than 0");
                                                                }
                                                            }
                                                            break;
                                                        default:
                                                            System.out.println("Please input 1 , 2 ,3 or 4");
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                        case "3":
                                            clrscr();
                                            System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                            System.out.println("You choose cargo requirements for other missions. Original Cargo requirements for other missions as list: ");
                                            for (int i = 0; i < mission.getMissionCargoForOtherMissions().size(); i++) {
                                                int s = i + 1;
                                                System.out.println(s + ".  cargoID:  " + mission.getMissionCargoForOtherMissions().get(i).getCargoID() + "  cargoName: " + mission.getMissionCargoForOtherMissions().get(i).getCargoName()
                                                        + "  cargo avaible quantity: " + mission.getMissionCargoForOtherMissions().get(i).getCargoQuantityAvail() + "  cargo required quantity:  " + mission.getMissionCargoForOtherMissions().get(i));
                                            }
                                            System.out.println("Please choose number to change(delete) or add a new cargo requirements for other missions(input add)");
                                            in = input.nextLine();
                                            complete = backChoose(in.toUpperCase())[0];
                                            back = backChoose(in.toUpperCase())[1];
                                            if (!complete && !back) {
                                                if (in.toUpperCase().equals("ADD")) {
                                                    System.out.println("You choose cargo requirements for other missions \n Please input cargo ID");
                                                    String cargoID = input.nextLine();
                                                    complete = backChoose(in.toUpperCase())[0];
                                                    back = backChoose(in.toUpperCase())[1];
                                                    if (!complete && !back) {
                                                        System.out.println("You choose cargo requirements for other missions \n Please input cargo name");
                                                        String cargoName = input.nextLine();
                                                        complete = backChoose(in.toUpperCase())[0];
                                                        back = backChoose(in.toUpperCase())[1];
                                                        if (!complete && !back) {
                                                            System.out.println("You choose cargo requirements for other missions \n Please input the availbel number of this cargo");
                                                            String cargoQuantityAvail = input.nextLine();
                                                            complete = backChoose(in.toUpperCase())[0];
                                                            back = backChoose(in.toUpperCase())[1];
                                                            if (!complete && !back) {
                                                                System.out.println("You choose cargo requirements for other missions \n Please input the required number of this cargo");
                                                                String cargoQuantityReq = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    mission.getMissionCargoForOtherMissions().add(new Cargo(cargoID, cargoName, Integer.parseInt(cargoQuantityAvail), Integer.parseInt(cargoQuantityReq)));
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else if (isInt(in) && Integer.parseInt(in) <= mission.getMissionCargoForOtherMissions().size()) {
                                                    int cargoOIndex = Integer.parseInt(in) - 1;
                                                    System.out.println("Please choose 1. cargo ID 2. cargo Name 3. cargo avaible quantity number 4. cargo require quantity number");
                                                    in = input.nextLine();
                                                    complete = backChoose(in.toUpperCase())[0];
                                                    back = backChoose(in.toUpperCase())[1];
                                                    if (!complete && !back) {
                                                        switch (in) {
                                                            case "1":
                                                                System.out.println("Please input the modified value for cargo ID, if you want to delete, please enter nothing");
                                                                in = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    if (in.equals("")) {
                                                                        mission.getMissionCargoForOtherMissions().remove(cargoOIndex);
                                                                    } else {
                                                                        mission.getMissionCargoForOtherMissions().get(cargoOIndex).setCargoID(in);
                                                                    }
                                                                    System.out.println("Success");
                                                                }
                                                                break;
                                                            case "2":
                                                                System.out.println("Please input the modified value for cargo Name, if you want to delete, please enter nothing");
                                                                in = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    mission.getMissionCargoForOtherMissions().get(cargoOIndex).setCargoName(in);
                                                                    System.out.println("Success");
                                                                }
                                                                break;
                                                            case "3":
                                                                System.out.println("Please input the modified value for cargo avaible quantity number, please enter a number equal or greater than 0");
                                                                in = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    if (isInt(in)) {
                                                                        mission.getMissionCargoForOtherMissions().get(cargoOIndex).setCargoQuantityAvail(Integer.parseInt(in));
                                                                        System.out.println("Success");
                                                                    } else {
                                                                        System.out.println("please enter a number equal or greater than 0");
                                                                    }
                                                                }
                                                                break;
                                                            case "4":
                                                                System.out.println("Please input the modified value for cargo required quantity number, please enter a number equal or greater than 0");
                                                                in = input.nextLine();
                                                                complete = backChoose(in.toUpperCase())[0];
                                                                back = backChoose(in.toUpperCase())[1];
                                                                if (!complete && !back) {
                                                                    if (isInt(in)) {
                                                                        mission.getMissionCargoForOtherMissions().get(cargoOIndex).setCargoQuantityReq(Integer.parseInt(in));
                                                                        System.out.println("Success");
                                                                    } else {
                                                                        System.out.println("please enter a number equal or greater than 0");
                                                                    }
                                                                }
                                                                break;
                                                            default:
                                                                System.out.println("Please input 1 , 2 ,3 or 4");
                                                                break;
                                                        }
                                                    }
                                                }
                                            }

                                            break;
                                        default:
                                            System.out.println("Please input valid character or number");
                                            break;
                                    }
                                }
                                break;

                            case "11":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Missiont Launch date: " + mission.getMissionLaunchDate());
                                System.out.println("Please input new Missiont Launch date");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    mission.setMissionLaunchDate(in);
                                }
                                break;
                            case "12":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Location of the destination: " + mission.getMissionDestinationLocation());
                                System.out.println("Please input Location of the destination");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    mission.setMissionDestinationLocation(in);
                                }
                                break;
                            case "13":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Duration of the mission: " + mission.getMissionDurationMonths());
                                System.out.println("Please input Duration of the mission");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    if (isInt(in)) {
                                        mission.setMissionDurationMonths(Integer.parseInt(in));
                                    } else {
                                        System.out.println("please enter a number equal or greater than 0");
                                    }
                                }
                                break;
                            case "14":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("Original Status of the mission: " + mission.getMissionStatus());
                                System.out.println("Please input Status of the mission \n a. Planning phase (selected by default) \n b. Departed Earth \n c. Landed on Mars \n"
                                        + "d. Mission in progress \n e. Returned to Earth \n f. Mission completed");
                                in = input.nextLine();
                                complete = backChoose(in.toUpperCase())[0];
                                back = backChoose(in.toUpperCase())[1];
                                if (!complete && !back) {
                                    if (in.equals("")) {
                                        mission.setMissionStatus("a. Planning phase");
                                    } else {
                                        mission.setMissionStatus(in);
                                    }
                                }
                                break;
                            case "H":
                                clrscr();
                                System.out.println("Are you sure to return to HomePage? Y(yes)/N(no)");
                                in = input.nextLine();
                                if (in.toUpperCase().equals("Y")) {
                                    complete = true;
                                    back = true;
                                }
                                break;
                            case "B":
                                clrscr();
                                System.out.println("Are you sure to go back? Y(yes)/N(no)");
                                in = input.nextLine();
                                if (in.toUpperCase().equals("Y")) {
                                    back = true;
                                }
                                break;
                            case "L":
                                clrscr();
                                System.out.println("Are are sure to logout? Y(yes)/N(no)");
                                in = input.nextLine();
                                if (in.toUpperCase().equals("Y")) {
                                    back = true;
                                    complete = true;
                                }
                                break;
                            case "F":
                                clrscr();
                                System.out.println("Finish this creating Mission activity? Y(yes)/N(no)");
                                in = input.nextLine();
                                if (in.toUpperCase().equals("Y")) {
                                    back = true;
                                    complete = true;
                                }
                                break;
                            default:
                                System.out.println("Please input valid character or number");
                                break;
                        }

                    } while (!back);
                } else {
                    System.out.println("Please input the valid Mission ID");
                }
            }
        } while (!complete);
        storeModifiedMission(mission, index);
    } //This method just write one line data each time since everytime mission attribute will add one new line

    public void writeFileData(String fileName, String FileData) {
        try {
            File file = new File(fileName);
            FileOutputStream fos = null;
            if (!file.exists()) {
                file.createNewFile();
                fos = new FileOutputStream(file);
            } else {
                fos = new FileOutputStream(file, true);
            }
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write(FileData);
            osw.write("\r\n");
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Mission readMission(String missionID) {
        Mission mission = new Mission();
        ArrayList<String> missionIDs = readFileData("missionID");
        int index = 0;
        for (String s : missionIDs) {
            if (s.equals(missionID)) {
                index = missionIDs.indexOf(s);
            }
        }
        mission.setMissionID(missionID);
        mission.setMissionName(readFileData("missionName").get(index));
        mission.setMissionDesc(readFileData("missionDesc").get(index));
        mission.setMissionCountryOrigin(readFileData("missionCountryOrigin").get(index));
        mission.setMissionCountriesAllowed(readFileData("missionCountriesAllowed").get(index));
        mission.setMissionCoordinatorName(readFileData("missionCoordinatorName").get(index));
        mission.setMissionCoordinatorContact(readFileData("missionCoordinatorContact").get(index));
        for (int i = 0; i < readFileData("jobName" + missionID).size(); i++) {
            mission.getMissionJobs().add(new Job(readFileData("jobName" + missionID).get(i), readFileData("jobDescription" + missionID).get(i)));
        }
        for (int i = 0; i < readFileData("requiredTitleName" + missionID).size(); i++) {
            mission.getMissionTitles().add(new RequiredTitle(readFileData("requiredTitleName" + missionID).get(i), Integer.parseInt(readFileData("requiredTitleCount" + missionID).get(i))));
        }
        for (int i = 0; i < readFileData("cargoIDForJourney" + missionID).size(); i++) {
            mission.getMissionCargoForJourney().add(new Cargo(readFileData("cargoIDForJourney" + missionID).get(i), readFileData("cargoNameForJourney" + missionID).get(i), Integer.parseInt(readFileData("cargoQuantityAvailForJourney" + missionID).get(i)), Integer.parseInt(readFileData("cargoQuantityReqForJourney" + missionID).get(i))));
        }
        for (int i = 0; i < readFileData("cargoIDForMission" + missionID).size(); i++) {
            mission.getMissionCargoForJourney().add(new Cargo(readFileData("cargoIDForMission" + missionID).get(i), readFileData("cargoNameForMission" + missionID).get(i), Integer.parseInt(readFileData("cargoQuantityAvailForMission" + missionID).get(i)), Integer.parseInt(readFileData("cargoQuantityReqForMission" + missionID).get(i))));
        }
        for (int i = 0; i < readFileData("cargoIDForOtherMissions" + missionID).size(); i++) {
            mission.getMissionCargoForJourney().add(new Cargo(readFileData("cargoIDForOtherMissions" + missionID).get(i), readFileData("cargoNameForOtherMissions" + missionID).get(i), Integer.parseInt(readFileData("cargoQuantityAvailForOtherMissions" + missionID).get(i)), Integer.parseInt(readFileData("cargoQuantityReqForOtherMissions" + missionID).get(i))));
        }
        mission.setMissionLaunchDate(readFileData("missionLaunchDate").get(index));
        mission.setMissionDestinationLocation(readFileData("missionDestinationLocation").get(index));
        mission.setMissionDurationMonths(Integer.parseInt(readFileData("missionDurationMonths").get(index)));
        mission.setMissionStatus(readFileData("missionStatus").get(index));
        return mission;
    }

    //this function will add a new mission to response database.
    public void storeMission(Mission mission) {
        String missionID = mission.getMissionID();
        writeFileData("missionID", mission.getMissionID());
        writeFileData("missionName", mission.getMissionName());
        writeFileData("missionDesc", mission.getMissionDesc());
        writeFileData("missionCountryOrigin", mission.getMissionCountryOrigin());
        writeFileData("missionCountriesAllowed", mission.getMissionCountriesAllowed());
        writeFileData("missionCoordinatorName", mission.getMissionCoordinatorName());
        writeFileData("missionCoordinatorContact", mission.getMissionCoordinatorContact());
        for (int i = 0; i < mission.getMissionJobs().size(); i++) {
            writeFileData("jobName" + missionID, mission.getMissionJobs().get(i).getJobName());
            writeFileData("jobDescription" + missionID, mission.getMissionJobs().get(i).getJobDescription());
        }
        for (int i = 0; i < mission.getMissionTitles().size(); i++) {
            writeFileData("requiredTitleName" + missionID, mission.getMissionTitles().get(i).getRequiredTitleName());
            writeFileData("requiredTitleCount" + missionID, Integer.toString(mission.getMissionTitles().get(i).getRequiredTitleCount()));
        }
        for (int i = 0; i < mission.getMissionCargoForJourney().size(); i++) {
            writeFileData("cargoIDForJourney" + missionID, mission.getMissionCargoForJourney().get(i).getCargoID());
            writeFileData("cargoNameForJourney" + missionID, mission.getMissionCargoForJourney().get(i).getCargoName());
            writeFileData("cargoQuantityAvailForJourney" + missionID, Integer.toString(mission.getMissionCargoForJourney().get(i).getCargoQuantityAvail()));
            writeFileData("cargoQuantityReqForJourney" + missionID, Integer.toString(mission.getMissionCargoForJourney().get(i).getCargoQuantityReq()));
        }
        for (int i = 0; i < mission.getMissionCargoForMission().size(); i++) {
            writeFileData("cargoIDForMission" + missionID, mission.getMissionCargoForMission().get(i).getCargoID());
            writeFileData("cargoNameForMission" + missionID, mission.getMissionCargoForMission().get(i).getCargoName());
            writeFileData("cargoQuantityAvailForMission" + missionID, Integer.toString(mission.getMissionCargoForMission().get(i).getCargoQuantityAvail()));
            writeFileData("cargoQuantityReqForMission" + missionID, Integer.toString(mission.getMissionCargoForMission().get(i).getCargoQuantityReq()));
        }
        for (int i = 0; i < mission.getMissionCargoForOtherMissions().size(); i++) {
            writeFileData("cargoIDForOtherMissions" + missionID, mission.getMissionCargoForOtherMissions().get(i).getCargoID());
            writeFileData("cargoNameForOtherMissions" + missionID, mission.getMissionCargoForOtherMissions().get(i).getCargoName());
            writeFileData("cargoQuantityAvailForOtherMissions" + missionID, Integer.toString(mission.getMissionCargoForOtherMissions().get(i).getCargoQuantityAvail()));
            writeFileData("cargoQuantityReqForOtherMissions" + missionID, Integer.toString(mission.getMissionCargoForOtherMissions().get(i).getCargoQuantityReq()));
        }
        writeFileData("missionLaunchDate", mission.getMissionLaunchDate());
        writeFileData("missionDestinationLocation", mission.getMissionDestinationLocation());
        writeFileData("missionDurationMonths", Integer.toString(mission.getMissionDurationMonths()));
        writeFileData("missionStatus", mission.getMissionStatus());
    }

    //this function will change something to response database.
    public void storeModifiedMission(Mission mission, int lineIndex) {
        String missionID = mission.getMissionID();
        modifyFileData("missionID", mission.getMissionID(), lineIndex);
        modifyFileData("missionName", mission.getMissionName(), lineIndex);
        modifyFileData("missionDesc", mission.getMissionDesc(), lineIndex);
        modifyFileData("missionCountryOrigin", mission.getMissionCountryOrigin(), lineIndex);
        modifyFileData("missionCountriesAllowed", mission.getMissionCountriesAllowed(), lineIndex);
        modifyFileData("missionCoordinatorName", mission.getMissionCoordinatorName(), lineIndex);
        modifyFileData("missionCoordinatorContact", mission.getMissionCoordinatorContact(), lineIndex);
        File f = new File("jobName");
        f.delete();
        f = new File("jobDescription");
        f.delete();
        for (int i = 0; i < mission.getMissionJobs().size(); i++) {
            writeFileData("jobName" + missionID, mission.getMissionJobs().get(i).getJobName());
            writeFileData("jobDescription" + missionID, mission.getMissionJobs().get(i).getJobDescription());
        }
        f = new File("requiredTitleName");
        f.delete();
        f = new File("requiredTitleCount");
        f.delete();
        for (int i = 0; i < mission.getMissionTitles().size(); i++) {
            writeFileData("requiredTitleName" + missionID, mission.getMissionTitles().get(i).getRequiredTitleName());
            writeFileData("requiredTitleCount" + missionID, Integer.toString(mission.getMissionTitles().get(i).getRequiredTitleCount()));
        }
        f = new File("cargoIDForJourney");
        f.delete();
        f = new File("cargoNameForJourney");
        f.delete();
        f = new File("cargoQuantityAvailForJourney");
        f.delete();
        f = new File("cargoQuantityReqForJourney");
        f.delete();
        for (int i = 0; i < mission.getMissionCargoForJourney().size(); i++) {
            writeFileData("cargoIDForJourney" + missionID, mission.getMissionCargoForJourney().get(i).getCargoID());
            writeFileData("cargoNameForJourney" + missionID, mission.getMissionCargoForJourney().get(i).getCargoName());
            writeFileData("cargoQuantityAvailForJourney" + missionID, Integer.toString(mission.getMissionCargoForJourney().get(i).getCargoQuantityAvail()));
            writeFileData("cargoQuantityReqForJourney" + missionID, Integer.toString(mission.getMissionCargoForJourney().get(i).getCargoQuantityReq()));
        }
        f = new File("cargoIDForMission");
        f.delete();
        f = new File("cargoNameForMission");
        f.delete();
        f = new File("cargoQuantityAvailForMission");
        f.delete();
        f = new File("cargoQuantityReqForMission");
        f.delete();
        for (int i = 0; i < mission.getMissionCargoForMission().size(); i++) {
            writeFileData("cargoIDForMission" + missionID, mission.getMissionCargoForMission().get(i).getCargoID());
            writeFileData("cargoNameForMission" + missionID, mission.getMissionCargoForMission().get(i).getCargoName());
            writeFileData("cargoQuantityAvailForMission" + missionID, Integer.toString(mission.getMissionCargoForMission().get(i).getCargoQuantityAvail()));
            writeFileData("cargoQuantityReqForMission" + missionID, Integer.toString(mission.getMissionCargoForMission().get(i).getCargoQuantityReq()));
        }
        f = new File("cargoIDForOtherMissions");
        f.delete();
        f = new File("cargoNameForOtherMissions");
        f.delete();
        f = new File("cargoQuantityAvailForOtherMissions");
        f.delete();
        f = new File("cargoQuantityReqForOtherMissions");
        f.delete();
        for (int i = 0; i < mission.getMissionCargoForOtherMissions().size(); i++) {
            writeFileData("cargoIDForOtherMissions" + missionID, mission.getMissionCargoForOtherMissions().get(i).getCargoID());
            writeFileData("cargoNameForOtherMissions" + missionID, mission.getMissionCargoForOtherMissions().get(i).getCargoName());
            writeFileData("cargoQuantityAvailForOtherMissions" + missionID, Integer.toString(mission.getMissionCargoForOtherMissions().get(i).getCargoQuantityAvail()));
            writeFileData("cargoQuantityReqForOtherMissions" + missionID, Integer.toString(mission.getMissionCargoForOtherMissions().get(i).getCargoQuantityReq()));
        }
        modifyFileData("missionLaunchDate", mission.getMissionLaunchDate(), lineIndex);
        modifyFileData("missionDestinationLocation", mission.getMissionDestinationLocation(), lineIndex);
        modifyFileData("missionDurationMonths", Integer.toString(mission.getMissionDurationMonths()), lineIndex);
        modifyFileData("missionStatus", mission.getMissionStatus(), lineIndex);
    }

    public void modifyFileData(String filePath, String changeData, int lineIndex) {
        String path = filePath;
        String content = "";
        ArrayList<String> contents = new ArrayList<>();
        FileOutputStream output = null;
        try {
            FileReader fileName = new FileReader(path);
            Scanner file = new Scanner(fileName);
            while (file.hasNext()) {
                contents.add(file.nextLine());
            }
            contents.set(lineIndex, changeData);
            for (int i = 0; i < contents.size(); i++) {
                content = contents.get(i) + "\n";
            }
            output = new FileOutputStream(filePath);
            output.write(content.getBytes());
            output.close();
            //System.out.println(content);
            fileName.close();
            file.close();
        } catch (IOException e) {
        }
    }

    //Our database format is that one line represent one data so use ArrayList to store all data.
    public ArrayList<String> readFileData(String filePath) {
        ArrayList<String> content = new ArrayList<>();
        String path = filePath;
        try {
            FileReader fileName = new FileReader(path);
            Scanner file = new Scanner(fileName);
            while (file.hasNext()) {
                content.add(file.nextLine());
            }
            //System.out.println(content);
            fileName.close();
            file.close();
        } catch (IOException e) {
        }
        return content;
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

    public static boolean[] backChoose(String choose) {
        boolean complete = false;
        boolean back = false;
        boolean[] judge = {complete, back};

        Scanner input = new Scanner(System.in);
        String in = "";
        //in.toUpperCase();
        if (choose.equals("H") | choose.equals("B") | choose.equals("L") | choose.equals("F")) {
            switch (choose) {
                case "H":
                    clrscr();
                    System.out.println("Are you sure to return to HomePage? Y(yes)/N(no)");
                    in = input.nextLine();
                    if (in.toUpperCase().equals("Y")) {
                        complete = true;
                    }
                    break;
                case "B":
                    clrscr();
                    System.out.println("Are you sure to go back? Y(yes)/N(no)");
                    in = input.nextLine();
                    if (in.toUpperCase().equals("Y")) {
                        back = true;
                    }
                    break;
                case "L":
                    clrscr();
                    System.out.println("Are are sure to logout? Y(yes)/N(no)");
                    in = input.nextLine();
                    if (in.toUpperCase().equals("Y")) {
                        complete = true;
                    }
                    break;
                case "F":
                    clrscr();
                    System.out.println("Finish this creating Mission activity? Y(yes)/N(no)");
                    in = input.nextLine();
                    if (in.toUpperCase().equals("Y")) {
                        complete = true;
                    }
                    break;
                default:
                    break;
            }
        }
        return judge;
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
}
