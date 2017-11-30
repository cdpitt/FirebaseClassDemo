package com.example.cody.firebaseclassdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ActivityHome extends Activity implements Button.OnClickListener {

    //Define objects
    private Button buttonFind;
    private Button buttonCreate;
    private Button buttonPast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonFind = (Button) findViewById(R.id.buttonFind);
        buttonFind.setOnClickListener(this);
        buttonCreate = (Button) findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(this);
        buttonPast = (Button) findViewById(R.id.buttonPast);
        buttonPast.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mainMenuInflater = getMenuInflater();
        mainMenuInflater.inflate(R.menu.mainmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onClick(View view) {
        if (view == buttonFind) {
            Intent intentFindEvents = new Intent(this, ActivityFindEvents.class);
            this.startActivity(intentFindEvents);
        } else if (view == buttonCreate) {
            Intent intentCreateEvents = new Intent(this, ActivityCreateEvents.class);
            this.startActivity(intentCreateEvents);
        } else if (view == buttonPast) {
            Intent intentPastEvents = new Intent(this, ActivityPastEvents.class);
            this.startActivity(intentPastEvents);

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
