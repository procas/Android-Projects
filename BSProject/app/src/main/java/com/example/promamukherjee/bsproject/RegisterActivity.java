package com.example.promamukherjee.bsproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
Button reg_btn;
EditText name_reg;
EditText id_reg;
EditText pass_reg;
EditText conf_reg;
EditText phone_reg;
Button log;
String name;
String id;
String pass;
String confirm;
AlertDialog.Builder ad;
AlertDialog.Builder ad2;
Intent logIntent;
Intent sendOTPIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       reg_btn=(Button)findViewById(R.id.register);
       pass_reg=(EditText)findViewById(R.id.pass_reg);
       conf_reg=(EditText)findViewById(R.id.conf_reg);
       name_reg=(EditText)findViewById(R.id.name_reg);
       id_reg=(EditText)findViewById(R.id.id_reg);
       phone_reg=(EditText)findViewById(R.id.phone_reg);
       log=(Button) findViewById(R.id.log);
       logIntent=new Intent(RegisterActivity.this, LoginActivity.class);
       sendOTPIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "8016560289"));
        sendOTPIntent.putExtra("sms_body", "Hello");
        reg_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               // register


               name=name_reg.getText().toString();
               id=id_reg.getText().toString();
               pass=pass_reg.getText().toString();
               confirm=conf_reg.getText().toString();

               if(name_reg.getText().toString().matches("") || id_reg.getText().toString().matches("") || phone_reg.getText().toString().matches("")||
                       pass_reg.getText().toString().matches("") || conf_reg.getText().toString().matches(""))
               {

                   ad2 = new AlertDialog.Builder(RegisterActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                   ad2.setTitle("Please fill all essential fields");
                   ad2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int which) {
                           //
                       }
                   });

                   ad2.show();
               }
               else
                   {
                   if (pass.equals(confirm)) {


                       //startActivity(sendOTPIntent);
                       Toast.makeText(getApplicationContext(), "REGISTERED SUCCESSFULLY", Toast.LENGTH_LONG).show();


                   } else {
                       ad = new AlertDialog.Builder(RegisterActivity.this, android.R.style.Theme_Material_Dialog_Alert);
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
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(logIntent);
            }
        });

    }

}
