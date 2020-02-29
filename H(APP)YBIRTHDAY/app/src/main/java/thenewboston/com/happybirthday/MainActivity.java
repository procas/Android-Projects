package thenewboston.com.happybirthday;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
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

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.FileNotFoundException;


public class MainActivity extends AppCompatActivity {
    static int stopPosition=0;

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

        VideoView videoView;
        RelativeLayout relativeLayout;
        ScrollView scrollView;
        TextView swipe;

        Button play;
        Button pause;

        MediaPlayer mediaPlayer;
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




            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            relativeLayout=(RelativeLayout)rootView.findViewById(R.id.rel);
            scrollView=(ScrollView)rootView.findViewById(R.id.scroll);
            videoView=(VideoView)rootView.findViewById(R.id.videoView);
            play=(Button)rootView.findViewById(R.id.play);
            pause=(Button)rootView.findViewById(R.id.pause);
            swipe=(TextView)rootView.findViewById(R.id.swipe);
           // int stopPosition=0;
            Uri uri = Uri.parse("android.resource://thenewboston.com.happybirthday/"+R.raw.hbmin);


            videoView.setVideoURI(uri);
            videoView.setVisibility(View.INVISIBLE);


            int sec=getArguments().getInt(ARG_SECTION_NUMBER);


            if(sec==1)

            {
                scrollView.setBackground(getResources().getDrawable(R.drawable.hb1));
                videoView.setVisibility(View.INVISIBLE);
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.INVISIBLE);


                if(mediaPlayer==null) {
                    mediaPlayer= MediaPlayer.create(getContext(), R.raw.hbday);
                    mediaPlayer.start();
                }
                swipe.setVisibility(View.VISIBLE);
            }

            if (sec==2) {

                scrollView.setBackground(getResources().getDrawable(R.drawable.hb3));
                videoView.setVisibility(View.INVISIBLE);
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.INVISIBLE);

                if(videoView.isPlaying())
                    videoView.stopPlayback();

                swipe.setVisibility(View.VISIBLE);



            }

            if (sec==3) {

                scrollView.setBackground(getResources().getDrawable(R.drawable.hb2));
                videoView.setVisibility(View.INVISIBLE);
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.INVISIBLE);
                swipe.setVisibility(View.VISIBLE);
                if(videoView.isPlaying())
                    videoView.stopPlayback();


            }

            if (sec==4) {

                scrollView.setBackground(getResources().getDrawable(R.drawable.hb5));
                videoView.setVisibility(View.INVISIBLE);
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.INVISIBLE);
                swipe.setVisibility(View.VISIBLE);
                swipe.setTextColor(Color.WHITE);
                if(videoView.isPlaying())
                    videoView.stopPlayback();


            }


            if (sec==5) {
                scrollView.setBackground(getResources().getDrawable(R.drawable.hb6));
                videoView.setVisibility(View.INVISIBLE);
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.INVISIBLE);
                swipe.setVisibility(View.VISIBLE);
                if(videoView.isPlaying())
                    videoView.stopPlayback();


            }


            if (sec==6) {




                scrollView.setBackground(getResources().getDrawable(R.drawable.hb7));
                videoView.setVisibility(View.INVISIBLE);
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.INVISIBLE);
                swipe.setVisibility(View.VISIBLE);

                videoView.pause();



            }

            if(sec==7)
            {


                videoView.setVisibility(View.VISIBLE);
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.VISIBLE);
                //swipe.setVisibility(View.INVISIBLE);
                swipe.setText("PRESS PLAY!");

               pause.setOnClickListener(new View.OnClickListener(){


                   public void onClick(View view)
                   {
                       if(videoView.isPlaying())
                           videoView.pause();
                       stopPosition = videoView.getCurrentPosition();
                   }
               });


                play.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View view)
                    {
                        try {


                            mediaPlayer.stop();
                            mediaPlayer=null;

                        }
                        catch (NullPointerException e)

                        {
                            e.printStackTrace();
                        }

                            videoView.seekTo(stopPosition+100);
                        videoView.start();
                    }
                });


               // videoView.start();

                //videoView.setVideoPath("H(APP)YBIRTHDAY\app\src\main\res\raw");
            }




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
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
                case 4:
                    return "SECTION 5";
                case 5:
                    return "SECTION 6";
                case 6:
                    return "SECTION 7";

            }
            return null;
        }
    }
}
