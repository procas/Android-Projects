package com.example.promamukherjee.igiproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Palindrome extends AppCompatActivity {
TextView st;
Button bt;
EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_palindrome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        st=(TextView)findViewById(R.id.st);
        num=(EditText)findViewById(R.id.num);
        bt=(Button)findViewById(R.id.bt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st.setText("Button clicked");

               if(checkPalin(Integer.parseInt(num.getText().toString()))==true)
                {
                    st.setText("Palindrome");
                }
                else
                    st.setText("Not Palindrome");
            }
        });

    }

    //check for palindrome

    public boolean checkPalin(int n)
    {
        int num=n;
        int rev=0;
       while(n!=0)
       {
           int d=n%10;
           rev= rev*10+d;
           n/=10;
       }
       if(rev==num)
           return true;
       else
           return false;
    }

}
