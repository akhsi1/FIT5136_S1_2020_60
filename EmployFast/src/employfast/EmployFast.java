/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.util.ArrayList;

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
        Coordinator c = new Coordinator("H1", "D1", "S3");
        c.createMission();
    }
   
    
    
}
