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

    private ArrayList<User> userList;
    private ArrayList<Mission> missionList;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.displayLogin();
    }
    
    public void readAllMissions(){
        
    }
    public void readAllUsers(){
        userList = new ArrayList<User>();
        ArrayList<String> result = new ArrayList<String>();
<<<<<<< HEAD
        String path = "users.txt";
=======
        String path = "users";

>>>>>>> master
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
<<<<<<< HEAD
    
    public void getUserList(){
        
    }
    
    public void getMissionList(){
        
    }
    
    public void setUserList(){
        
    }
    
    public void setMissionList(){
        
=======

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

>>>>>>> master
    }
}
