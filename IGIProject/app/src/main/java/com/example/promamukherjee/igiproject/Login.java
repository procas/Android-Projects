package com.example.promamukherjee.igiproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button login_btn;
    TextView forgotPass;
    String logPass;
    String logID;
    String loggedPass;
    String loggedID;
    EditText pass;
    EditText id;
    Button reg_btn;
    AlertDialog.Builder ad;
    SharedPreferences sp;

    Intent toPalin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        login_btn=(Button)findViewById(R.id.login_btn);
        reg_btn=(Button)findViewById(R.id.register);
        pass=(EditText)findViewById(R.id.pass);
        id=(EditText)findViewById(R.id.id);

        toPalin=new Intent(Login.this, Palindrome.class);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loggedPass=pass.getText().toString();
                loggedID=id.getText().toString();


                sp= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                logID=sp.getString("Email", "");
                logPass=sp.getString("Pass", "");

                if(loggedPass.equals(logPass) && loggedID.equals(logID)) {
                    //
                    startActivity(toPalin);


                }
                else
                {
                    ad=new AlertDialog.Builder(Login.this, android.R.style.Theme_Material_Dialog_Alert);
                    ad.setTitle("Invalid Login credentials");
                    ad.setPositiveButton("OK", new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog,int which)
                        {
                            //


                        }
                    });

                    ad.show();
                }
            }
        });


    }

}
