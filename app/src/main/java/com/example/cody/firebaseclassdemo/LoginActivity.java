package com.example.cody.firebaseclassdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

public class LoginActivity extends Activity implements View.OnClickListener {

    //Define Objects

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Button buttonRegister;
    private Button buttonLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }




    @Override
    public void onClick(View view) {

        //initializing Firebase database
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference userRef = db.getReference("Users");

        //Catch values in EditText
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        //Figure out which button has been clicked
        if (view == buttonLogin) {
            //Call the signin method
            signIn(email, password);
        } else if (view == buttonRegister) {
            //Call the createAccount method
            createAccount(email, password);
            //Additionally, create an initial record in the User object with user's email populated
            //they can then edit other fields in "Edit Profile" activity
            User newUser = new User("", "", email, "");
            userRef.push().setValue(newUser);


        }
    }


    public void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // If signin fails, display a message to the user. If signin succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Registration Failed",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Registration Successful",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        // If signin fails, display a message to the user. If signin succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Authentication Failed",
                                    Toast.LENGTH_SHORT).show();
                                       } else {
                            Toast.makeText(LoginActivity.this, "Authentication Successful",
                                    Toast.LENGTH_SHORT).show();
                            Intent intentHome = new Intent(LoginActivity.this, ActivityHome.class);
                            LoginActivity.this.startActivity(intentHome);
                        }
                    }
                });
    }


}
