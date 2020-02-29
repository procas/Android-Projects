package thenewboston.com.attempt;

import java.io.*;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SwitchCompat;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //static final Switch switch1=new Switch(this);
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final Switch switch1=new Switch(this);
        final Button button=new Button(this);
        final Button button2=new Button(this);
        final RelativeLayout rel=new RelativeLayout(this);
        button2.setText("LIGHT/DARK");
        button.setText("FISH/DRAGON");
        TextView text=new TextView(this);

        text.setText("ON: FISH, LIGHT \n OFF: DRAGON, DARK");

        // setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


*/


        switch1.setBackgroundColor(Color.WHITE);
        RelativeLayout.LayoutParams switchDetails=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT );
        RelativeLayout.LayoutParams buttonDetails=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT );
        RelativeLayout.LayoutParams button2Details=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT );
        RelativeLayout.LayoutParams textDetails=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT );

        switchDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        switchDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.ABOVE, switch1.getId());

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        button2Details.addRule(RelativeLayout.CENTER_HORIZONTAL);
        button2Details.addRule(RelativeLayout.BELOW, button.getId());

        textDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
       // textDetails.addRule(RelativeLayout.BELOW, button2.getId());
        textDetails.addRule(RelativeLayout.BELOW, switch1.getId());
        // buttonDetails.addRule(RelativeLayout.ABOVE, button2.getId());

        buttonDetails.setMargins(0,0,50,50);
        button2Details.setMargins(50,100,0,0);
        //textDetails.setMargins(50,50,50,50);
        // button2Details.addRule(RelativeLayout.CENTER_VERTICAL);


        // buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);




        //switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener());



        button2.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        //switch1.setShowText(false);
                        if(switch1.isChecked()) {
                            switch1.setText("Light");
                            rel.setBackgroundColor(Color.parseColor("#6dddec"));
                        }
                        else {
                            switch1.setText("Dark");
                            rel.setBackgroundColor(Color.parseColor("#000000"));
                        }


                        // rel.setBackgroundColor(Color.BLACK);
                        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if(isChecked) {
                                    switch1.setText("Light");
                                    rel.setBackgroundColor(Color.parseColor("#6dddec"));
                                }
                                else {
                                    switch1.setText("Dark");
                                    rel.setBackgroundColor(Color.parseColor("#000000"));
                                    switch1.setBackgroundColor(Color.WHITE);
                                }
                                //switch1.setShowText(false);
                            }
                        });
                    }
                }
        );


        button.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        if(switch1.isChecked()) {
                            switch1.setText("Fish");
                            rel.setBackground(getDrawable(R.drawable.adapter));

                        }
                        else {
                            switch1.setText("Dragon");
                            rel.setBackground(getDrawable(R.drawable.dragon));
                        }

                        // rel.setBackground(getDrawable(R.drawable.dragon));
                        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                                if(isChecked)
                                {
                                    switch1.setText("Fish");
                                    rel.setBackground(getDrawable(R.drawable.adapter));
                                }
                                else {
                                    switch1.setText("Dragon");
                                    rel.setBackground(getDrawable(R.drawable.dragon));
                                    // switch1.setBackgroundColor(Color.WHITE);
                                }
                                //switch1.setShowText(false);
                            }
                        });
                    }
                }
        );



        rel.addView(switch1, switchDetails);
        rel.addView(button, buttonDetails);
        rel.addView(button2, button2Details);
       // rel.addView(text, textDetails);
        setContentView(rel);


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
