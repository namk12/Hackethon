package com.certination.hackethon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import dmax.dialog.SpotsDialog;

public class IndividualRegistration extends AppCompatActivity {

    private EditText etName, etEmail, etMobile, etCollege, etTeamName;
    private String name="", email="", mobile ="", college ="", team_name = "";
    AlertDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_registration);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etCollege = (EditText) findViewById(R.id.etCollege);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etTeamName = (EditText) findViewById(R.id.etTeamName);

    }

    public void buttonRegister(View view){

        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        mobile = etMobile.getText().toString();
        college = etCollege.getText().toString().trim();
        team_name = etTeamName.getText().toString().trim();

        if(connectionAvailable()){

            if(name.equals("") || email.equals("") || college.equals("") ||
                    mobile.equals("") || team_name.equals("")){

                Toast.makeText(getApplicationContext(), "Please enter all fields!", Toast.LENGTH_SHORT).show();

            }else{

                BackendlessUser user = new BackendlessUser();
                user.setProperty("register","SINGLE"); //Has to be fixed
                user.setPassword("123"); //Default Password required
                user.setProperty("name", name);
                user.setEmail(email);
                user.setProperty("teamName", team_name);
                user.setProperty("collegeName", college);
                user.setProperty("mobile", mobile);

                progressDialog = new SpotsDialog(IndividualRegistration.this, R.style.Custom);
                progressDialog.show();

                Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser backendlessUser) {
                        Toast.makeText(IndividualRegistration.this, "Please confirm your E-mail address",
                                Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();

                        Intent i=new Intent(IndividualRegistration.this,SplashTest.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {

                        Toast.makeText(IndividualRegistration.this, "Error: " +backendlessFault.getMessage(),
                                Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                });
            }
        }else{

            Toast.makeText(getApplicationContext(), "No internet connection, please connect first", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean connectionAvailable() {

        boolean connected = false;
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if(activeNetwork != null) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                connected = true;
            } else if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                connected = true;
            }
        }else {
            connected = false;
        }
        return connected;
    }

}