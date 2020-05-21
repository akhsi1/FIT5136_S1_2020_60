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
class Mission {
    
    private ArrayList<Shuttle> shuttleList;
    private SelectionCriteria selectionCriteria ;
    
    public Mission(){
        
    }

    public ArrayList<Shuttle> getShuttleList() {
        return shuttleList;
    }

    public void setShuttleList(ArrayList<Shuttle> shuttleList) {
        this.shuttleList = shuttleList;
    }

    public SelectionCriteria getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSelectionCriteria(SelectionCriteria selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }
    
    
    
}
