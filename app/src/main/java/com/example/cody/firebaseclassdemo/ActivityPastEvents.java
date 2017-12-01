package com.example.cody.firebaseclassdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ActivityPastEvents extends Activity implements Button.OnClickListener {

    private Button buttonSortTitle, buttonSortTime, buttonSortStartLocation, buttonSortEndLocation, buttonSortDuration, buttonSortRunners, buttonSortFriends;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_events);

        buttonSortTitle = (Button) findViewById(R.id.buttonSortTitle);
        buttonSortTitle.setOnClickListener(this);
        buttonSortTime = (Button) findViewById(R.id.buttonSortTime);
        buttonSortTime.setOnClickListener(this);
        buttonSortStartLocation = (Button) findViewById(R.id.buttonSortStartLocation);
        buttonSortStartLocation.setOnClickListener(this);
        buttonSortEndLocation = (Button) findViewById(R.id.buttonSortEndLocation);
        buttonSortEndLocation.setOnClickListener(this);
        buttonSortDuration = (Button) findViewById(R.id.buttonSortDuration);
        buttonSortDuration.setOnClickListener(this);
        //Sort by # of runners participating in the event
        buttonSortRunners = (Button) findViewById(R.id.buttonSortRunners);
        buttonSortRunners.setOnClickListener(this);
        //Sort by # of friends participating in the event
        buttonSortFriends = (Button) findViewById(R.id.buttonSortFriends);
        buttonSortFriends.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mainMenuInflater = getMenuInflater();
        mainMenuInflater.inflate(R.menu.mainmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {

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
