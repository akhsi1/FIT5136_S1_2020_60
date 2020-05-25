/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

/**
 *
 * @author Rongkun
 */
public class RequiredTitle {
    private String requiredTitleName;
    private int requiredTitleCount;
    
    public RequiredTitle()
    {
        requiredTitleName = "";
        requiredTitleCount = 0;
    }
    
    public RequiredTitle(String requiredTitleName,int requiredTitleCount)
    {
        this.requiredTitleName =  requiredTitleName;
        this.requiredTitleCount = requiredTitleCount;
    }
    
    public String getRequiredTitleName()
    {
        return  requiredTitleName;
    }
    
    public int  getRequiredTitleCount()
    {
        return  requiredTitleCount;
    }
    
    public void setRequiredTitleName(String requiredTitleName)
    {
        this.requiredTitleName =  requiredTitleName;
    }
    
    public void setRequiredTitleCount(int requiredTitleCount)
    {
        this.requiredTitleCount = requiredTitleCount;
    }
}
