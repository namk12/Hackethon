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

public class GroupRegistration extends AppCompatActivity {

    private EditText eName, eEmail, eMobile, eCollege, eTeamName, eMember2, eMember3, eMember4, eMember5;
    private String name="", email="", mobile="", college="",team_name="", member2="", member3="", member4="",member5="";
    AlertDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_registration);

        eName = (EditText) findViewById(R.id.eName);
        eEmail = (EditText) findViewById(R.id.eEmail);
        eCollege = (EditText) findViewById(R.id.eCollege);
        eMobile = (EditText) findViewById(R.id.eMobile);
        eTeamName = (EditText) findViewById(R.id.eTeamName);
        eMember2 = (EditText) findViewById(R.id.eMember2);
        eMember3 = (EditText) findViewById(R.id.eMember3);
        eMember4 = (EditText) findViewById(R.id.eMember4);
        eMember5 = (EditText) findViewById(R.id.eMember5);

    }

    public void buttonGroupRegister(View view){

        name = eName.getText().toString().trim();
        email = eEmail.getText().toString().trim();
        mobile = eMobile.getText().toString();
        college = eCollege.getText().toString().trim();
        team_name = eTeamName.getText().toString().trim();
        member2 = eMember2.getText().toString().trim();
        member3 = eMember3.getText().toString().trim();
        member4 = eMember4.getText().toString().trim();
        member5 = eMember5.getText().toString().trim();

        if(connectionAvailable()){

            if(name.equals("") || email.equals("") || college.equals("") ||
                    mobile.equals("") || team_name.equals("") || member2.equals("")){

                Toast.makeText(GroupRegistration.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();

            }else{

                BackendlessUser user = new BackendlessUser();
                user.setProperty("register","GROUP"); //Has to be fixed
                user.setPassword("123"); //Default Password required
                user.setProperty("name", name);
                user.setEmail(email);
                user.setProperty("teamName", team_name);
                user.setProperty("collegeName", college);
                user.setProperty("mobile", mobile);
                user.setProperty("member2",member2);
                user.setProperty("member3",member3);
                user.setProperty("member4",member4);
                user.setProperty("member5",member5);

                progressDialog = new SpotsDialog(GroupRegistration.this, R.style.Custom);
                progressDialog.show();

                Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser backendlessUser) {
                        Toast.makeText(GroupRegistration.this, "Please confirm your E-mail address",
                                Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();

                        Intent i=new Intent(GroupRegistration.this,SplashTest.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {

                        Toast.makeText(GroupRegistration.this, "Error: " +backendlessFault.getMessage(),
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
