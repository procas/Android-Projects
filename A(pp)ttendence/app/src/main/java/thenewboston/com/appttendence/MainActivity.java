package thenewboston.com.appttendence;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity implements android.widget.CompoundButton.OnCheckedChangeListener {

    public static String file_name;
    public EditText text;
    static EditText ed=null;
    static TextView nameFormat=null;
    String SavedFiles[]=null;
    TextView content; public Button save;
    public StringBuilder buff=null;
    Intent in, showFiles;

    String nameAdded, regAdded;
    AlertDialog.Builder fileDialog=null;
    AlertDialog.Builder fileDialog1=null;




    ListView listView;
    EditText nameField, regField;
    //ArrayList<Student> studentList;
   public static StudentAdapter studentAdapter=null;
    final ArrayList<Student> studentList=new ArrayList<Student>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button=(Button)findViewById(R.id.save);
        Button button1=(Button)findViewById(R.id.view);
        ImageView exit=(ImageView) findViewById(R.id.exit);
        Button add=(Button)findViewById(R.id.add);

        add.setOnClickListener(new Button.OnClickListener()
        {

           // LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            public void onClick(View view)
            {
                RelativeLayout relative=(RelativeLayout)findViewById(R.id.relative);



                TextView name=(TextView)findViewById(R.id.name);
                name.setText("New Name");
                TextView reg=(TextView)findViewById(R.id.reg);
                reg.setText("RA1611003010489");

                View info=getLayoutInflater().inflate(R.layout.content_main, relative, false);

                relative.addView(info);

                studentAdapter.notifyDataSetChanged();



            }




        });




     //   exit.getBackground().setAlpha(00);
      //  listView=(ListView)findViewById(R.id.list);
        displayStudentList();
        saveToFiles(button);
        viewRec(button1);
       // goBack(ret);




        studentAdapter=new StudentAdapter(studentList, R.layout.main, this);
        ListView lv=(ListView)findViewById(R.id.list);
        lv.setAdapter(studentAdapter);


        ed = new EditText(MainActivity.this);
        ed.setWidth(1000);
        nameFormat = new TextView(MainActivity.this);
        nameFormat.setText("Enter FileName:");


        fileDialog = new AlertDialog.Builder(MainActivity.this);
        fileDialog1=new AlertDialog.Builder(MainActivity.this);

        RelativeLayout rell = new RelativeLayout(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lp1.addRule(RelativeLayout.CENTER_VERTICAL);
        lp.addRule(RelativeLayout.BELOW, nameFormat.getId());
        lp.setMargins(0, 150, 0, 0);
        lp1.setMargins(0, 0, 0, 05);

        nameFormat.setLayoutParams(lp1);
        ed.setLayoutParams(lp);


        if (ed.getParent() != null)
            ((ViewGroup) ed.getParent()).removeView(ed);
        rell.addView(ed, lp);
        if (nameFormat.getParent() != null)
            ((ViewGroup) nameFormat.getParent()).removeView(nameFormat);
        rell.addView(nameFormat, lp1);


        fileDialog.setView(rell);



      /*  nameFiled=new EditText(getApplicationContext());
        regField=new EditText(getApplicationContext());

        nameFiled.setText("Enter name:");
        regField.setText("Enter register number:");

        RelativeLayout rell2 = new RelativeLayout(getApplicationContext());
        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp2.addRule(RelativeLayout.CENTER_HORIZONTAL);

        lp2.addRule(RelativeLayout.BELOW, nameFiled.getId());
      //  lp2.setMargins(0, 150, 0, 0);
      //     lp3.setMargins(0, 0, 0, 10);

        nameFiled.setLayoutParams(lp1);
        regField.setLayoutParams(lp);


       // if (regField.getParent() != null)
         //   ((ViewGroup) regField.getParent()).removeView(regField);
        rell2.addView(regField, lp2);
        //if (nameFiled.getParent() != null)
        //((ViewGroup) nameFiled.getParent()).removeView(nameFiled);
        rell2.addView(nameFiled, lp3);





        fileDialog1.setView(rell2);


        fileDialog1.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which)
            {

                //nameAdded=nameFiled.getText().toString();
                //regAdded=regField.getText().toString();

               // studentList.add(new Student("Prima", "RA69475674"));


            }

        });


*/













        showFiles=new Intent(MainActivity.this, ShowActivity.class);



    }

    public void stop(View view)
    {

            TextView ask=new TextView(this);
            ask.setText("DO YOU REALLY WISH TO EXIT?");

            AlertDialog.Builder fileDialog = new AlertDialog.Builder(this);
            //        content.setText(result);
            fileDialog.setView(ask);
            fileDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                @Override

                public void onClick(DialogInterface dialog, int which)
                {
                    Intent homeIntent=new Intent(Intent.ACTION_MAIN);
                    homeIntent.addCategory(Intent.CATEGORY_HOME);
                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(homeIntent);

                }

            });
            fileDialog.setNegativeButton("NO", null);
            fileDialog.show();


        }





    private void viewRec(View view)
    {

        Button button=(Button)findViewById(R.id.view);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(final View v) {

                startActivity(showFiles);
            }
        }
        );
    }




   /* public void addNames(View view)
    {
       // Button add=(Button)findViewById(R.id.add);

          nameField=new EditText(this);
       // nameField.setText("DO YOU REALLY WISH TO EXIT?");

        AlertDialog.Builder fileDialog2 = new AlertDialog.Builder(this);
        //        content.setText(result);
        fileDialog2.setView(nameField);
        fileDialog2.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which)
            {
               nameAdded=nameField.getText().toString();

               // Student s=new Student(nameAdded, "RA1101");
              //  studentList.set(4, s);

               // studentList.add(s);

                studentAdapter.notifyDataSetChanged();

            }

        });
        fileDialog2.setNegativeButton("NO", null);
        fileDialog2.show();



    }
*/
    private void displayStudentList()
    {






        studentList.add(new Student("Proma", "RA1611003010478"));
        studentList.add(new Student("Brian", "RA1611003010479"));
        studentList.add(new Student("Dryden", "RA1611003010480"));
        studentList.add(new Student("Madame Red", "RA1611003010481"));

        studentList.add(new Student("Undertaker", "RA1611003010482"));


        for(int i=0;i<100;i++)
        {
           final Student s=new Student("Name", "Reg");


            Button add=(Button)findViewById(R.id.add);
            add.setOnClickListener(new Button.OnClickListener()
            {
            public void onClick(View v)
            {
                studentList.add(s);
                studentAdapter.notifyDataSetChanged();
            }
        });


        }






        //studentList.add(new Student(nameAdded, "RA..."));
        //studentAdapter.notifyDataSetChanged();

    }



