/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akhsi
 */
public class EmployFast {

    private ArrayList<Shuttle> shuttleList;
    private ArrayList<User> userList;
    private ArrayList<Mission> missionList;
    private ArrayList<SelectionCriteria> selectionList;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.displayLogin();
    }

    public void readAllMissions() {

    }

    public void readAllUsers() {
        userList = new ArrayList<User>();
        ArrayList<String> result = new ArrayList<String>();

        String path = "users";

        try {
            FileReader fileName = new FileReader(path);
            Scanner file = new Scanner(fileName);
            while (file.hasNextLine()) {
                result.add(file.nextLine());
            }
            //System.out.println(content);
            fileName.close();
            file.close();
        } catch (IOException e) {
        }
        for (int i = 0; i < result.size(); i += 4) {
            String userID = result.get(i);
            String username = result.get(i + 1);
            String usertype = result.get(i + 2);
            String userpassword = result.get(i + 3);
            User u = new User(userID, username, usertype, userpassword);
            userList.add(u);
        }
    }

    public ArrayList<Shuttle> getShuttleList() {
        shuttleList = new ArrayList<Shuttle>();
        ArrayList<String> result = new ArrayList<String>();
        String path = "shuttle";
        try {
            FileReader fileName = new FileReader(path);
            Scanner file = new Scanner(fileName);
            while (file.hasNextLine()) {
                result.add(file.nextLine());
            }
            //System.out.println(content);
            fileName.close();
            file.close();
        } catch (IOException e) {
        }
        for (int i = 0; i < result.size(); i += 8) {
            String shuttleId = result.get(i);
            String shuttleName = result.get(i + 1);
            int shuttleYear = Integer.valueOf(result.get(i + 2));
            String shuttleFuelCapa = result.get(i + 3);
            int shuttleTravelSpeed = Integer.valueOf(result.get(i + 4));
            String shuttlePassCapa = result.get(i + 5);
            String shuttleCargoCapa = result.get(i + 6);
            String shuttleCountry = result.get(i + 7);

            Shuttle temporaryShuttle = new Shuttle();
            temporaryShuttle.setShuttleId(shuttleId);
            temporaryShuttle.setShuttleName(shuttleName);
            temporaryShuttle.setShuttleManuYear(shuttleYear);
            temporaryShuttle.setShuttleFuelCapacity(shuttleFuelCapa);
            temporaryShuttle.setShuttleTravelSpeed(shuttleTravelSpeed);
            temporaryShuttle.setShuttlePassengerCapacity(shuttlePassCapa);
            temporaryShuttle.setShuttleCargoCapacity(shuttleCargoCapa);
            temporaryShuttle.setShuttleOriginCountry(shuttleCountry);
            shuttleList.add(temporaryShuttle);
        }
        return shuttleList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public ArrayList<Mission> getMissionList() {
        ArrayList<Mission> ml = new ArrayList<Mission>();

        return missionList;
    }

    public void setUserList(ArrayList<User> u) {
        userList = u;
    }

    public void setMissionList(ArrayList<Mission> m) {
        missionList = m;

    }

    public ArrayList<Candidate> getCandidateList() {
        String path = "candidates";
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Candidate> clist = new ArrayList<Candidate>();
        ArrayList<String> candQualifications = new ArrayList<String>();

        try {
            FileReader fileName = new FileReader(path);
            Scanner file = new Scanner(fileName);
            while (file.hasNextLine()) {
                result.add(file.nextLine());
            }
            //System.out.println(content);
            fileName.close();
            file.close();
        } catch (IOException e) {
        }

        for (int i = 0; i < result.size(); i += 5) {
            String candId = result.get(i);
            String candUsername = result.get(i + 1);
            String stringDob = result.get(i + 2);
            String candHealthRecords = result.get(i + 3);
            String qualificationsString = result.get(i + 4);
            if (qualificationsString.contains(",")) {
                candQualifications = new ArrayList<String>(Arrays.asList(qualificationsString.split(",")));
                for (String s : candQualifications) {
                    s.trim();
                }
            } else {
                candQualifications = new ArrayList<String>();
                candQualifications.add(qualificationsString);
            }
            //get candidate DOB as Date
            Date candDob = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                candDob = formatter.parse(stringDob);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //get candidate Age from DOB Date
            Date currdate = new Date();
            LocalDate date1 = currdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate date2 = candDob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int candAge = Period.between(date2, date1).getYears();

            clist.add(new Candidate(candId, candUsername, candAge, candHealthRecords, candQualifications));
        }
        return clist;
    }

    public ArrayList<SelectionCriteria> getSelectionList() {
        String path = "selectionCriteria";
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<SelectionCriteria> clist = new ArrayList<SelectionCriteria>();
        ArrayList<String> qualifications = new ArrayList<String>();
        try {
            FileReader fileName = new FileReader(path);
            Scanner file = new Scanner(fileName);
            while (file.hasNextLine()) {
                result.add(file.nextLine());
            }
            //System.out.println(content);
            fileName.close();
            file.close();
        } catch (IOException e) {
        }

        for (int i = 0; i < result.size(); i += 4) {
            String missionId = result.get(i);
            String rangeAge = result.get(i + 1);
            String health = result.get(i + 2);
            String quals = result.get(i + 3);
            if (quals.contains(",")) {
                qualifications = new ArrayList<String>(Arrays.asList(quals.split(",")));
                for (String q : qualifications) {
                    q.trim();
                }
            } else {
                qualifications = new ArrayList<String>();
                qualifications.add(quals);
            }
            clist.add(new SelectionCriteria(missionId, rangeAge, health, qualifications));
        }
        selectionList = clist;
        return clist;
    }

    public void writeSelectionCriteria(SelectionCriteria newSc) {
        ArrayList<SelectionCriteria> sclist = getSelectionList();
        String output = "";

        for (SelectionCriteria sc : sclist) {
            if (sc.getMissionId().equals(newSc.getMissionId())) {
                sc = newSc;
            }
            String qualsString = "";
            for (String qual : sc.getSelectionQualifications()) {
                qualsString = qualsString + qual + ",";
            }
            qualsString = qualsString.substring(0, qualsString.length() - 1);
            output = output + sc.getMissionId() + "\n" + sc.getSelectionRangeOfAge() + "\n" + sc.getSelectionHealthRecords() + "\n" + qualsString + "\n";
        }
        output = output.substring(0, output.length() - 2);
        try {
            FileWriter fileWriter = new FileWriter("selectionCriteria");
            fileWriter.write(output);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("write selection criteria io exception");
        }

    }
}
