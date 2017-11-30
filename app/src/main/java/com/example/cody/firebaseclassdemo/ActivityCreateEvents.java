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

public class ActivityCreateEvents extends Activity implements Button.OnClickListener {

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

        buttonCreateEvent = (Button) findViewById(R.id.buttonCreateEvent);
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

        if (view == buttonCreateEvent) {
            Intent intentHome = new Intent(this, ActivityHome.class);
            this.startActivity(intentHome);
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
