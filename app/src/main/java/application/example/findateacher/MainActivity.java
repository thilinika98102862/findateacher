package application.example.findateacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ename;
    Button btn2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ename = findViewById(R.id.ename);
        btn2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this,xxx.class);
                //startActivity(intent);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String p = ename.getText().toString();
                SQLiteDatabase sqLiteDatabase = getApplicationContext().openOrCreateDatabase("UserInfo1.db", Context.MODE_PRIVATE,null);

                Cursor c = sqLiteDatabase.rawQuery("select * from teachers where teachername='"+p+"'", null);

                if (c.getCount() == 0){

                    Toast.makeText(getApplicationContext(),"Data not searched", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("id :"+ c.getString(0)+"\n");
                    buffer.append("Teacher Name :"+ c.getString(1)+"\n\n");

                    //teacher description here



                }


                Toast.makeText(getApplicationContext(),"Results : \n "+buffer.toString(),Toast.LENGTH_SHORT).show();





            }
        });

    }

    public void addData1(View view){

        DBHelper dbHandler = new DBHelper(this);
        long val = dbHandler.addInfo1(ename.getText().toString());

        if (val>0)

            Toast.makeText(this,"Teacher Added Successfully", Toast.LENGTH_SHORT).show();
        }
}