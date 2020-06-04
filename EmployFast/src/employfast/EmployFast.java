/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author akhsi
 */
public class EmployFast {
    private ArrayList<Shuttle> shuttleList;
    private ArrayList<User> userList;
    private ArrayList<Mission> missionList;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        //ui.displayLogin();
//        Coordinator coordinator = new Coordinator("H1","D1","S3","s4");
//        System.out.println(coordinator.getPassword());
//        coordinator.createMission();
        ui.displayShuttleInfo();
        
    }
    
    public void readAllMissions(){
        
    }
    public void readAllUsers(){
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
            String username = result.get(i+1);
            String usertype = result.get(i + 2);
            String userpassword = result.get(i + 3);
            User u = new User(userID, username, usertype, userpassword);
            userList.add(u);
        }
    }
    public ArrayList<Shuttle> getShuttleList(){
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
            String shuttleName = result.get(i+1);
            int shuttleDate = result.get(i + 2);
            String shuttleFuelCapa = result.get(i + 3);
            float shuttleTravelSpeed = result.get(i+4);
            String shuttlePassCapa = result.get(i+5);
            String shuttleCargoCapa = result.get(i+6);
            String shuttleCountry = result.get(i+7);
            
            Shuttle temporaryShuttle = new Shuttle();
            temporaryShuttle.setShuttleId(shuttleId);
            temporaryShuttle.setShuttleName(shuttleName);
            temporaryShuttle.setShuttleManuYear(shuttleDate);
            temporaryShuttle.setShuttleFuelCapacity(shuttleFuelCapa);
            temporaryShuttle.setShuttleTravelSpeed(shuttleTravelSpeed);
            temporaryShuttle.setShuttlePassengerCapacity(shuttlePassCapa);
            temporaryShuttle.setShuttleCargoCapacity(shuttleCargoCapa);
            temporaryShuttle.setShuttleOriginCountry(shuttleCountry);
            shuttleList.add(temporaryShuttle);
        }
        return shuttleList;
    }

    public ArrayList<User> getUserList(){
        return userList;
    }
    
    public ArrayList<Mission> getMissionList(){
        return missionList;
    }
    
    public void setUserList(ArrayList<User> u){
        userList = u;
    }
    
    public void setMissionList(ArrayList<Mission> m){
        missionList = m;

    }
}
