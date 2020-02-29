package thenewboston.com;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import thenewboston.com.savingthings.MainActivity;
import thenewboston.com.savingthings.R;

public class FileContent extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView content=(TextView)findViewById(R.id.content);

        BufferedReader rett=null;
        // TextView large=(TextView)findViewById(R.id.large);
        StringBuffer result=new StringBuffer();
        try {
            FileInputStream fin = openFileInput(file_name);
            rett = new BufferedReader(new InputStreamReader(fin));
            //StringBuffer sb=new StringBuffer();
            String line;

            while ((line = rett.readLine()) != null) {
                result.append(line + "\n");
            }
            content.setText(result.toString());
            content.setVisibility(View.VISIBLE);



        }
        catch(IOException e)
        {

        }

        /*AlertDialog.Builder fileDialog=new AlertDialog.Builder(this);
        fileDialog.setView(content);
        fileDialog.setPositiveButton("OK", null);
        fileDialog.show();*/

    }

}
