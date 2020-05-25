/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

/**
 *
 * @author akhsi
 * @author Rongkun Ji
 */
class User {
    private String userName;
    private String userId;
    private String password;
    
    public User()
    {
        userName = "";
        userId = "";
        password = "";
    }
    
    public User(String userName,String userId,String password)
    {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public String getPassword()
    {
        return password;
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
