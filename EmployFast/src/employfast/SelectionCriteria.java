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
 * @author Rongkun
 */
class SelectionCriteria {
    private String selectionRangeOfAge;
    private String selectionHealthRecords;
    private ArrayList<String> selectionQualifications;
    
    public SelectionCriteria()
    {
        selectionRangeOfAge = "";
        selectionHealthRecords = "";
        selectionQualifications = new ArrayList<String>();
    }
    
    public SelectionCriteria(String selectionRangeOfAge,String selectionHealthRecords, ArrayList<String> selectionQualifications)
    {
        this.selectionRangeOfAge = selectionRangeOfAge;
        this.selectionHealthRecords = selectionHealthRecords;
        this.selectionQualifications = selectionQualifications;
    }
    
    public String getSelectionRangeOfAge()
    {
        return selectionRangeOfAge;
    }
    
    public void setSelectionRangeOfAge(String selectionRangeOfAge)
    {
        this.selectionRangeOfAge = selectionRangeOfAge;
    }
    
    public String getSelectionHealthRecords()
    {
        return selectionHealthRecords;
    }
    
    public void setSelectionHealthRecords(String selectionHealthRecords)
    {
        this.selectionHealthRecords = selectionHealthRecords;
    }
    
    public ArrayList<String> getSelectionQualifications()
    {
        return selectionQualifications;
    }
    
    public void setSelectionQualifications(ArrayList<String> selectionQualifications)
    {
        this.selectionQualifications = selectionQualifications;
    }
}
