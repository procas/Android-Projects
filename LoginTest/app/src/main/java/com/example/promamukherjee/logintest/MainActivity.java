package com.example.promamukherjee.logintest;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class MainActivity extends AppCompatActivity {

    String TAG = "Response";
    Button bt;
    EditText celcius;
    String getCel;
    SoapObject resultString;
    SoapObject request;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.bt);
        celcius = (EditText) findViewById(R.id.cel);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getCel = celcius.getText().toString();
                AsyncCallWS task = new AsyncCallWS();
                task.execute();
            }
        });
    }

    private class AsyncCallWS extends AsyncTask<String, Void, String> {

        public String calculate() {

            String SOAP_ACTION = "http://bestsolutions.co.in/Webservices/Timetable/HelloWorld";
            String METHOD_NAME = "HelloWorld";
            String NAMESPACE = "http://bestsolutions.co.in/Webservices/Timetable/";
            String URL = "http://bestsolutions.co.in/Webservices/Timetable/BS_Service_misc.asmx";


            try {
                request=new SoapObject(NAMESPACE, METHOD_NAME);
               // request.addProperty("Celsius", getCel);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE ht = new HttpTransportSE(URL);

                ht.call(SOAP_ACTION, envelope);
                // SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
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
            if(s==null) Toast.makeText(MainActivity.this,"NULL", Toast.LENGTH_LONG).show();
            else
            {
                Log.i(TAG, "onPostExecute");
                Toast.makeText(MainActivity.this, "Response is " + s, Toast.LENGTH_LONG).show();
                celcius.setText(s);
            }
        }
    }


}
