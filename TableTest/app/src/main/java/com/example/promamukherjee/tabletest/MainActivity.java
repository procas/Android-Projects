package com.example.promamukherjee.tabletest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TableLayout table;
    String[][] mat={{"HOUR/DAY","|8.00-8.50|","8.50-9.40|","8.50-9.40|","8.50-9.40|","8.50-9.40|","8.50-9.40|","8.50-9.40|","8.50-9.40|","8.50-9.40|"},
                       {"DAY1","SUB1","SUB2","SUB3","SUB4","SUB5","SUB6","SUB7","SUB8","SUB9","SUB10"},
            {"DAY2","SUB1","SUB2","SUB3","SUB4","SUB5","SUB6","SUB7","SUB8","SUB9","SUB10"},
            {"DAY3","SUB1","SUB2","SUB3","SUB4","SUB5","SUB6","SUB7","SUB8","SUB9","SUB10"},
            {"DAY4","SUB1","SUB2","SUB3","SUB4","SUB5","SUB6","SUB7","SUB8","SUB9","SUB10"},
            {"DAY5","SUB1","SUB2","SUB3","SUB4","SUB5","SUB6","SUB7","SUB8","SUB9","SUB10"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        table=(TableLayout)findViewById(R.id.table);
        new country().execute();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void fillTable(final int n, final String[][] matrix, TableLayout table) {
        table.removeAllViews();

        for (int i = 0; i < 5; i++) {
            TableRow row = new TableRow(MainActivity.this);



            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.FILL_PARENT));

            for (int j = 0; j < 10; j++) {
                TextView edit = new TextView(MainActivity.this);
               // edit.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_NUMBER_FLAG_SIGNED);
                edit.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                edit.setText((matrix[i][j]));
                edit.setPadding(0, 15, 0, 15);
                edit.setTextSize(15);


                edit.setKeyListener(null);
                row.addView(edit);
            }

            table.addView(row);

        }
        table.setVisibility(View.VISIBLE);

    }




    class country extends AsyncTask<Void, Void, Void> {

        String[][] matrix;
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

               //countrylist[i].Country.toString()

                int i = 0;
                matrix = new String[countrylist.length][10];
                for (i = 0; i < countrylist.length; i++) {

                    matrix[i][i] = Arrays.asList(countrylist[i].Country).toString().replace("[", "").replace("]", "");
                    matrix[i][i]=cutString(matrix[i][i], matrix);
                    System.out.println("stringarray: " + matrix[i]);
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


        public String cutString(String s, String m[][])
        {
            for(int i=0;i<m[0].length;i++)
            {
                for(int j=0;i<m[1].length;i++)
                {
                    if(m[i][j]==" ") m[i][j]="blank";
                }
            }
            return s.substring(27);
        }

        @Override
        protected void onPostExecute(Void result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            tablemeth();
        }
    }

    public void tablemeth() {


        TableLayout table=(TableLayout)findViewById(R.id.table);

        fillTable(3,mat, table);
        table.setGravity(Gravity.CENTER);
        table.setPadding(20,0,20,20);
    }
}
