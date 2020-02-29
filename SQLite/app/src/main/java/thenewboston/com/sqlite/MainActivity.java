package thenewboston.com.sqlite;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
   // EditText name;
    EditText content;
    DBHandler dbHandler;
    Button addToList;
    EditText enterName;
    String filename;
    AlertDialog.Builder dialog;
  //  TextView textView;
   //EditText numstars;
    ListItem ob;
    ArrayList<ListItem> ls;
    ListAdapter listAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        content = (EditText)findViewById(R.id.content);
        content.getBackground().setAlpha(50);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ls=new ArrayList<>();

        enterName = new EditText(this);


        addToList = (Button)findViewById(R.id.addToList);

        addToList.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(final View v)
            {


                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setView(enterName);
                dialog.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        filename = enterName.getText().toString();
                        addToDB(v);
                    }

                });

                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                    }

                }).create();





                dialog.show();
            }

        });

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

    public void addToDB(View view)
    {
        float n=0;
       // name=(EditText)findViewById(R.id.name) ;
        content=(EditText)findViewById(R.id.content);


        dbHandler=new DBHandler(this);
        String formattedDate= DateFormat.getDateTimeInstance().format(new Date());

        // date name content
        ListItem listItem =new ListItem(formattedDate, filename, content.getText().toString());
        dbHandler.addObject(listItem);




    }
    public void goToSaved(View view)
    {
       /* textView=(TextView)findViewById(R.id.textView);

        String dbString;
        dbString=dbHandler.dataBaseToString();
        textView.setText(dbString);
        System.out.println("SHOWN");
        */

        Intent showIntent = new Intent(this, Score_list.class);
        startActivity(showIntent);

    }


}
