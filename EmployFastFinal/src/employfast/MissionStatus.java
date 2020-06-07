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
public class MissionStatus {
    private String statusId;
    private String statusMessage;

    public MissionStatus(){
        
    }
    public MissionStatus(String statusId, String statusMessage) {
        this.statusId = statusId;
        this.statusMessage = statusMessage;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    
    
}
