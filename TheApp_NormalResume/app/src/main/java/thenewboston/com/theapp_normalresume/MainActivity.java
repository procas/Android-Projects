package thenewboston.com.theapp_normalresume;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     *
     *
     */

    Intent myAct;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void openMy(View view)
    {
       myAct=new Intent(MainActivity.this, MyActivity.class);
        startActivity(myAct);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            RelativeLayout relativeLayout=(RelativeLayout)rootView.findViewById(R.id.rel);
            TextView textView1=(TextView)rootView.findViewById(R.id.details);
            TableLayout tableLayout=(TableLayout)rootView.findViewById(R.id.tab);
            TextView sk=(TextView)rootView.findViewById(R.id.skill);
            ImageView img=(ImageView)rootView.findViewById(R.id.mypic);
            if(getArguments().getInt(ARG_SECTION_NUMBER)==1) {

                textView.setText("CLICK ME");
                textView1.setText("Name: Proma Mukherjee\nHighest Qualification: Btech, CSE (2016-19)");
                img.setVisibility(View.VISIBLE);
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.rose));
                relativeLayout.getBackground().setAlpha(110);
            }else {
                textView.setVisibility(View.INVISIBLE);
                img.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.INVISIBLE);
            }

            if(getArguments().getInt(ARG_SECTION_NUMBER)==2) {
                sk.setText("\"1. JAVA\n\n\n2. ANDROID\n\n\n3. C\n\n\n4. C++\n\n\n5. PYTHON\n\n\n6. HTML, CSS, JS\n\n\n7. PhP\n\n\n8. D-BASE MANAGEMENT\n\n\n9. CLOUD COMPUTING\n\n\n10. ALGORITHM AND SEQUENCES\n\n\n11. BINARY MANIPULATION\n\n\n12. ASSEMBLY LANGUAGE\n\n\n13. COBOL");
                relativeLayout.setBackgroundColor(Color.parseColor("#FFFBB9B9"));

            }else
            sk.setVisibility(View.INVISIBLE);


            if(getArguments().getInt(ARG_SECTION_NUMBER)==3) {
                tableLayout.setVisibility(View.VISIBLE);
                relativeLayout.setBackgroundColor(Color.parseColor("#a5e7fd"));

            }
            else
            tableLayout.setVisibility(View.INVISIBLE);

           // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "INTRODUCTION";
                case 1:
                    return "SKILLS";
                case 2:
                    return "QUALIFICATION";
            }
            return null;
        }
    }
}
