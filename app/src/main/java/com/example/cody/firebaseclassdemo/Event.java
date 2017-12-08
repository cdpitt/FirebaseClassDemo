package com.example.cody.firebaseclassdemo;

/**
 * Created by Noah on 12/7/2017.
 */

public class Event {
    //defining fields that should be available for all Events
    public String eventTitle, eventStartTime, eventDuration,
            eventStartLocation, eventEndLocation, eventLimit,
            /*CHANGE: specifically for eventInvites --> if we store Users on Events we could include this
            field as an array of Users once we create the Users object?*/
            eventInvites,
            eventDescription;
    //create function to make Events an object
    public Event() {
    }
    //define all attributes that are on an instance of an Events object
    public Event(String eventTitle, String eventStartTime, String eventDuration,
                 String eventStartLocation, String eventEndLocation, String eventLimit,
                 String eventInvites, String eventDescription) {

        this.eventTitle = eventTitle;
        this.eventStartTime = eventStartTime;
        this.eventDuration = eventDuration;
        this.eventStartLocation = eventStartLocation;
        this.eventEndLocation = eventEndLocation;
        this.eventLimit = eventLimit;
        //CHANGE: again - change this to array of Users if we get the chance
        this.eventInvites = eventInvites;
        this.eventDescription = eventDescription;


    }


}
