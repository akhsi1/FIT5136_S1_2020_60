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
    private String userType;
    
    public User()
    {
        userName = "";
        userId = "";
        password = "";
        userType = "";
    }
    
    public User(String userId, String userName,String userType, String password)
    {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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
