package wixsiteprocas.mailtoproma.com.letschat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Chat_room extends AppCompatActivity {

    private Button send_message;
    private EditText message;
    private TextView chat_conversation;
    private String user_name, person_name;
    private DatabaseReference root;
    public String temp_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room);

        send_message = (Button)findViewById(R.id.send_message);
        message = (EditText)findViewById(R.id.message);
        chat_conversation = (TextView)findViewById(R.id.chat_conversation);

        user_name = getIntent().getExtras().get("user_name").toString();
        person_name = getIntent().getExtras().get("person_name").toString();

        setTitle("Room - "+person_name);
        root = FirebaseDatabase.getInstance().getReference().child(person_name);
       send_message.setOnClickListener(new Button.OnClickListener()
       {
           public void onClick(View view)
           {

               //temp-key
               Map<String, Object> map = new HashMap<String, Object>();
               temp_key = root.push().getKey();
               root.updateChildren(map);


               //user_name, message

               DatabaseReference message_root = root.child(temp_key);


               Map<String, Object> map2 = new HashMap<String, Object>();
               map2.put("name", user_name);
               map2.put("message", message.getText().toString());


               message_root.updateChildren(map2);

               //chat_conversation.setText(message.getText().toString());
               //message.setText("");

               root.addChildEventListener(new ChildEventListener() {
                   @Override
                   public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                       append_chat(dataSnapshot);
                   }

                   @Override
                   public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                       append_chat(dataSnapshot);
                   }

                   @Override
                   public void onChildRemoved(DataSnapshot dataSnapshot) {

                   }

                   @Override
                   public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                   }

                   @Override
                   public void onCancelled(DatabaseError databaseError) {

                   }
               });

           }
       });
    }

    private String chat_msg, chat_user;

    private void append_chat(DataSnapshot dataSnapshot)
    {
        Iterator i = dataSnapshot.getChildren().iterator();
        while(i.hasNext())
        {

            chat_msg = (String)((DataSnapshot)i.next()).getValue();
            chat_user = (String)((DataSnapshot)i.next()).getValue();

            chat_conversation.append(chat_user+" \n "+chat_msg+"\n ");

        }
    }
}
