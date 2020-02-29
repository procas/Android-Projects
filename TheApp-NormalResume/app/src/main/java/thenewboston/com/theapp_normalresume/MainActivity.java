package thenewboston.com.theapp_normalresume;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
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

import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
     TextView txt=null;Intent startHtml,startMe, startJava, startJs, startPy;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ListView listView=new ListView(this);




       /* String []skills={"1. JAVA", "2. JAVASCRIPT", "3. CSS", "4. HTML/XML", "5. ANDROID PROGRAMMING", "6. PYTHON", "7. C/C++", "8. CLOUD COMPUTING AND MANAGEMENT", "9. DATABASE MANAGEMENT", "10. ALGORITHM AND SEQUENCING", "11. DATA ANALYSIS"};
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < skills.length; ++i) {
            list.add(skills[i]);
        }
        */
       //




        txt=new TextView(this);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Send/Share my Resume", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
        */
            startHtml=new Intent(MainActivity.this, HtmlActivity.class);
        startMe=new Intent(MainActivity.this, MyActivity.class);
        startJava=new Intent(MainActivity.this, JavaActivity.class);
        startJs=new Intent(MainActivity.this, JsActivity.class);
        startPy=new Intent(MainActivity.this, PyActivity.class);

    }


    public void changeToHtml(View view)
    {
      startActivity(startHtml);

    }
    public void changeToJava(View view)
    {
        startActivity(startJava);
    }
    public void changeToJs(View view)
    {
        startActivity(startJs);
    }
    public void changeToPy(View view)
    {
        startActivity(startPy);
    }

    public void aboutMe(View view)
    {
        startActivity(startMe);
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

        Intent startJava;
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
            Button txt=(Button) rootView.findViewById(R.id.myself);
           // HorizontalScrollView hs=(HorizontalScrollView)rootView.findViewById(R.id.horscroll);
           // ListView sk=(ListView) rootView.findViewById(R.id.skill);
            ScrollView scrollView=(ScrollView)rootView.findViewById(R.id.scr);
            TableLayout tabLayout=(TableLayout)rootView.findViewById(R.id.tab);
            ImageView imageView=(ImageView)rootView.findViewById(R.id.image);
            final RelativeLayout relativeLayout=(RelativeLayout)rootView.findViewById(R.id.rel);
            Button img=(Button)rootView.findViewById(R.id.html);
            Button img2=(Button)rootView.findViewById(R.id.java);
            Button img3=(Button)rootView.findViewById(R.id.js);
            Button img4=(Button)rootView.findViewById(R.id.py);


            if(getArguments().getInt(ARG_SECTION_NUMBER)==1)
            {
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.rose));
                relativeLayout.getBackground().setAlpha(90);
                textView.setText("Name: Proma Mukherjee\nAge/DOB: 21, 1997\nPassion: Coding");
                //txt.setBackgroundColor(Color.parseColor("#FFA9FCF2"));
                txt.getBackground().setAlpha(00);
                txt.setText("A little about myself");
                txt.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                textView.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.INVISIBLE);

                txt.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
               // img.setVisibility(View.INVISIBLE);

            }
            else {
                textView.setVisibility(View.INVISIBLE);
                txt.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);

            }

            if(getArguments().getInt(ARG_SECTION_NUMBER)==2)
            {

                ListView listView=new ListView(getContext());
                String skl[]={"1. JAVA", "2. JAVASCRIPT", "3. CSS", "4. HTML/XML", "5. ANDROID PROGRAMMING", "6. PYTHON", "7. C/C++", "8. CLOUD COMPUTING AND MANAGEMENT", "9. DATABASE MANAGEMENT", "10. ALGORITHM AND SEQUENCING", "11. DATA ANALYSIS"};

                listView.setDividerHeight(50);
                listView.setItemsCanFocus(true);
                listView.setDivider(getResources().getDrawable(R.drawable.ic_menu_manage));
                final ArrayList<String> list = new ArrayList<String>();
                for (int i = 0; i < skl.length; ++i) {
                    list.add(skl[i]);
                }

                final ArrayAdapter<String> s=new ArrayAdapter<String>(getContext(), R.layout.sr, list);

                listView.setAdapter(s);

                relativeLayout.removeView(relativeLayout);
                relativeLayout.addView(listView);


               // relativeLayout.removeView(relativeLayout);
               // relativeLayout.addView();
                scrollView.setVisibility(View.VISIBLE);
                /*sk.setText("1. JAVA\n\n\n2. ANDROID\n\n\n3. C\n\n\n4. C++\n\n\n5. PYTHON\n\n\n6. HTML, CSS, JS\n\n\n7. PhP\n\n\n8. D-BASE MANAGEMENT\n" +
                        "\n" +
                        "\n" +
                        "9. CLOUD COMPUTING\n" +
                        "\n" +
                        "\n" +
                        "10. ALGORITHM AND SEQUENCES\n" +
                        "\n" +
                        "\n" +
                        "11. BINARY MANIPULATION\n" +
                        "\n" +
                        "\n" +
                        "12. ASSEMBLY LANGUAGE\n" +
                        "\n" +
                        "\n" +
                        "13. COBOL");
                        */
                relativeLayout.setBackgroundColor(Color.parseColor("#FF7FF3C3"));
            }
            else {
                //sk.setVisibility(View.INVISIBLE);
               // scrollView.setVisibility(View.INVISIBLE);
            }







            if(getArguments().getInt(ARG_SECTION_NUMBER)==3)
            {

                relativeLayout.setBackgroundColor(Color.CYAN);

                //img.setText("JAVA");

                img.setBackground(getResources().getDrawable(R.drawable.java));
                img2.setBackground(getResources().getDrawable(R.drawable.html));
                img3.setBackground(getResources().getDrawable(R.drawable.js));
                img4.setBackground(getResources().getDrawable(R.drawable.python));


                img.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);

               /* img.setOnClickListener(new ImageView.OnClickListener()
                        {
                                public void onClick(View view)
                {
                  startActivity(HtmlActivity);
                }
                        }
                );
                */

                startJava=new Intent(getActivity(), JavaActivity.class);

                img.setOnClickListener(new ImageView.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        startActivity(startJava);
                    }
                });
            }
            else {
                img.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);


            }


            if(getArguments().getInt(ARG_SECTION_NUMBER)==4) {
                //  hs.setVisibility(View.VISIBLE);

                tabLayout.setVisibility(View.VISIBLE);
                relativeLayout.setBackgroundColor(Color.parseColor("#a5e7fd"));

            }
            else {
                //hs.setVisibility(View.INVISIBLE);
                tabLayout.setVisibility(View.INVISIBLE);
                //scrollView.setVisibility(View.INVISIBLE);
            }


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
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "PERSONAL DETAILS";
                case 1:
                    return "SKILLS";
                case 2:
                    return "CERTIFICATE";
                case 3:
                    return "ACADEMICS";

            }
            return null;
        }
    }
}
