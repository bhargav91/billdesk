package com.github.bhargav91;

import java.util.Date;

/**
 * Created by Bhargav on 12/20/2018.
 */
public class User {
    private UserType userType;
    private Date dateOfRegistration;
    private String id;

    public User(UserType userType, Date dateOfRegistration, String id) {
        this.userType = userType;
        this.dateOfRegistration = dateOfRegistration;
        this.id = id;
    }

    public User() {
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
