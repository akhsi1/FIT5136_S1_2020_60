/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

/**
 *
 * @author akhsi
 * @author Rongkun
 */
public class Job {
    private String jobName;
    private String jobDescription;
    
    public Job()
    {
        jobName = "";
        jobDescription = "";
    }
    
        public Job(String jobName,String jobDescription)
    {
        this.jobName = jobName;
        this.jobDescription =jobDescription;
    }
    
    public String getJobName()
    {
        return jobName;
    }
    
    public String getJobDescription()
    {
        return jobDescription;
    }
    
    public void setJobName(String jobName)
    {
        this.jobName = jobName;
    }
    
    public void setJobDescription(String jobDescription)
    {
        this.jobDescription = jobDescription;
    }
}
