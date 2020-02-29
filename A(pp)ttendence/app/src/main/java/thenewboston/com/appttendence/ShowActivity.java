package thenewboston.com.appttendence;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import thenewboston.com.appttendence.MainActivity;
import thenewboston.com.appttendence.R;

public class ShowActivity extends AppCompatActivity {
    String SavedFiles[] = null;
    public Intent editIntent; public ListView list;
    ArrayAdapter<String> adapter;
    public boolean checked;
    public StringBuilder buff;
    public static String result;
    public ArrayList<String> al;
    public String text;
    public EditText ed;
    MenuItem itm;
    AdapterView.AdapterContextMenuInfo info;
    Object o;
    String File_Content;
    AlertDialog.Builder passEnter;
    AlertDialog.Builder pass;
    public static String passWord="";
    File passwordProtected[];public File passwordFiles[];
    EditText password=null;

    EditText enterPass;
    String correctPassword;
    String fileName;

Intent in;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_show);
        File_Content="";
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");
        SavedFiles = getApplicationContext().fileList();
        al=new ArrayList<String>();
        Collections.addAll(al, SavedFiles);
        list = (ListView) findViewById(R.id.list);

        passwordFiles=new File[SavedFiles.length];
        //lockedFileList=new String[SavedFiles.length];
        passwordProtected=new File[SavedFiles.length];





        adapter = new ArrayAdapter<String>(this, R.layout.sf, al);
        // editIntent = new Intent(ShowActivity.this, FileEdit.class);
        // Button sendAll=(Button)findViewById(R.id.sendAll);
        // Button delAll=(Button)findViewById(R.id.delAll);



