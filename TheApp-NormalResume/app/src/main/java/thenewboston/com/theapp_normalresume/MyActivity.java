package thenewboston.com.theapp_normalresume;

import android.app.ListActivity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;


import org.w3c.dom.Text;

public class MyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent calcActivity, marActivity;
    Intent calWeb,marWeb,lisWeb,atWeb,savWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.detail_area);
        //relativeLayout.setBackgroundColor(Color.parseColor("#FFA6E0FD"));
        TextView aspiration=(TextView)findViewById(R.id.asp);
        TextView str=(TextView)findViewById(R.id.stren) ;
        TableLayout tableLayout=(TableLayout)findViewById(R.id.tab);
        ScrollView scrollView=(ScrollView)findViewById(R.id.scroll);
        HorizontalScrollView horizontalScrollView=(HorizontalScrollView)findViewById(R.id.horizontalScrollView);
        TextView textView=(TextView)findViewById(R.id.intro) ;
        ImageButton calling=(ImageButton)findViewById(R.id.call);
        ImageButton mailing=(ImageButton)findViewById(R.id.mail);

        View div=(View)findViewById(R.id.div);


       // ScrollView scrollView1=(ScrollView)findViewById(R.id.vert);
        textView.setText("Hello, this is a short introduction to my personal details, including my Aspirations, Reasons for choosing Accenture Pvt. Ltd., as well as " +
                "4shared links to apps I had previously built. Necessary contact and reference details are also duly provided.\n\n\n--Thankyou.");




        //aspiration.setVisibility(View.INVISIBLE);
        //str.setVisibility(View.INVISIBLE);
        tableLayout.setVisibility(View.INVISIBLE);
       // div.setVisibility(View.INVISIBLE);
       calling.setVisibility(View.INVISIBLE);
        mailing.setVisibility(View.INVISIBLE);
       // scrollView.setVisibility(View.INVISIBLE);
       // horizontalScrollView.setVisibility(View.INVISIBLE);



       // ScrollView scrollView1=new ScrollView(this);





       // textView.setVisibility(View.VISIBLE);

        //scrollView.setVisibility(View.VISIBLE);



        //ScrollView scrollView1=(ScrollView)findViewById(R.id.);

       // relativeLayout.removeView(relativeLayout);

        //relativeLayout.addView(scrollView);








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        calcActivity=new Intent(MyActivity.this, CalActivity.class);
        marActivity=new Intent(MyActivity.this, MarActivity.class);
    }


    public void openMar(View view)
    {
        marWeb=new Intent(MyActivity.this, MarActivity.class);
        startActivity(marWeb);
    }
    public void openCal(View view)
    {
        calWeb=new Intent(MyActivity.this, CalActivity.class);
        startActivity(calWeb);
    }
    public void openSav(View view)
    {
        savWeb=new Intent(MyActivity.this, SavActivity.class);
        startActivity(savWeb);
    }
    public void openLis(View view)
    {
        lisWeb=new Intent(MyActivity.this, LisActivity.class);
        startActivity(lisWeb);
    }
    public void openAt(View view)
    {
        atWeb=new Intent(MyActivity.this, AtActivity.class);
    }









  /*  public void openCalc(View view)
    {

        startActivity(calcActivity);
    }
    */




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.detail_area);
        TextView aspiration=(TextView)findViewById(R.id.asp);
        TextView textView=(TextView)findViewById(R.id.intro) ;
        TextView textView1=(TextView)findViewById(R.id.contact);
        TextView str=(TextView)findViewById(R.id.stren) ;
        TableLayout tableLayout=(TableLayout)findViewById(R.id.tab);
        ScrollView scrollView=(ScrollView)findViewById(R.id.scrollView) ;
        View div=(View)findViewById(R.id.div);
        ImageButton calling=(ImageButton)findViewById(R.id.call);
        ImageButton mailing=(ImageButton)findViewById(R.id.mail);


        //ScrollView scrollView=(ScrollView)findViewById(R.id.scroll);
        HorizontalScrollView horizontalScrollView=(HorizontalScrollView)findViewById(R.id.horizontalScrollView);

       textView.setVisibility(View.INVISIBLE);


        str.setText("1. I am usually quite persistent, be it with coding or with real-life situations, until they're solved\n\n" +
                "2. I am into perfection\n\n3.I am known for my punctilious planning and algorithmic skills.\n\n4. I am" +
                " also known for my skills in handling time.\n\n4. I am quick to imbibe new Programming concepts");
        ImageView img=(ImageView)findViewById(R.id.image);
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.aspirations) {
            // Handle the camera action
            relativeLayout.setBackgroundColor(Color.YELLOW);
            aspiration.setText("I aspire to become an applications architect in the near future. I have loved coding ever since I've " +
                    "first made aquaintances with the same, in my ninth grade in school. I loved Java since a very young age, and " +
                    "have been very fond of programming ever since. I am known for my algorithmic preciseness and creativity. I very much look" +
                    " forward to working " +
                    "in your company.");

            aspiration.setVisibility(View.VISIBLE);
            //relativeLayout.addView(aspiration);


        }else

        aspiration.setVisibility(View.INVISIBLE);
         if (id == R.id.strength) {
            //img.setVisibility(View.VISIBLE);
             relativeLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
             scrollView.setBackground(getDrawable(R.drawable.mypic));
             //relativeLayout.getBackground().set
             str.setVisibility(View.VISIBLE);
             relativeLayout.getBackground().setAlpha(120);

            // View backgroundImage = findViewById(R.id.detail_area);
             //Drawable background = backgroundImage.getBackground();

             //background.setAlpha(120);





        } else str.setVisibility(View.INVISIBLE);

        if(id==R.id.other_apps)
         {

            // scrollView.setVisibility(View.VISIBLE);
            // horizontalScrollView.setVisibility(View.VISIBLE);
            relativeLayout.setBackgroundColor(Color.parseColor("#f7d3e1"));
             TableLayout tableLayout1=(TableLayout)findViewById(R.id.tab);
             tableLayout1.setVisibility(View.VISIBLE);
         }
         else
        {
           tableLayout.setVisibility(View.INVISIBLE);
           // scrollView.setVisibility(View.INVISIBLE);
           // horizontalScrollView.setVisibility(View.INVISIBLE);
        }

         if (id == R.id.weaknesses) {

        }  if (id == R.id.why_accenture) {

        }  if (id == R.id.career_goals) {

        }  if (id == R.id.nav_send) {

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("image/application");
            intent.putExtra(Intent.EXTRA_EMAIL, true);



            Uri image=null;

            try
            {

                image=Uri.parse(MediaStore.Images.Media.insertImage(this.getContentResolver(), BitmapFactory.decodeResource(getResources(), R.drawable.me), null, null));


            }catch(android.content.ActivityNotFoundException e)
            {

            }
            intent.putExtra(Intent.EXTRA_STREAM, image);

            startActivity(intent);


        }
        if (id == R.id.contact) {


            div.setVisibility(View.VISIBLE);
            calling.setVisibility(View.VISIBLE);
            mailing.setVisibility(View.VISIBLE);
            mailing.getBackground().setAlpha(00);
            calling.getBackground().setAlpha(00);

           textView1.setText("REFERENCE#1: \nMR. SUBRATA MUKHERJEE\nDIRECTOR, THE DCL COMPANY(DURGAPUR)\n9933033803\n\n\nREFERENCE#2:" +
                   "\nMR. MANAS LAHA\nASST. PROFESSOR AT IIT KHARAGPUR, AERONAUTICS DEPT.\n9658214703\n\n\nMobile/Whatsapp:"+ "8016560289" +
            "\nEmail: 1. mailtoproma@gmail.com\n            2. diabolusregit@gmail.com\n            3. thedevilfound@gmail.com");
            relativeLayout.setBackgroundColor(Color.parseColor("#FFD9FA9D"));
            textView1.setVisibility(View.VISIBLE);


           // txt.se




        }
        else {

            calling.setVisibility(View.INVISIBLE);
            mailing.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.INVISIBLE);

        }

        if(id!=R.id.contact) div.setVisibility(View.INVISIBLE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
