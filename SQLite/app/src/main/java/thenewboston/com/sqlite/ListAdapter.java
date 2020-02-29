package thenewboston.com.sqlite;

/**
 * Created by HP on 29-01-2017.
 */
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.lang.*;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 22-11-2016.
 */




public class ListAdapter extends ArrayAdapter {

    List list=new ArrayList();
    static int updateID;

    public ListAdapter(Context context, int resource)
    {
        super(context, resource);
    }

    public static  class LayoutHandler
    {
           TextView lItem;
        TextView lDate;
        ImageView options;
        ImageView isLocked;


    }

    @Override
    public void add(Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
       View row=convertView;
        final LayoutHandler layoutHandler;

       final  Score_list score_list = new Score_list();



        //String query;


        if(row == null)
        {

            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.single_row, parent, false);
            layoutHandler=new LayoutHandler();
            layoutHandler.lItem=(TextView) row.findViewById(R.id.lItem);
            layoutHandler.lDate=(TextView) row.findViewById(R.id.lDate);
            layoutHandler.options = (ImageView)row.findViewById(R.id.options);
            layoutHandler.isLocked = (ImageView)row.findViewById(R.id.isLocked) ;

           layoutHandler.options.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub

                  /*  DBHandler dbHandler = new DBHandler(getContext());
                    SQLiteDatabase sqLiteDatabase =dbHandler.getReadableDatabase();


                   String query = "DELETE FROM "+ UserContract.NewUserInfo.TABLE_NAME +" WHERE id = '" + (position+1)+"'";

                   sqLiteDatabase.execSQL(query);
                 //   sqLiteDatabase.close();
                    Toast.makeText(getContext(),"Please restart to see changes", Toast.LENGTH_LONG).show();


                    score_list.listAdapter.notifyDataSetChanged();

                    */



                }
            });

            updateID = position;

            DBHandler dbHandler = new DBHandler(getContext());
            SQLiteDatabase sqLiteDatabase = dbHandler.getReadableDatabase();


            //collaborate column id with row position


          //  String queryID = "UPDATE "+UserContract.NewUserInfo.TABLE_NAME+ " SET "+UserContract.NewUserInfo.COLUMN_ID+" = "+row.getPo;
           // sqLiteDatabase.execSQL(queryID);



           // put lock on encrypted files


            String _check="";
            String query = "SELECT " + UserContract.NewUserInfo.COLUMN_KEY + " FROM " + UserContract.NewUserInfo.TABLE_NAME + " WHERE id = '" + (position) + "'";
            Cursor cursorKey;
            cursorKey = sqLiteDatabase.rawQuery(query, null);
            if( cursorKey.moveToFirst()) {
                do {
                    _check = cursorKey.getString(cursorKey.getColumnIndex("key"));
                }while(cursorKey.moveToNext());

            }





            // check if has key
            if(_check != null)
            {

                layoutHandler.isLocked.setImageResource(R.drawable.lock);

            }
            else
            {

                layoutHandler.isLocked.setImageResource(0);

            }









//  layoutHandler.rate_view=(RatingBar)row.findViewById(R.id.ratingBar2);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler=(LayoutHandler) row.getTag();


        }
        ListItem listItem =(ListItem) this.getItem(position);
        layoutHandler.lItem.setText((listItem.get_filename()));
        layoutHandler.lDate.setText(listItem.get_date());



        return row;
    }
}