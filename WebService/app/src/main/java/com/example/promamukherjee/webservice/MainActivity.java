package com.example.promamukherjee.webservice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.promamukherjee.webservice.ConvertArray;
import com.example.promamukherjee.webservice.ConstantString;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class MainActivity extends Activity {

    TextView text;
    String result;
    SoapSerializationEnvelope envelope;
    SoapPrimitive response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text=(TextView)findViewById(R.id.text);


      ConvertArray ca=new ConvertArray(this, ConstantString.SOAP_ACTION, ConstantString.METHOD);

//      ca.onPostExecute(response.toString());
        try {
            ca.execute("http://hellodurgapur.com/").execute(text.getText().toString());
        }
        catch (Exception e)
        {
            System.out.println("Error caught");
        }


    }


    //create and execute asynctask to get response from W3school server



    //call back data from background thread and set to views
    public void callBackDataFromAsyncTask(String result) {


        text=(TextView)findViewById(R.id.text);
        text.setText(result);


    }


}