package com.example.promamukherjee.bsproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Arrays;


public class ListActivity extends AppCompatActivity {
    TextView sub_name;
    TextView sub_code;
    TextView tm;
    TextView fac_name;


    String[] codes = {"A", "B", "C", "D", "E", "F", "G", "P1", "P2", "P3"};
    String[] names = {"Probability", "Microprocessors", "Architecture", "Aptitude", "Algorithms", "Java", "Electronics", "P-ALG1", "P-ALG2", "P-ALG3"};
    String[] times = {"8.00-8.50", "8.00-8.50", "8.00-8.50", "8.00-8.50", "8.00-8.50", "8.00-8.50", "8.00-8.50", "8.00-8.50", "8.00-8.50", "8.00-8.50"};
    String[] faculty = {"Teacher1", "Teacher2", "Teacher3", "Teacher4", "Teacher5", "Teacher6", "Teacher7", "Teacher8", "Teacher9", "Teacher10"};

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new country().execute();


    }


    class CustomAdapter extends BaseAdapter {

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public int getCount() {
            return faculty.length;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.list_item, null);

            sub_name = (TextView) view.findViewById(R.id.sub_name);
            tm = (TextView) view.findViewById(R.id.tm);
            fac_name = (TextView) view.findViewById(R.id.fac_name);
            sub_code = (TextView) view.findViewById(R.id.sub_code);


            sub_name.setText(names[i]);
            sub_code.setText(codes[i]);
            tm.setText(times[i]);
            fac_name.setText(faculty[i]);


            return view;
        }
    }


    class country extends AsyncTask<Void, Void, Void> {
        private final ProgressDialog dialog = new ProgressDialog(ListActivity.this);

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
               String [] names = new String[countrylist.length];
                for (i = 0; i < countrylist.length; i++) {

                    names[i] = Arrays.asList(countrylist[i].Country).toString();
                    names[i] = cutString(names[i]);
                    System.out.println("stringarray: " + names[i]);
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


        public String cutString(String s) {

            return s.substring(27);
        }

        @Override
        protected void onPostExecute(Void result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            listmeth();
        }


    }

    public void listmeth() {

        lv = (ListView) findViewById(R.id.list);

        CustomAdapter customAdapter = new CustomAdapter();
        lv.setAdapter(customAdapter);
    }
}