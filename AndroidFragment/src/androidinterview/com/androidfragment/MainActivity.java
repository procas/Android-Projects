package androidinterview.com.androidfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
	}	
	public void FragmentOneClick(View view) {
		 Fragment myfragment;
		 myfragment = new FragmentOne();
		 
		 FragmentManager fm = getFragmentManager();
	     FragmentTransaction fragmentTransaction = fm.beginTransaction();
	     fragmentTransaction.replace(R.id.fragment_switch, myfragment);
	     fragmentTransaction.commit();
		 
	}
	public void FragmentTwoClick(View view) {
		 Fragment myfragment;
		 myfragment = new FragmentTwo();
		 
		 FragmentManager fm = getFragmentManager();
	     FragmentTransaction fragmentTransaction = fm.beginTransaction();
	     fragmentTransaction.replace(R.id.fragment_switch, myfragment);
	     fragmentTransaction.commit();
		 
	}
}
