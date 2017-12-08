package com.example.cody.firebaseclassdemo;

/**
 * Created by Noah on 12/7/2017.
 */

public class User {
    //defining fields that should be available for all Users
    public String userFirstName, userLastName, userEmail, userBio;

    public User() {
    }

    public User(String userFirstName, String userLastName, String userEmail, String userBio) {

        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userBio = userBio;

    }

}
