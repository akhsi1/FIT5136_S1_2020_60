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
public class Coordinator extends User {

    public Coordinator() {
        super();
    }

    public Coordinator(String userName, String userId, String password) {
        super(userName, userId, password);
    }

    public Mission createMission() {
        Mission mission = new Mission();
        Scanner input = new Scanner(System.in);
        boolean complete = false;
        do {
            System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
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
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionID(in);
                    }
                    break;
                case "2":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Mission name");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionName(in);
                    }
                    break;
                case "3":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Mission description");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionDesc(in);
                    }
                    break;
                case "4":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Country of origin");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionCountryOrigin(in);
                    }
                    break;
                case "5":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Countries allowed");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionCountriesAllowed(in);
                    }
                    break;
                case "6":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input  Coordinator’s name");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionCoordinatorName(in);
                    }
                    break;
                case "7":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Coordinator’contact information");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionCoordinatorContact(in);
                    }
                    break;
                case "8":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Job Name");
                    String jobName = input.nextLine();
                    complete = backChoose(jobName.toUpperCase());
                    if (!complete) {
                        System.out.println("Please input Job Name");
                        String jobDescription = input.nextLine();
                        complete = backChoose(jobDescription.toUpperCase());
                        if (!complete) {
                            mission.getMissionJobs().add(new Job(jobName, jobDescription));
                        }
                    }

                    break;
                case "9":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Employment requirement title name");
                    String requiredTitleName = input.nextLine();
                    complete = backChoose(requiredTitleName.toUpperCase());
                    if (!complete) {
                        System.out.println("Please input number of employees for the Employment requirement title");
                        String requiredTitleCount = input.nextLine();
                        complete = backChoose(requiredTitleCount.toUpperCase());
                        if (!complete) {
                            mission.getMissionTitles().add(new RequiredTitle(requiredTitleName, Integer.parseInt(requiredTitleCount)));
                        }
                    }
                    break;
                case "10":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please choose type of cargo requirements \n 1.For  the journey \n 2.For the mission \n 3.For other missions");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        switch (in) {
                            case "1":
                                clrscr();
                                System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                                System.out.println("You choose cargo requirements for the journey \n Please input cargo ID");
                                String cargoID = input.nextLine();
                                complete = backChoose(cargoID.toUpperCase());
                                if (!complete) {
                                    System.out.println("You choose cargo requirements for the journey \n Please input cargo name");
                                    String cargoName = input.nextLine();
                                    complete = backChoose(cargoName.toUpperCase());
                                    if (!complete) {
                                        System.out.println("You choose cargo requirements for the journey \n Please input the availbel number of this cargo");
                                        String cargoQuantityAvail = input.nextLine();
                                        complete = backChoose(cargoQuantityAvail.toUpperCase());
                                        if (!complete) {
                                            System.out.println("You choose cargo requirements for the journey \n Please input the required number of this cargo");
                                            String cargoQuantityReq = input.nextLine();
                                            complete = backChoose(cargoQuantityReq.toUpperCase());
                                            if (!complete) {
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
                                complete = backChoose(cargoID.toUpperCase());
                                if (!complete) {
                                    System.out.println("You choose cargo requirements for the mission \n Please input cargo name");
                                    String cargoName = input.nextLine();
                                    complete = backChoose(cargoName.toUpperCase());
                                    if (!complete) {
                                        System.out.println("You choose cargo requirements for the mission \n Please input the availbel number of this cargo");
                                        String cargoQuantityAvail = input.nextLine();
                                        complete = backChoose(cargoQuantityAvail.toUpperCase());
                                        if (!complete) {
                                            System.out.println("You choose cargo requirements for the mission \n Please input the required number of this cargo");
                                            String cargoQuantityReq = input.nextLine();
                                            complete = backChoose(cargoQuantityReq.toUpperCase());
                                            if (!complete) {
                                                mission.getMissionCargoForJourney().add(new Cargo(cargoID, cargoName, Integer.parseInt(cargoQuantityAvail), Integer.parseInt(cargoQuantityReq)));
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
                                complete = backChoose(cargoID.toUpperCase());
                                if (!complete) {
                                    System.out.println("You choose cargo requirements for other missions \n Please input cargo name");
                                    String cargoName = input.nextLine();
                                    complete = backChoose(cargoName.toUpperCase());
                                    if (!complete) {
                                        System.out.println("You choose cargo requirements for other missions \n Please input the availbel number of this cargo");
                                        String cargoQuantityAvail = input.nextLine();
                                        complete = backChoose(cargoQuantityAvail.toUpperCase());
                                        if (!complete) {
                                            System.out.println("You choose cargo requirements for other missions \n Please input the required number of this cargo");
                                            String cargoQuantityReq = input.nextLine();
                                            complete = backChoose(cargoQuantityReq.toUpperCase());
                                            if (!complete) {
                                                mission.getMissionCargoForJourney().add(new Cargo(cargoID, cargoName, Integer.parseInt(cargoQuantityAvail), Integer.parseInt(cargoQuantityReq)));
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
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionLaunchDate(in);
                    }
                    break;
                case "12":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Location of the destination");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionDestinationLocation(in);
                    }
                    break;
                case "13":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Duration of the mission");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
                        mission.setMissionDurationMonths(Integer.parseInt(in));
                    }
                    break;
                case "14":
                    clrscr();
                    System.out.println("Enter H to return to Home \n Enter B to go back \n Enter F to finish this Mission \n Enter L to log out \n \n");
                    System.out.println("Please input Status of the mission \n a. Planning phase (selected by default) \n b. Departed Earth \n c. Landed on Mars \n"
                            + "d. Mission in progress \n e. Returned to Earth \n f. Mission completed");
                    in = input.nextLine();
                    complete = backChoose(in.toUpperCase());
                    if (!complete) {
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
        return mission;
    }

    public void viewMission() {

    }

    public void modifyMission() {

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

    public static boolean backChoose(String choose) {
        boolean complete = false;
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        in.toUpperCase();
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
        return complete;
    }
}
