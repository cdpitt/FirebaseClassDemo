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


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityEditProfile extends Activity implements View.OnClickListener {

    //define objects
    private Button buttonUpdateProfile;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextUserBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //connecting objects to UI
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUserBio = findViewById(R.id.editTextUserBio);

        buttonUpdateProfile = findViewById(R.id.buttonUpdateProfile);
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
        DatabaseReference userRef = db.getReference("Users");
//INCOMPLETE: this should update the fields of the user profile based on what is populated in Profile page
        if (view == buttonUpdateProfile) {
            String updateFirstName = editTextFirstName.getText().toString();
            String updateLastName = editTextLastName.getText().toString();
            String updateBio = editTextUserBio.getText().toString();
            String updateEmail = editTextEmail.getText().toString();





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
