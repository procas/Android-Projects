package com.example.promamukherjee.bsproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    EditText newpass;
    EditText confnewpass;
    Button submit_new;
    AlertDialog.Builder ad;
    AlertDialog.Builder ad2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       newpass=(EditText)findViewById(R.id.newpass);
       confnewpass=(EditText)findViewById(R.id.confnewpass);
       submit_new=(Button)findViewById(R.id.submit_new);
       submit_new.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(newpass.getText().toString().matches("") || confnewpass.getText().toString().matches("")) {

                   ad2 = new AlertDialog.Builder(ResetActivity.this, android.R.style.TextAppearance_Theme_Dialog);
                   ad2.setTitle("Password fields cannot be empty");
                   ad2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int which) {
                           //
                       }
                   });
               }
               else {
                   if (newpass.getText().toString().equals(confnewpass.getText().toString())) {
                       Toast.makeText(ResetActivity.this, "AN OTP HAS BEEN SENT TO YOUR REGISTERED NUMBER", Toast.LENGTH_LONG).show();

                   } else {
                       ad = new AlertDialog.Builder(ResetActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                       ad.setTitle("Passwords do not match");
                       ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int which) {
                               //
                           }
                       });

                       ad.show();
                   }
               }
           }
       });


    }

}
