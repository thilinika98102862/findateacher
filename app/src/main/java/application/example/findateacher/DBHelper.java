package application.example.findateacher;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "UserInfo1.db";
    public static final String TABLE_NAME = "teachers";
    public static final String COLUMN_ID = "id";
   // public static final String COLUMN_NAME = "teachername"
    public static final String COLUMN_NAME = "teachername";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


            sqLiteDatabase.execSQL(
                    "create table teachers " +
                            "(id integer primary key, teachername TEXT unique)" //
            );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addInfo1(String teachername) {


        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,teachername);
        //


        long newRowId = sqLiteDatabase.insert(TABLE_NAME, null, values);
        return newRowId;

    }
}