public void saveToFiles(View view) throws NullPointerException
    {
        Button button=(Button)findViewById(R.id.save);
        button.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(final View v)
            {

                 final StringBuffer response=new StringBuffer();
                response.append("The absentees are:\n\n");

                final ArrayList<Student> studentList=studentAdapter.studentList;
                for(int i=0;i<studentList.size();i++)
                {
                    Student student=studentList.get(i);
                    if(student.isSelected())
                        response.append(student.getName()+"\n");



                }






                fileDialog.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                  //      save.setVisibility(View.VISIBLE);


                        //response = text.getText().toString();
                        file_name = ed.getText().toString();
                        if (!file_name.equalsIgnoreCase("")) {
                            try {
                                FileOutputStream fos = openFileOutput(file_name, Context.MODE_PRIVATE);
                                fos.write(response.toString().getBytes());
                                fos.close();


                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (NullPointerException n) {
                                n.printStackTrace();
                            }



                            for(int i=0;i<studentList.size();i++)
                            {
                               Student student=studentList.get(i);
                               // CheckBox check=studentList.get

                                if(student.isSelected()) {
                                    student.setSelected(false);
                                 //   cb.setChecked(false);
                                }
                            }
                            Toast.makeText(getApplicationContext(), "MESSAGE SAVED!", Toast.LENGTH_LONG).show();
                        } else

                            Toast.makeText(getApplicationContext(), "PLEASE ENTER A FILE NAME", Toast.LENGTH_LONG).show();
                    }
                });
                fileDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                    }

                }).create();









            fileDialog.show();


                //  Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
            }

        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



    }

}
