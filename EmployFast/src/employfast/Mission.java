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
class Mission {
    
    private String missionID;
    private String missionName;
    private String missionDesc;
    private String missionCountryOrigin;
    private String missionCountriesAllowed;
    private String missionCoordinatorName;
    private String missionCoordinatorContact;
    private ArrayList<Job> missionJobs;
    private ArrayList<RequiredTitle> missionTitles;
    private ArrayList<Cargo> missionCargoForJourney;
    private ArrayList<Cargo> missionCargoForMission;
    private ArrayList<Cargo> missionCargoForOtherMissions;
    private String missionLaunchDate;
    private String missionDestinationLocation;
    private int missionDurationMonths;
    private String missionStatus;
    private ArrayList<Shuttle> shuttleList;
    private SelectionCriteria selectionCriteria;
       
    public Mission(){
        missionID = "";
        missionName = "";
        missionDesc = "";
        missionCountryOrigin = "";
        missionCountriesAllowed = "";
        missionCoordinatorName = "";
        missionCoordinatorContact = "";
        missionJobs = new ArrayList<>();
        missionTitles = new ArrayList<>();
        missionCargoForJourney = new ArrayList<>();
        missionCargoForMission = new ArrayList<>();
        missionCargoForOtherMissions = new ArrayList<>();
        missionLaunchDate = "";
        missionDestinationLocation = "";
        missionDurationMonths = 0;
        missionStatus = "";
        shuttleList = new ArrayList<>();
        selectionCriteria = new SelectionCriteria();
    }
    
    public Mission(String missionID,String missionName,String missionDesc,String missionCountryOrigin,String missionCountriesAllowed,String missionCoordinatorName,String missionCoordinatorContact,
           ArrayList<Job> missionJobs,ArrayList<RequiredTitle> missionTitles,ArrayList<Cargo> missionCargoForJourney,ArrayList<Cargo> missionCargoForMission,ArrayList<Cargo> missionCargoForOtherMissions, String missionLaunchDate,
           String missionDestinationLocation,int missionDurationMonths,String missionStatus,ArrayList<Shuttle> shuttleList,SelectionCriteria selectionCriteria)
    {
        this.missionID = missionID;
        this.missionName = missionName;
        this.missionDesc = missionDesc;
        this.missionCountryOrigin = missionCountryOrigin;
        this.missionCountriesAllowed = missionCountriesAllowed;
        this.missionCoordinatorName = missionCoordinatorName;
        this.missionCoordinatorContact = missionCoordinatorContact;
        this.missionJobs =  missionJobs;
        this.missionTitles = missionTitles;
        this.missionCargoForJourney = missionCargoForJourney;
        this.missionCargoForMission = missionCargoForMission;
        this.missionCargoForOtherMissions = missionCargoForOtherMissions;
        this.missionLaunchDate = missionLaunchDate;
        this.missionDestinationLocation = missionDestinationLocation;
        this.missionDurationMonths = missionDurationMonths;
        this.missionStatus = missionStatus;
        this.shuttleList = shuttleList;
        this.selectionCriteria = selectionCriteria;
    }
    
    public String getMissionID()
    {
        return missionID;
    }
    
    public void setMissionID(String missionID)
    {
         this.missionID = missionID;
    }
    
    public String getMissionName()
    {
        return missionName;
    }
    
    public void setMissionName(String missionName)
    {
         this.missionName = missionName;
    }
    
    public String getMissionDesc()
    {
        return missionDesc;
    }
    
    public void setMissionDesc(String missionDesc)
    {
         this.missionDesc = missionDesc;
    }
    
    public String getMissionCountryOrigin()
    {
        return missionCountryOrigin;
    }
    
    public void setMissionCountryOrigin(String missionCountryOrigin)
    {
         this.missionCountryOrigin = missionCountryOrigin;
    }
    
    public String getMissionCountriesAllowed()
    {
        return missionCountriesAllowed;
    }
    
    public void setMissionCountriesAllowed(String missionCountriesAllowed)
    {
         this.missionCountriesAllowed = missionCountriesAllowed;
    }
    
    public String getMissionCoordinatorName()
    {
        return missionCoordinatorName;
    }
    
    public void setMissionCoordinatorName(String missionCoordinatorName)
    {
         this.missionCoordinatorName = missionCoordinatorName;
    }
    
    public String getMissionCoordinatorContact()
    {
        return missionCoordinatorContact;
    }
    
    public void setMissionCoordinatorContact(String missionCoordinatorContact)
    {
         this.missionCoordinatorContact = missionCoordinatorContact;
    }
    
    public ArrayList<Job> getMissionJobs()
    {
        return missionJobs;
    }
    
    public void setMissionJobs(ArrayList<Job> missionJobs)
    {
        this.missionJobs = missionJobs;
    }
    
    public ArrayList<RequiredTitle> getMissionTitles()
    {
        return missionTitles;
    }
    
    public void setMissionTitles(ArrayList<RequiredTitle> missionTitles)
    {
        this.missionTitles = missionTitles;
    }
    
    public ArrayList<Cargo> getMissionCargoForJourney()
    {
        return missionCargoForJourney;
    }
    
    public void setMissionCargoForJourney(ArrayList<Cargo> missionCargoForJourney)
    {
        this.missionCargoForJourney = missionCargoForJourney;
    }
    
    public ArrayList<Cargo> getMissionCargoForMission()
    {
        return missionCargoForMission;
    }
    
    public void setMissionCargoForMission(ArrayList<Cargo> missionCargoForMission)
    {
        this.missionCargoForMission = missionCargoForMission;
    }
    
    public ArrayList<Cargo> getMissionCargoForOtherMissions()
    {
        return missionCargoForOtherMissions;
    }
    
    public void setMissionCargoForOtherMissions(ArrayList<Cargo> missionCargoForOtherMissions)
    {
        this.missionCargoForOtherMissions = missionCargoForOtherMissions;
    }
    
    public String getMissionLaunchDate()
    {
        return missionLaunchDate;
    }
    
    public void setMissionLaunchDate(String missionLaunchDate)
    {
        this.missionLaunchDate = missionLaunchDate;
    }
    
    public String getMissionDestinationLocation()
    {
        return missionDestinationLocation;
    }
    
    public void setMissionDestinationLocation(String missionDestinationLocation)
    {
        this.missionDestinationLocation = missionDestinationLocation;
    }
    
    public int getMissionDurationMonths()
    {
        return missionDurationMonths;
    }
    
    public void setMissionDurationMonths(int missionDurationMonths)
    {
        this.missionDurationMonths = missionDurationMonths;
    }
    
    public String getMissionStatus()
    {
        return missionStatus;
    }
    
    public void setMissionStatus(String missionStatus)
    {
        this.missionStatus = missionStatus;
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
