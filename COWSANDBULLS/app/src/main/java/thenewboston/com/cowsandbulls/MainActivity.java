package thenewboston.com.cowsandbulls;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import thenewboston.com.cowsandbulls.ListAdapter;
public class MainActivity extends Activity {
    private ListView mCompleteListView;
    private Button mAddItemToList;
    private List<String> mItems;
    private ListAdapter mListAdapter;
    private static final int MIN = 0, MAX = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initViews();
        mCompleteListView = (ListView) findViewById(R.id.completeList);
        mAddItemToList = (Button) findViewById(R.id.button);

        mItems = new ArrayList<String>();
        mListAdapter = new ListAdapter(this, mItems);
        mCompleteListView.setAdapter(mListAdapter);
    }

}