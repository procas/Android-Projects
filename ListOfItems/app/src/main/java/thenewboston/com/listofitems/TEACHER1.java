package thenewboston.com.listofitems;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TEACHER1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void sendMessage(View view)throws IOException
    {


        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        //Uri image=Uri.parse("file://"+"C:\\Users\\HP\\AndroidStudioProjects\\ListOfItems\\app\\src\\main\\res\\drawable\\teacher1.png");

        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri

                .parse("android.resource://"

                        + getPackageName() + "/" + R.drawable.teacher1));



        shareIntent.setType("image/png");
       // shareIntent.putExtra(Intent.EXTRA_STREAM, image);
        startActivity(Intent.createChooser(shareIntent, "Complete Action Using..."));
    }




}
