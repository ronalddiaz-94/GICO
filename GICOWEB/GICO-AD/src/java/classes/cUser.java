/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author PedroJr
 */
public class cUser {
    
    private Integer userMType; //tipo gestion
    private Integer userId;
    private String userPass;
    private String userName;
    private String userNameUser;
    private Integer userRol;
    private String userRolName;
    private String userCI;
    private String userTypeDescription;
    private String userLogin; //estado de ingreso

    public String getUserRolName() {
        return userRolName;
    }

    public void setUserRolName(String userRolName) {
        this.userRolName = userRolName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
    
    

    public String getUserTypeDescription() {
        return userTypeDescription;
    }

    public void setUserTypeDescription(String userTypeDescription) {
        this.userTypeDescription = userTypeDescription;
    }

   
    

    public Integer getUserMType() {
        return userMType;
    }

    public void setUserMType(Integer userMType) {
        this.userMType = userMType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameUser() {
        return userNameUser;
    }

    public void setUserNameUser(String userNameUser) {
        this.userNameUser = userNameUser;
    }

    public Integer getUserRol() {
        return userRol;
    }

    public void setUserRol(Integer userRol) {
        this.userRol = userRol;
    }

    public String getUserCI() {
        return userCI;
    }

    public void setUserCI(String userCI) {
        this.userCI = userCI;
    }
    
    
}
