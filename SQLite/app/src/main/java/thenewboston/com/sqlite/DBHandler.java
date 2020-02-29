package thenewboston.com.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 28-01-2017.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =25 ;
    private static final String DATABASE_NAME = "items.db";

    ListItem ob;


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS " + UserContract.NewUserInfo.TABLE_NAME);
        onCreate(db);
      // if (newVersion > oldVersion) {
        //    db.execSQL("ALTER TABLE "+ UserContract.NewUserInfo.TABLE_NAME+ " ADD COLUMN " +UserContract.NewUserInfo.COLUMN_STARS + " INTEGER; ");
        //}



    }

    public Cursor getInformation(SQLiteDatabase sqLiteDatabase)
    {
        Cursor cursor;
        String[] projections={UserContract.NewUserInfo.COLUMN_CONTENT, UserContract.NewUserInfo.COLUMN_DATE, UserContract.NewUserInfo.COLUMN_NAME, UserContract.NewUserInfo.COLUMN_KEY, UserContract.NewUserInfo.COLUMN_ID };
        cursor=sqLiteDatabase.query(UserContract.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
    return cursor;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //onUpgrade(db,8,12);

        String query = "CREATE TABLE " +
                UserContract.NewUserInfo.TABLE_NAME + "(" +
                UserContract.NewUserInfo.COLUMN_ID +" INTEGER, " +
                UserContract.NewUserInfo.COLUMN_NAME + " TEXT, " +
                UserContract.NewUserInfo.COLUMN_KEY + " TEXT, " +
                UserContract.NewUserInfo.COLUMN_ENCRYTED + " BOOL DEFAULT FALSE, " +
                UserContract.NewUserInfo.COLUMN_CONTENT + " TEXT, " +
                UserContract.NewUserInfo.COLUMN_DATE+ " TEXT "+ ");";
        db.execSQL(query);



    }

    public void addObject(ListItem listItem) {
        ContentValues values = new ContentValues();

        values.put(UserContract.NewUserInfo.COLUMN_NAME, listItem.get_filename());
        values.put(UserContract.NewUserInfo.COLUMN_DATE, listItem.get_date());
       values.put(UserContract.NewUserInfo.COLUMN_CONTENT, listItem.get_filecontents());
        values.put(UserContract.NewUserInfo.COLUMN_ID, listItem.get_id());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(UserContract.NewUserInfo.TABLE_NAME, null, values);
        db.close();
    }






    public String showName() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = " SELECT * FROM " + UserContract.NewUserInfo.TABLE_NAME;

        //POINT CURSOR

        Cursor cursor = db.rawQuery(query, null);
        db.close();
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            if (cursor.getString(cursor.getColumnIndex("filename")) != null) {
                dbString += cursor.getString((cursor.getColumnIndex("filename")));
                dbString += "\n";

                cursor.moveToNext();
            }
        }
        cursor.close();


        return dbString;
    }

    public String showDates()
    {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = " SELECT * FROM " + UserContract.NewUserInfo.TABLE_NAME;

        //POINT CURSOR

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            if (cursor.getString(cursor.getColumnIndex("date")) != null) {
                dbString += cursor.getString((cursor.getColumnIndex("date")));
                dbString += "\n";

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();


        return dbString;
    }

    public String showContents()
    {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = " SELECT * FROM " + UserContract.NewUserInfo.TABLE_NAME;

        //POINT CURSOR

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (c.moveToNext()) {
            if (c.getString(c.getColumnIndex("filecontent")) != null) {
                dbString += c.getString((c.getColumnIndex("filecontent")));
                dbString += "\n";

                c.moveToNext();

            }

            if(c.isAfterLast())break;
        }
        c.close();
        db.close();


        return dbString;
    }


}
