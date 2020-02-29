package com.example.promamukherjee.practiceviews.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.promamukherjee.practiceviews.BottomSheet.MainActivity2;
import com.example.promamukherjee.practiceviews.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private GridLayoutManager gaggeredGridLayoutManager;
    Button main2;
    Intent m2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        m2=new Intent(MainActivity.this, MainActivity2.class);
        gaggeredGridLayoutManager = new GridLayoutManager(this,2 );
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        List<ItemObject> gaggeredList = getListItemData();

        RecyclerAdapter rcAdapter = new RecyclerAdapter(MainActivity.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);

        main2=(Button)findViewById(R.id.main2);
        main2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(m2);
            }
        });
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

    private List<ItemObject> getListItemData(){
        List<ItemObject> listViewItems = new ArrayList<ItemObject>();
        listViewItems.add(new ItemObject("LifeCycle List", R.drawable.one));
        listViewItems.add(new ItemObject("LifeCycle Image", R.drawable.two));
        listViewItems.add(new ItemObject("Abdroid Studio", R.drawable.three));
        listViewItems.add(new ItemObject("Desktop", R.drawable.four));

        return listViewItems;
    }
}