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
public class Qualification {
    private String qualificationId;
    private String qualificationName;
    
    public Qualification(){
        
    }

    public Qualification(String qualificationId, String qualificationName) {
        this.qualificationName = qualificationName;
        this.qualificationId = qualificationId;
    }
    

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(String qualificationId) {
        this.qualificationId = qualificationId;
    }
    
}
