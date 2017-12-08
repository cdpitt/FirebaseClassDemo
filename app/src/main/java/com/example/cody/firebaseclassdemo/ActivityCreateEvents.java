package com.example.cody.firebaseclassdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityCreateEvents extends Activity implements View.OnClickListener {

    //Define Objects

    private Button buttonCreateEvent;
    private EditText editTextTitle;
    private EditText editTextStartLocation;
    private EditText editTextEndLocation;
    private EditText editTextStartTime;
    private EditText editTextDuration;
    private EditText editTextLimit;
    private EditText editTextInvites;
    private EditText editTextDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_events);

        //testnew

        buttonCreateEvent = (Button) findViewById(R.id.buttonCreateEvent);
        //set listener
        buttonCreateEvent.setOnClickListener(this);

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextStartLocation = (EditText) findViewById(R.id.editTextStartLocation);
        editTextEndLocation = (EditText) findViewById(R.id.editTextEndLocation);
        editTextStartTime = (EditText) findViewById(R.id.editTextStartTime);
        editTextDuration = (EditText) findViewById(R.id.editTextDuration);
        editTextLimit = (EditText) findViewById(R.id.editTextLimit);
        editTextInvites = (EditText) findViewById(R.id.editTextInvites);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mainMenuInflater = getMenuInflater();
        mainMenuInflater.inflate(R.menu.mainmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {

        //initializing Firebase database
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference eventRef = db.getReference("Events");


        //this should create a new record for an Event in Firebase
        if (view == buttonCreateEvent) {
            String eventTitle = editTextTitle.getText().toString();
            String eventStartTime = editTextStartTime.getText().toString();
            String eventDuration = editTextDuration.getText().toString();
            String eventStartLocation = editTextStartLocation.getText().toString();
            String eventEndLocation = editTextEndLocation.getText().toString();
            String eventLimit = editTextLimit.getText().toString();
            //UPDATE/FIX: MAKE INTO ARRAY of Users
            String eventInvites = editTextInvites.getText().toString();
            String eventDescription = editTextDescription.getText().toString();

            Event newEvent = new Event(eventTitle, eventStartTime, eventDuration,
                    eventStartLocation, eventEndLocation, eventLimit, eventInvites,
                    eventDescription);
            eventRef.push().setValue(newEvent);

            //display event created message
            Toast.makeText(ActivityCreateEvents.this, "Event Created", Toast.LENGTH_SHORT).show();

            /* DELETE: Cody's placeholder code
            Intent intentHome = new Intent(this, ActivityHome.class);
            this.startActivity(intentHome);
             */

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuitemHome) {
            Intent intentHome = new Intent(this, ActivityHome.class);
            this.startActivity(intentHome);
        } else if (item.getItemId() == R.id.menuitemEditProfile) {
            Intent intentEditProfile = new Intent(this, ActivityEditProfile.class);
            this.startActivity(intentEditProfile);
        } else if (item.getItemId() == R.id.menuitemSettings) {
            Intent intentSettings = new Intent(this, ActivitySettings.class);
            this.startActivity(intentSettings);
        } else if (item.getItemId() == R.id.menuitemLogout) {
            Intent intentLogout = new Intent(this, LoginActivity.class);
            this.startActivity(intentLogout);
        }

        return super.onOptionsItemSelected(item);
    }

}
