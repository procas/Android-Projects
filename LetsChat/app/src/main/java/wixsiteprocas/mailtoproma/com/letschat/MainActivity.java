package wixsiteprocas.mailtoproma.com.letschat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button add_people;
    private EditText person_name;
    private ListView listView;
    private ArrayList<String> list_of_people = new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapter;
    String name;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().getRoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_people = (Button)findViewById(R.id.add_people);
        person_name = (EditText) findViewById(R.id.person_name);
        listView = (ListView)findViewById(R.id.listView);


       // List<ListItem> listItems;
       arrayAdapter = new ArrayAdapter<String>(this, R.layout.single_row ,list_of_people);
        listView.setAdapter(arrayAdapter);


        request_user();

        add_people.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(person_name.getText().toString(), "");
                databaseReference.updateChildren(map);
            }
        });


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator i = dataSnapshot.getChildren().iterator();
                Set<String> set = new HashSet<String>();
                //  ListItem person ;
                while(i.hasNext())
                {
                    set.add(((DataSnapshot)i.next()).getKey());
                    /**
                     person = new ListItem(((DataSnapshot)i.next()).getKey());
                     adapter.add(person);
                     adapter.notifyDataSetChanged();
                     **/
                }




                list_of_people.clear();
                list_of_people.addAll(set);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
          {
                   Intent intent = new Intent(getApplicationContext(),Chat_room.class);
                   intent.putExtra("person_name",((TextView)view).getText().toString());
                   intent.putExtra("user_name", name);
                   startActivity(intent);
          }
      });




    }

    public void request_user()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Name:");

        final EditText input_name = new EditText(this);

        builder.setView(input_name);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                name = input_name.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                request_user();
            }
        });

        builder.show();
    }



}
