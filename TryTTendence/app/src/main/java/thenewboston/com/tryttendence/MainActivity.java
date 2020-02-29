package thenewboston.com.tryttendence;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        // Lookup the recyclerview in activity layout
        super.onCreate(savedInstanceState);

        students.add( new Student("Name", "Reg"));
        RecyclerView rvStudents = (RecyclerView) findViewById(R.id.list);

        // Initialize contacts
       // students = Student.createContactsList(20);
        // Create adapter passing in the sample user data
        StudentAdapter adapter = new StudentAdapter(this, students);
        // Attach the adapter to the recyclerview to populate items
         rvStudents.setAdapter(adapter);
        // Set layout manager to position the items
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }
}