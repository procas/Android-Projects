package thenewboston.com.listofitems;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
String found="";
    final Bundle savedInstanceState=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView lv=(ListView)findViewById(R.id.listView);
        final Button f=(Button)findViewById(R.id.f);
        final Button s=(Button)findViewById(R.id.s);

       // Intent.createChooser(e, "Sending via...");
        //ImageView image=(ImageView)findViewById(R.id.image)


      //  final SearchView sv=(SearchView)findViewById(R.id.search);

        final String faculty[]={"TEACHER1", "TEACHER2", "TEACHER3", "TEACHER4", "TEACHER5","TEACHER6", "TEACHER7", "TEACHER8", "TEACHER9", "TEACHER10", "TEACHER11", "TEACHER12", };
        final String staff[]={"STAFF1", "STAFF2", "STAFF3", "STAFF4", "STAFF5"};
        final ArrayAdapter<String> ad1=new ArrayAdapter<String>(this, R.layout.sr, faculty);
        final ArrayAdapter<String> ad2=new ArrayAdapter<String>(this, R.layout.sr, staff);
        //final ArrayAdapter<String> newAdapter= new ArrayAdapter<String>(this, R.layout.sr, newArr);
        final Intent intent1=new Intent(this, TEACHER1.class);




            f.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        lv.setAdapter(ad1);




                    }
                }
        );


        s.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View view) {
                        lv.setAdapter(ad2);


                    }




                    }

        );
        lv.setOnItemClickListener(
                new ListView.OnItemClickListener()
                {
                    public void onItemClick(AdapterView<?> parent, View view, int position,
                                            long id)
                    {
                       // MainActivity ma=new MainActivity();

                        Object o=lv.getItemAtPosition(position);
                        if(o.toString().equals("TEACHER1"))
                        {
                            //open Teacher1's profile
                           startActivity(intent1);
                        }
                        if(o.toString().equals("TEACHER2"))
                        {

                            //open Teacher2's profile
                        }
                        if(o.toString().equals("TEACHER3"))
                        {
                            //open Teacher3's profile
                        }
                        if(o.toString().equals("TEACHER4"))
                        {
                            //open Teacher4's profile
                        }
                        if(o.toString().equals("TEACHER5"))
                        {
                            //open Teacher5's profile

                        }

                    }



                }
        );


    }


    }