//PASSWORD LOCKER
        passEnter = new AlertDialog.Builder(ShowActivity.this);



        pass = new AlertDialog.Builder(ShowActivity.this);

        enterPass=new EditText(this);
        enterPass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        enterPass.setWidth(1000);
        TextView inst=new TextView(this);
        inst.setText("PASSWORD:");

        RelativeLayout rel=new RelativeLayout(this);
        RelativeLayout.LayoutParams lpp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lpp1=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lpp1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lpp1.addRule(RelativeLayout.CENTER_VERTICAL);
        lpp.addRule(RelativeLayout.BELOW, inst.getId());
        lpp.setMargins(0,150,0,0);
        lpp1.setMargins(0,0,0,05);

        inst.setLayoutParams(lpp1);
        enterPass.setLayoutParams(lpp);




        rel.addView(enterPass, lpp);

        rel.addView(inst, lpp1);



        pass.setView(rel);
        //fileDialog.setView(nameFormat);




        pass.setPositiveButton("ENTER", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {


                if(enterPass.getText().toString()==correctPassword)
                {
                    openEditDialog(fileName);

                }


            }

        });
        pass.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {
            }

        }).create();



      in=new Intent(ShowActivity.this, MainActivity.class);




















        /*sendAll.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view)throws NullPointerException
                    {
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);
                        emailIntent.setType("text/plain");
                        String content="";

                        for(int dex=1;dex<al.size();dex++)
                        {
                            // final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                            final Object o=list.getItemAtPosition(dex);

                            try {

                                FileInputStream fin = openFileInput(o.toString());
                                content+="\n"+o.toString()+":"+"\n"+"\n";
                                byte[] input = new byte[fin.available()];

                                while (fin.read(input) != -1) {
                                    content+= new String(input);
                                }

                                content+="\n";
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                        }

                        emailIntent.putExtra(emailIntent.EXTRA_TEXT, content);
                        startActivity(emailIntent);
                        //System.out.println(content);

                    }
                }
        );

        ImageButton imageButton=(ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(
                new ImageButton.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent in=new Intent(ShowActivity.this, MainActivity.class);
                        startActivity(in);
                    }
                }
        );
        */


     /*   Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        String filenames = "";
                        TextView files = new TextView(ShowActivity.this);
                        String content="";
                        try {



                            for (int i = 0; i < SavedFiles.length; i++) {
                                FileInputStream fis = new FileInputStream(passwordFiles[i]);
                                byte b[]=new byte[fis.available()];
                                while(fis.read(b)!=-1)
                                {
                                    content+=b;
                                }

                                 filenames += passwordFiles[i].getName();
                            }
                        }catch(IOException e)
                        {
                            e.printStackTrace();
                        }

                        AlertDialog.Builder fileDialog = new AlertDialog.Builder(ShowActivity.this);
                        files.setText(filenames);
                        fileDialog.setView(files);
                        fileDialog.setPositiveButton("OK", null);
                        fileDialog.setNegativeButton("Cancel", null);
                        fileDialog.show();

                    }
                }
        );
        */




        setSupportActionBar(toolbar);

        list.setAdapter(adapter);
        registerForContextMenu(list);

        list.setOnItemClickListener(
                new ListView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position,
                                            long id) {
                        Object o = list.getItemAtPosition(position);
                        String clicked = o.toString();
                        //int len=passwordFiles[info.position-1].getName().length();
                        // if(!passwordFiles[info.position-1].getName().substring(len-4).equals(clicked))
                        openFileDialog(clicked);

                    }
                }
        );


    }


    public void back(View v)
    {
        ImageButton imageButton=(ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                startActivity(in);
            }
        });

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {

        menu.add(0, v.getId(), 0, "Edit");
        menu.add(0, v.getId(), 0, "Delete");
        menu.add(0, v.getId(), 0, "Send");
        menu.add(0, v.getId(), 0, "Rename");
        menu.add(0, v.getId(), 0, "Password Lock");
        menu.add(0, v.getId(), 0, "Exit");

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {


        if(item.getTitle()=="Password Lock")
        {
            final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            final Object o=list.getItemAtPosition(info.position);

            password=new EditText(this);
            password.setWidth(1000);
            TextView label=new TextView(this);
            label.setText("PLEASE ENTER PASSWORD:");
            password.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);

            RelativeLayout rell=new RelativeLayout(this);
            RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            RelativeLayout.LayoutParams lp1=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp1.addRule(RelativeLayout.CENTER_HORIZONTAL);
            lp1.addRule(RelativeLayout.CENTER_VERTICAL);
            lp.addRule(RelativeLayout.BELOW, label.getId());
            lp.setMargins(0,150,0,0);
            lp1.setMargins(0,0,0,05);

            label.setLayoutParams(lp1);
            password.setLayoutParams(lp);



            if(password.getParent()!=null)
                ((ViewGroup)password.getParent()).removeView(ed);
            rell.addView(password, lp);
            if(label.getParent()!=null)
                ((ViewGroup)label.getParent()).removeView(label);
            rell.addView(label, lp1);



            passEnter.setView(rell);
            passEnter.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {

                @Override

                public void onClick(DialogInterface dialog, int which) {

                    passwordFiles[info.position] = new File(o.toString());




                    String pass = password.getText().toString();

                    try {
                        FileOutputStream fos = new FileOutputStream(passwordFiles[info.position].getName());
                        fos.write(pass.getBytes());
                        fos.close();
                        Toast.makeText(ShowActivity.this, passwordFiles[info.position].getName() + " HAS BEEN LOCKED!", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }




                }



            });
            passEnter.setNegativeButton("CANCEL", null);


            passEnter.show();

        }


        if(item.getTitle()=="Send")
        {
            // String File_Content="";

            final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            final Object o=list.getItemAtPosition(info.position);







            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");



            try {
                FileInputStream fin = openFileInput(o.toString());
                File_Content+=o.toString()+":\n\n";
                byte[] input = new byte[fin.available()];

                while (fin.read(input) != -1) {
                    File_Content += new String(input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            emailIntent.putExtra(emailIntent.EXTRA_TEXT, File_Content);


            startActivity(emailIntent);
            File_Content="";

        }

        if (item.getTitle() == "Edit") {

            String ret="";StringBuilder sb=new StringBuilder();
            // startActivity(editIntent);
            info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            int pos = info.position;

            o = list.getItemAtPosition(pos);
            openEditDialog(o.toString());


            //  EditText editText=(EditText)findViewById(R.id.editText);
            //   editText.setText(sb.toString());
            Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();


        }


        if(item.getTitle()=="Rename")
        {

            ed = new EditText(this);
            ed.setWidth(1000);
            TextView nameFormat =new TextView(this);
            nameFormat.setText("Enter FileName of the Format: DD/MM/YYYY");

            final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            final Object o=list.getItemAtPosition(info.position);



            final AlertDialog.Builder fileDialog = new AlertDialog.Builder(this);

            RelativeLayout rell=new RelativeLayout(this);
            RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            RelativeLayout.LayoutParams lp1=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp1.addRule(RelativeLayout.CENTER_HORIZONTAL);
            lp1.addRule(RelativeLayout.CENTER_VERTICAL);
            lp.addRule(RelativeLayout.BELOW, nameFormat.getId());
            lp.setMargins(0,150,0,0);
            lp1.setMargins(0,0,0,05);

            rell.addView(ed, lp);
            rell.addView(nameFormat, lp1);


            nameFormat.setLayoutParams(lp1);
            ed.setLayoutParams(lp);

            fileDialog.setView(rell);

            //fileDialog.setView(nameFormat);


            fileDialog.setNegativeButton("CANCEL", null);
            fileDialog.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {

                @Override

                public void onClick(DialogInterface dialog, int which)
                {

                    File dir=getFilesDir();
                    File file=new File(dir, o.toString());
                    File newFile=new File(ed.getText().toString());
                    file.renameTo(newFile);


                    if(true) {

                        al.set(info.position, ed.getText().toString());

                        adapter.notifyDataSetChanged();
                    }


                }
            });

            fileDialog.show();

        }
        if (item.getTitle() == "Delete") {
            final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            final Object o=list.getItemAtPosition(info.position);
            TextView del=new TextView(this);

            AlertDialog.Builder fileDialog = new AlertDialog.Builder(this);
            del.setText("DELETE FILE?");
            fileDialog.setView(del);

            fileDialog.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {

                @Override

                public void onClick(DialogInterface dialog, int which) {


                    File dir=getFilesDir();
                    File file=new File(dir, o.toString());
                    boolean deleted = file.delete();



                    if(deleted)
                    {
                        al.remove(info.position);

                        adapter.notifyDataSetChanged();
                    }
                    else
                    {
                        al.remove(info.position);
                        adapter.notifyDataSetChanged();
                    }
                }


            });
            fileDialog.setNegativeButton("CANCEL", null);
            fileDialog.show();
        }

        adapter.notifyDataSetChanged();
        list.setAdapter(adapter);

        return true;

    }

    void openFileDialog(String file) {
        TextView content = new TextView(this);


        String result = "";
        try {
            FileInputStream fin = openFileInput(file);
            byte[] input = new byte[fin.available()];

            while (fin.read(input) != -1) {
                result += new String(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        AlertDialog.Builder fileDialog = new AlertDialog.Builder(this);
        content.setText(result);
        fileDialog.setView(content);
        fileDialog.setPositiveButton("OK", null);
        fileDialog.setNegativeButton("Cancel", null);
        fileDialog.show();

    }

    public void openEditDialog(final String str)
    {
        final EditText edit = new EditText(this);


        String result = "";
        try {
            FileInputStream fin = openFileInput(str);
            byte[] input = new byte[fin.available()];

            while (fin.read(input) != -1) {
                result += new String(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        AlertDialog.Builder editDialog = new AlertDialog.Builder(this);
        edit.setText(result);
        editDialog.setView(edit);



        editDialog.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {
                String Message = edit.getText().toString();
                //  file_name = ed.getText().toString();
                if (!Message.equalsIgnoreCase("")) {
                    try {
                        FileOutputStream fos = openFileOutput(str, Context.MODE_PRIVATE);

                        fos.write(Message.getBytes());
                        fos.close();


                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException n) {
                        n.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(), "MESSAGE SAVED!", Toast.LENGTH_LONG).show();
                } else

                    Toast.makeText(getApplicationContext(), "PLEASE ENTER A FILE NAME", Toast.LENGTH_LONG).show();
            }
        });




        editDialog.setNegativeButton("Cancel", null);
        editDialog.show();

    }


    public void del_all(View view)
    {
        TextView content=new TextView(this);
        AlertDialog.Builder fileDialog = new AlertDialog.Builder(this);
        content.setText("DO YOU REALLY WISH TO DELETE ALL FILES?");
        fileDialog.setView(content);
        fileDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {


                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                        for (int dex=1;dex<SavedFiles.length;dex++) {
                            Object o = list.getItemAtPosition(dex);
                            File dir = getFilesDir();
                            File file = new File(dir, o.toString());
                            boolean deleted = file.delete();


                            if (deleted) {
                                al.remove(dex);

                                adapter.notifyDataSetChanged();
                            } else {
                                al.remove(dex);
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
        );

        fileDialog.setNegativeButton("NO", null);
        fileDialog.show();
    }
}






