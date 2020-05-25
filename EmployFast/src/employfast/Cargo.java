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
public class Cargo {
    private String cargoID;
    private String cargoName;
    private int cargoQuantityAvail;
    
    public Cargo()
    {
        cargoID = "";
        cargoName = "";
        cargoQuantityAvail = 0;
    }
    
    public Cargo(String cargoID,String cargoName,int cargoQuantityAvail)
    {
        this.cargoID = cargoID;
        this.cargoName = cargoName;
        this.cargoQuantityAvail = cargoQuantityAvail;
    }
    
    public String  getCargoID()
    {
        return cargoID;
    }
    
    public String  getCargoName()
    {
        return cargoName;
    }
    
    public int  getCargoQuantityAvail()
    {
        return cargoQuantityAvail;
    }
    
    public void setCargoID(String cargoID)
    {
        this.cargoID = cargoID;
    }
    
    public void setCargoName(String cargoName)
    {
        this.cargoName = cargoName;
    }
    
    public void setCargoQuantityAvail(int cargoQuantityAvail)
    {
        this.cargoQuantityAvail = cargoQuantityAvail;
    }
}
