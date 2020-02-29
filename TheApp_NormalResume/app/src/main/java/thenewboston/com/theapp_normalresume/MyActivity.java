package thenewboston.com.theapp_normalresume;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

public class MyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent calWeb,marWeb,lisWeb,atWeb,savWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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




    }

    public void openMar(View view)
    {
        marWeb=new Intent(MyActivity.this, WebMar.class);
        startActivity(marWeb);
    }
    public void openCal(View view)
    {
        calWeb=new Intent(MyActivity.this, WebCal.class);
        startActivity(calWeb);
    }
    public void openSav(View view)
    {
        savWeb=new Intent(MyActivity.this, Web_Sav.class);
        startActivity(savWeb);
    }
    public void openLis(View view)
    {
        lisWeb=new Intent(MyActivity.this, WebLis.class);
        startActivity(lisWeb);
    }
    public void openAt(View view)
    {
        atWeb=new Intent(MyActivity.this, WebAt.class);
    }

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
        // Handle navigation view item clicks here.

        TableLayout tableLayout=(TableLayout)findViewById(R.id.tab);
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        }  if (id == R.id.other) {

            tableLayout.setVisibility(View.VISIBLE);

        }
        else tableLayout.setVisibility(View.INVISIBLE);
        if (id == R.id.nav_slideshow) {

        }  if (id == R.id.nav_manage) {

        }  if (id == R.id.nav_share) {

        }  if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
