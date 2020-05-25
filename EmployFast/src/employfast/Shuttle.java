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
class Shuttle {
   private String shuttleName;
   private int shuttleManuYear;
   private String shuttleFuelCapacity;
   private float shuttleTravelSpeed;
   private String shuttlePassengerCapacity;
   private String shuttleCargoCapacity;

   public Shuttle()
   {
       shuttleName = "";
       shuttleManuYear = 0;
       shuttleFuelCapacity = "";
       shuttleTravelSpeed  = 0;
       shuttlePassengerCapacity = "";
       shuttleCargoCapacity  = "";       
   }
   
   public Shuttle(String shuttleName,int shuttleManuYear,String shuttleFuelCapacity,float shuttleTravelSpeed,String shuttlePassengerCapacity,String shuttleCargoCapacity)
   {
       this.shuttleName = shuttleName;
       this.shuttleManuYear = shuttleManuYear;
       this.shuttleFuelCapacity = shuttleFuelCapacity;
       this.shuttleTravelSpeed = shuttleTravelSpeed;
       this.shuttlePassengerCapacity = shuttlePassengerCapacity;
       this.shuttleCargoCapacity = shuttleCargoCapacity;      
   }
   
   public String getShuttleName()
   {
       return shuttleName;
   }
   
   public void setShuttleName(String shuttleName)
   {
       this.shuttleName = shuttleName;
   }
   
   public int getShuttleManuYear()
   {
       return shuttleManuYear;
   }
   
   public void setShuttleManuYear(int shuttleManuYear)
   {
       this.shuttleManuYear = shuttleManuYear;
   }
   
   public String getShuttleFuelCapacity()
   {
       return shuttleFuelCapacity;
   }
   
   public void setShuttleFuelCapacity(String shuttleFuelCapacity)
   {
       this.shuttleFuelCapacity = shuttleFuelCapacity;
   }
   
   public float getShuttleTravelSpeed()
   {
       return shuttleTravelSpeed;
   }
   
   public void setShuttleTravelSpeed(float shuttleTravelSpeed)
   {
       this.shuttleTravelSpeed = shuttleTravelSpeed;
   }
   
   public String getShuttlePassengerCapacity()
   {
       return shuttlePassengerCapacity;
   }
   
   public void setShuttlePassengerCapacity(String shuttlePassengerCapacity)
   {
       this.shuttlePassengerCapacity = shuttlePassengerCapacity;
   }
   
   public String getShuttleCargoCapacity()
   {
       return shuttleCargoCapacity;
   }
   
   public void setShuttleCargoCapacity(String shuttleCargoCapacity)
   {
       this.shuttleCargoCapacity = shuttleCargoCapacity;
   }
}
