package com.example.promamukherjee.testjson;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.Arrays;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    String[] stringArray, stringArray2;
    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new country().execute();
    }

//Asynctask class for webservice to populate first spinner


    class country extends AsyncTask<Void, Void, Void> {
        private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Loading data");
            this.dialog.show();
        }

        @Override
        protected Void doInBackground(Void... unused) {

            String SOAP_ACTION = "http://bestsolutions.co.in/Webservices/Timetable/SateLists_in_XML_format";
            String METHOD_NAME = "SateLists_in_XML_format";
            String NAMESPACE = "http://bestsolutions.co.in/Webservices/Timetable/";
            String URL = "http://bestsolutions.co.in/Webservices/Timetable/BS_Service_misc.asmx";

            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            Bean C = new Bean();
            PropertyInfo pi = new PropertyInfo();
            pi.setName("Bean");
            pi.setValue(C);
            pi.setType(C.getClass());
            Request.addProperty(pi);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;

            envelope.setOutputSoapObject(Request);
            envelope.addMapping(NAMESPACE, "Bean", new Bean().getClass());
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.debug = true;

            try {
                System.out.println("Request:" + Request);
                androidHttpTransport.call(SOAP_ACTION, envelope);
                SoapObject response = (SoapObject) envelope.getResponse();
                System.out.println("MainActivity.onCreate()" + response);
                envelope.addMapping(NAMESPACE, "Bean", new Bean().getClass());
                androidHttpTransport.call(SOAP_ACTION, envelope);
                Bean[] countrylist = new Bean[response.getPropertyCount()];

                for (int j = 0; j < countrylist.length; j++) {
                    SoapObject pii = (SoapObject) response.getProperty(j);
                    Bean beanobject = new Bean();
                    beanobject.Country = pii.toString();
                    countrylist[j] = beanobject;
                    System.out.println("person: " + beanobject.Country);
                }

                int i = 0;
                stringArray = new String[countrylist.length];
                for (i = 0; i < countrylist.length; i++) {

                    stringArray[i] = Arrays.asList(countrylist[i].Country).toString();
                    stringArray[i]=cutString(stringArray[i]);
                    System.out.println("stringarray: " + stringArray[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        public String cutString(String s)
        {
            String st="";
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)>='A' && s.charAt(i)<='Z')
                    st=st+s.charAt(i);
                else
                    i++;
            }
            return st;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            spinner1meth();
        }
    }

//Method for populating spinner 1

    public void spinner1meth() {

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArray);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                country = (String) parent.getItemAtPosition(pos);

            //    new state().execute();

            }
        });
    }
}
