package thenewboston.com.sqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Score_list extends AppCompatActivity {

    DBHandler dbHandler;
    ListView listView;
    public static ListAdapter listAdapter;
    Cursor cursor;
    public static String _init;
    public static String _inname;
    public static String file;
    public static String queryCont;
    public static String queryName;
    public static String queryPass;
    //public String toEncrypt;
    public static boolean isEncrypted;
    public static String _key;
    public EditText enter;
    public ImageView isLocked;
    private ImageView backToMain;
    public TextView locked;
    public TextView lItem;
    public static String textName;


    AlertDialog.Builder contentDialog;
    AlertDialog.Builder passLock;

    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        isEncrypted = false;
        listView = (ListView) findViewById(R.id.listView);
       // registerForContextMenu(listView);
        SingleRow singleRow=new SingleRow();
        lItem = (TextView)findViewById(R.id.lItem);
  //      singleRow.lItems = (TextView)findViewById(R.id.lItem);
//        registerForContextMenu(singleRow.lItems);
        listAdapter = new ListAdapter(getApplicationContext(), R.layout.single_row);
        listView.setAdapter(listAdapter);
        isLocked = (ImageView)findViewById(0);





        // on item click

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                // TODO Auto-generated method stub

                                                TextView text = (TextView)view.findViewById(R.id.lItem);

                                                file = text.getText().toString() ;

                                               // file = lItem.getText().toString();

                                                contentDialog = new AlertDialog.Builder(Score_list.this);

                                                TextView contentView = new TextView(Score_list.this);

                                                //get rowid




                                                //get content from DataBase
                                                queryCont = "SELECT " + UserContract.NewUserInfo.COLUMN_CONTENT + " FROM " + UserContract.NewUserInfo.TABLE_NAME + " WHERE filename = '" + (file) + "'";
                                               // queryName = "SELECT " + UserContract.NewUserInfo.COLUMN_NAME + " FROM " + UserContract.NewUserInfo.TABLE_NAME + " WHERE id = '" + (position) + "'";
                                                queryPass = "SELECT " + UserContract.NewUserInfo.COLUMN_KEY + " FROM " + UserContract.NewUserInfo.TABLE_NAME + " WHERE filename = '" + (file) + "'";

                                                Cursor cursor1;


                                                cursor1 = sqLiteDatabase.rawQuery(queryCont, null);
                                                       if( cursor1.moveToFirst()) {
                                                           do {
                                                               _init = cursor1.getString(cursor1.getColumnIndex("filecontent"));
                                                           }while(cursor1.moveToNext());

                                                       }




                                                //define cursor 2

                                                Cursor cursor2 ;

                                              /*  cursor2 = sqLiteDatabase.rawQuery(queryName, null);
                                                if( cursor2.moveToFirst()) {
                                                    do {
                                                        _inname = cursor2.getString(cursor2.getColumnIndex("filename"));
                                                    } while (cursor2.moveToNext());


                                                }
*/

                                                    //define cursor 3
                                                Cursor cursor3 = sqLiteDatabase.rawQuery(queryPass, null);

                                                cursor3 = sqLiteDatabase.rawQuery(queryPass, null);
                                                if( cursor3.moveToFirst()) {
                                                    do {
                                                        _key = cursor3.getString(cursor3.getColumnIndex("key"));
                                                    }while(cursor3.moveToNext());

                                                }



                                                System.out.println(_key);

                                                //if encrypted, unlock first


                                                final Intent showIntent = new Intent(Score_list.this, ShowFileContent.class);
                                                if(_key == null) {

                                                    startActivity(showIntent);

                                                }
                                                else
                                                {

                                                    AlertDialog.Builder enterPass = new AlertDialog.Builder(Score_list.this);




                                                    RelativeLayout rel = new RelativeLayout(Score_list.this);

                                                    RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                                    // left top right bottom
                                                    lp1.setMargins(10, 10, 10, 150);

                                                    RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                                    lp2.setMargins(10, 150, 10, 20);



                                                   locked = new TextView(Score_list.this);

                                                    locked.setText("\n-------------------------------------------------------------------\nOOPS! THIS FILE IS LOCKED\n-------------------------------------------------------------------");

                                                    locked.setLayoutParams(lp1);

                                                   enter = new EditText(Score_list.this);

                                                    enter.setLayoutParams(lp2);

                                                    enter.setInputType(InputType.TYPE_CLASS_TEXT |
                                                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                                                    enter.setHint("Enter Password");

                                                    rel.addView(locked);
                                                    rel.addView(enter);

                                                    enterPass.setView(rel);

                                                    enterPass.setPositiveButton("OK", new DialogInterface.OnClickListener() {


                                                        @Override

                                                        public void onClick(DialogInterface dialog, int which)
                                                        {
                                                            if(enter.getText().toString().equals(_key))
                                                            {
                                                                // if key is correctly entered
                                                                startActivity(showIntent);

                                                            }
                                                               else
                                                                Toast.makeText(getApplicationContext(), "PASSWORDS DON'T MATCH, PLEASE TRY AGAIN", Toast.LENGTH_LONG).show();

                                                        }

                                                    }).create();

                                                        enterPass.show();
                                                }


                                            }
                                        }
        );


        dbHandler = new DBHandler(getApplicationContext());
        sqLiteDatabase = dbHandler.getReadableDatabase();
        cursor = dbHandler.getInformation(sqLiteDatabase);

        if (cursor.moveToNext()) {
            do {
                {
                    String name;
                    String date;
                    String content = "";
                    int id;

                    id=(Integer.parseInt((cursor.getString(cursor.getColumnIndex(UserContract.NewUserInfo.COLUMN_ID)))));
                    name = (cursor.getString(cursor.getColumnIndex(UserContract.NewUserInfo.COLUMN_NAME)));
                    date = cursor.getString(cursor.getColumnIndex(UserContract.NewUserInfo.COLUMN_DATE));
                    content = cursor.getString(cursor.getColumnIndex(UserContract.NewUserInfo.COLUMN_CONTENT));
                    //  stars=Float.parseFloat(cursor.getString(cursor.getColumnIndexOrThrow(UserContract.NewUserInfo.COLUMN_STARS)));
                    ListItem listItem = new ListItem(date, name, content);
                    listAdapter.add(listItem);
                    listAdapter.notifyDataSetChanged();
                }
            } while (cursor.moveToNext());
        }




        //on back
        backToMain = (ImageView) findViewById(R.id.backToMain);

        backToMain.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent backIntent = new Intent(Score_list.this, MainActivity.class);
                startActivity(backIntent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0, v.getId(), 0, "Rename");
         menu.add(0, v.getId(), 0, "Delete");
        menu.add(0, v.getId(), 0, "Send");
        //  menu.add(0, v.getId(), 0, "Rename");
        menu.add(0, v.getId(), 0, "Encrypt");
        menu.add(0, v.getId(), 0, "Cancel");

        lItem = (TextView)findViewById(R.id.lItem);



    }


    @Override
    public boolean onContextItemSelected(final MenuItem item) {

        textName = lItem.getText().toString();


        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();



        final int index = info.position;



        if (item.getTitle() == "Encrypt") {

            passLock = new AlertDialog.Builder(Score_list.this);

            //set password defining layout

            RelativeLayout relativeLayout = new RelativeLayout(Score_list.this);

            RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            // left top right bottom
            lp1.setMargins(10, 10, 10, 100);

            RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp2.setMargins(10, 100, 10, 20);


            final EditText password = new EditText(Score_list.this);
            password.setWidth(600);
            //set input type to password

            password.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);


            password.setHint("Enter password");


            password.setLayoutParams(lp1);
            final EditText confirm = new EditText(Score_list.this);
            confirm.setWidth(600);

            // set input type to password

            confirm.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);

            confirm.setHint("Re-type password");

            confirm.setLayoutParams(lp2);
            relativeLayout.addView(password);
            relativeLayout.addView(confirm);

            passLock.setView(relativeLayout);

            passLock.setPositiveButton("ENCRYPT", new DialogInterface.OnClickListener() {


                @Override

                public void onClick(DialogInterface dialog, int which)
                {

                    if(password.getText().toString().equals(confirm.getText().toString())) {

                        String sql = "UPDATE "+UserContract.NewUserInfo.TABLE_NAME +" SET " + UserContract.NewUserInfo.COLUMN_KEY+ " = '"+confirm.getText().toString()+"' WHERE filename "+ " = '"+(textName)+"'";

                        sqLiteDatabase.execSQL(sql);
                        ListAdapter.LayoutHandler layoutHandler = new ListAdapter.LayoutHandler();



                        Toast.makeText(getApplicationContext(), "FILE ENCRYPTED", Toast.LENGTH_LONG).show();
                        isEncrypted = true;
                    }
                    else {

                        Toast.makeText(getApplicationContext(), "INCORRECT PASSWORD, PLEASE TRY AGAIN", Toast.LENGTH_LONG).show();
                    }
                }

            }).create();

            passLock.show();
        }


        if(item.getTitle() == "Delete")
        {
            String deleteQuery = "DELETE FROM "+ UserContract.NewUserInfo.TABLE_NAME + " WHERE filename = '"+(textName)+"'";
            sqLiteDatabase.execSQL(deleteQuery);

           // Cursor cursor = (Cursor)getParent().getItemPosition

           // listAdapter.notifyDataSetChanged();
        }

        return true;
    }

    public void encrypt(String pass, int pos)
    {
       // queryName = "SELECT " + UserContract.NewUserInfo.COLUMN_ENCRYTED + " FROM " + UserContract.NewUserInfo.TABLE_NAME + " WHERE name = '" + name + "'";
      //  String pw = "1234";

      //  String sql = "UPDATE "+UserContract.NewUserInfo.TABLE_NAME +" SET " + UserContract.NewUserInfo.COLUMN_ENCRYTED+ " = '"+true+"' WHERE "+UserContract.NewUserInfo.COLUMN_NAME+ " = '"+name+"'";


        String sql2 = "UPDATE "+UserContract.NewUserInfo.TABLE_NAME +" SET " + UserContract.NewUserInfo.COLUMN_KEY+ " = '"+pass+"' WHERE filename = '"+(textName)+"'";

        dbHandler = new DBHandler((getApplicationContext()));
        sqLiteDatabase = dbHandler.getReadableDatabase();

        sqLiteDatabase.execSQL(sql2);


       // cursor = dbHandler.getInformation(sqLiteDatabase);
       // cursor.moveToFirst();
       // toEncrypt = cursor.getString(cursor.getColumnIndex("key"));

    }
}