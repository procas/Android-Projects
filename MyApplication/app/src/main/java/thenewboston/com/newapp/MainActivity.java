package thenewboston.com.newapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
 TextView facTab=null, stTab=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ListView lv=(ListView)findViewById(R.id.listView);
        facTab=(TextView)findViewById(R.id.facTab);
        stTab=(TextView)findViewById(R.id.stTab);


        String facultyNames[]={"f1","f2","f3"};
        String staffNames[]={"s1","s2","s3"};

        final ArrayList<String> facName=new ArrayList<String>();
        facName.addAll(Arrays.asList(facultyNames));
        final ArrayList<String> stName=new ArrayList<String>(Arrays.asList(staffNames));

        final ArrayAdapter<String> ad1=new ArrayAdapter<String>(this, R.layout.simple, facultyNames);
        final ArrayAdapter<String> ad2=new ArrayAdapter<String>(this, R.layout.simple, staffNames);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        lv.setAdapter(ad1);

        facTab.setOnClickListener(
                new TextView.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        lv.setAdapter(ad1);
                    }
                }
        );
        stTab.setOnClickListener(
                new TextView.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        lv.setAdapter(ad2);
                    }
                }
        );



    }



    @Override
    public String[] fileList() {
        return super.fileList();
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
}
