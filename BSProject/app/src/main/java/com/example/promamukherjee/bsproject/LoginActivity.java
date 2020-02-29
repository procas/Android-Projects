package com.example.promamukherjee.bsproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.os.AsyncTask;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.content.ContentValues.TAG;


public class LoginActivity extends AppCompatActivity implements TaskCompleted {

    Button login_btn;
    TextView forgotPass;
    String logPass="Proma";
    String logID="478";
    String loggedPass;
    String loggedID;
    EditText pass;
    EditText id;
    Button reg_btn;
    AlertDialog.Builder ad;
    Intent tableIntent;
    Intent resIntent;
    Intent regIntent;
    TextView celcius;
    ToggleButton eye;
    int response=0;
    static String fin;


    AsyncCallWS task = new AsyncCallWS(this);



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
        eye=(ToggleButton) findViewById(R.id.eye);


        /*this is temporary**/
        //celcius=(TextView)findViewById(R.id.celcius);



        tableIntent=new Intent(LoginActivity.this, MainActivity.class);
        resIntent=new Intent(LoginActivity.this, ResetActivity.class);
        regIntent=new Intent(LoginActivity.this, RegisterActivity.class);
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regIntent);
            }
        });



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loggedPass=pass.getText().toString();
                loggedID=id.getText().toString();


                task.execute();

                pass.setText("");
                id.setText("");
            }
        });

        forgotPass=(TextView)findViewById(R.id.forgotPass);
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(resIntent);
            }
        });


        //start with hiding password

        pass.setTransformationMethod(new PasswordTransformationMethod());
        eye.setBackgroundResource(R.drawable.show_password);

       eye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b)
               {

                   //show password
                   pass.setTransformationMethod(new HideReturnsTransformationMethod());
                   eye.setBackgroundResource(R.drawable.hide_password);

               }
               else
               {

                   //hide password

                   pass.setTransformationMethod(new PasswordTransformationMethod());
                   eye.setBackgroundResource(R.drawable.show_password);
               }
           }
       });

    }

    @Override
    public void onTaskCompleted(String values) {
        if(values.equals("1")) {

            // login successful
            startActivity(tableIntent);

        }
        else if(values.equals("0"))//login unsuccessful
        {
            ad=new AlertDialog.Builder(LoginActivity.this, android.R.style.Theme_Material_Dialog_Alert);
            ad.setTitle("Invalid credentials");
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


    class AsyncCallWS extends AsyncTask<String, String, String> {
        SoapObject request;
        String result;

        TaskCompleted listener;

        public AsyncCallWS(TaskCompleted listener)
        {
             this.listener=listener;
        }



        public String calculate() {

            String SOAP_ACTION = "http://bestsolutions.co.in/Webservices/Timetable/Validate_user";
            String METHOD_NAME = "Validate_user";
            String NAMESPACE = "http://bestsolutions.co.in/Webservices/Timetable/";
            String URL = "http://bestsolutions.co.in/Webservices/Timetable/BS_Service_misc.asmx";


            request=new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("user_id", loggedID);
            request.addProperty("password", loggedPass);


            // request.addProperty("Celsius", getCel);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(URL);




            try {

                ht.call(SOAP_ACTION, envelope);

                if (envelope.bodyIn instanceof SoapFault) {
                    result = ((SoapFault) envelope.bodyIn).faultstring;
                } else {
                    SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
                    result = resultsRequestSOAP.getProperty(0).toString();
                }

                Log.i(TAG, "result: " + result);
                return result;

            }catch (Exception ex) {
                Log.e(TAG, "Error: " + ex.getMessage());
            }
            return result;
        }



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(TAG, "onPreExecute");
        }

        @Override
        protected String doInBackground(String... params) {

            return calculate();
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s==null) Toast.makeText(LoginActivity.this,"NULL", Toast.LENGTH_LONG).show();
            else
            {
                Log.i(TAG, "onPostExecute");
                Toast.makeText(LoginActivity.this, "Response is " + s, Toast.LENGTH_LONG).show();
               // celcius.setText(s);
                listener.onTaskCompleted(s);


            }

        }
    }

}
            interface TaskCompleted{
            void onTaskCompleted(String values);
        }


