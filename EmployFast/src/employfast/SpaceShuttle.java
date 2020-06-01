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
class SpaceShuttle {
    
    private String shuttleName;
    private int shuttleManuYear;
    private String shuttleFuelCap;
    private int shuttlePassCap;
    private String shuttleCargoCap;
    private float shuttleTrvlSpeed;
    
    public SpaceShuttle()
    {
        shuttleName = "";
        shuttleManuYear = "";
        shuttleFuelCap = "";
        shuttlePassCap = "";
        shuttleCargoCap = "";
        shuttleTrvlSpeed = "";
    }

    public SpaceShuttle(String shuttleName,int shuttleManuYear, String shuttleFuelCap, int shuttlePassCap, String shuttleCargoCap, float shuttleTrvlSpeed)
    {
        this.shuttleName = shuttleName;
        this.shuttleManuYear = shuttleManuYear;
        this.shuttleFuelCap = shuttleFuelCap;
        this.shuttlePassCap = shuttlePassCap;
        this.shuttleCargoCap = shuttleCargoCap;
        this.shuttleTrvlSpeed = shuttleTrvlSpeed;
    }

    public String getShuttleName()
    {
        return shuttleName;
    }

    public int getshuttleManuYear()
    {
        return shuttleManuYear;
    }

    public String getshuttleFuelCap()
    {
        return shuttleFuelCap;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
