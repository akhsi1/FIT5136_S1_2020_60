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
public class EmployFastSystem {

    private Mission selectedMission;
    private Shuttle selectedShuttle;

    public EmployFastSystem() {
    }

    public boolean hasMissionSelected() {
        if (selectedMission != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasShuttleSelected() {
        if (selectedShuttle != null) {
            return true;

        } else {
            return false;
        }
    }

    public boolean hasSelectionCriteria() {
        if (hasMissionSelected()){
            if (selectedMission.getSelectionCriteria().getSelectionRangeOfAge() != null 
                    && selectedMission.getSelectionCriteria().getSelectionHealthRecords() != null 
                    && selectedMission.getSelectionCriteria().getSelectionQualifications() != null){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> readUsersFile() {
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
        return result;
    }

    public User verifyUser(String uname, String pw) {
        String result = "";
        ArrayList<String> usersList = readUsersFile();
        User u = new User();
        for (int i = 0; i < usersList.size(); i += 4) {
            String userId = usersList.get(i);
            String username = usersList.get(i+1);
            String usertype = usersList.get(i + 2);
            String userpassword = usersList.get(i + 3);
            if (uname.equals(username) && pw.equals(userpassword)) {
                u = new User(userId, username, usertype, userpassword);
            }
        }
        return u;
    }

    public Shuttle getSelectedShuttle() {
        return selectedShuttle;
    }
    public Mission getSelectedMission(){
        return selectedMission;
    }
    public void setSelectedShuttle(Shuttle s){
        selectedShuttle = s;
    }
}
