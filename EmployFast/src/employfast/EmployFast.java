/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

/**
 *
 * @author akhsi
 */
public class EmployFast {

    private User[] userList;
    private SelectionCriteria[] selectionCriteriaList;
    private Mission[] missionList;
    private Shuttle[] shuttleList;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.displayLogin();
    }
   
    
    
}
