package thenewboston.com.savingthings;

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
import java.text.SimpleDateFormat;

import thenewboston.com.ShowActivity;

public class MainActivity extends AppCompatActivity {

     String Message="", append="";StringBuilder result=null;
    public static String file_name;
    public EditText text;
    static EditText ed=null;
    static TextView nameFormat=null;
    String SavedFiles[]=null;
    TextView content; public Button save;
    public StringBuilder buff=null;
    Intent in; AlertDialog.Builder fileDialog=null;
    //public EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");
        text = (EditText) findViewById(R.id.text);
        text.getBackground().setAlpha(40);
        save = (Button) findViewById(R.id.save);
        Intent main = new Intent(MainActivity.this, MainActivity.class);

        //final Button open = (Button) findViewById(R.id.open);

        final RelativeLayout rel = (RelativeLayout) findViewById(R.id.rel);


        setSupportActionBar(toolbar);
        in = new Intent(this, ShowActivity.class);


        ed = new EditText(MainActivity.this);
        ed.setWidth(1000);
        nameFormat = new TextView(MainActivity.this);
        nameFormat.setText("Enter FileName:");


        fileDialog = new AlertDialog.Builder(MainActivity.this);

        RelativeLayout rell = new RelativeLayout(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lp1.addRule(RelativeLayout.CENTER_VERTICAL);
        lp.addRule(RelativeLayout.BELOW, nameFormat.getId());
        lp.setMargins(0, 150, 0, 0);
        lp1.setMargins(0, 0, 0, 05);

        nameFormat.setLayoutParams(lp1);
        ed.setLayoutParams(lp);


        if (ed.getParent() != null)
            ((ViewGroup) ed.getParent()).removeView(ed);
        rell.addView(ed, lp);
        if (nameFormat.getParent() != null)
            ((ViewGroup) nameFormat.getParent()).removeView(nameFormat);
        rell.addView(nameFormat, lp1);


        fileDialog.setView(rell);
        //fileDialog.setView(nameFormat);


        fileDialog.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {
                save.setVisibility(View.VISIBLE);


                Message = text.getText().toString();
                file_name = ed.getText().toString();
                if (!file_name.equalsIgnoreCase("")) {
                    try {
                        FileOutputStream fos = openFileOutput(file_name, Context.MODE_PRIVATE);
                        fos.write(Message.getBytes());
                        fos.close();


                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException n) {
                        n.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(), "MESSAGE SAVED!", Toast.LENGTH_LONG).show();
                } else

                    Toast.makeText(getApplicationContext(), "PLEASE ENTER A FILE NAME", Toast.LENGTH_LONG).show();
            }
        });
        fileDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {
            }

        }).create();

        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(in);
                    }
                }
        );


        save.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        if (save.getParent() != null)
                            ((ViewGroup) save.getParent()).removeView(save);


                        text = (EditText) findViewById(R.id.text);
                        Message = text.getText().toString();

                        fileDialog.show();


                    }

                });
    }


       public void sendMessage(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_TEXT, result.toString());
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                // finish();
            }


            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item)
            {
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

    public void exit(View view)
    {
        TextView ask=new TextView(this);
        ask.setText("DO YOU REALLY WISH TO EXIT?");

        AlertDialog.Builder fileDialog = new AlertDialog.Builder(this);
        //        content.setText(result);
        fileDialog.setView(ask);
        fileDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which)
            {
                Intent homeIntent=new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);

            }

        });
        fileDialog.setNegativeButton("NO", null);
        fileDialog.show();


    }


        }


