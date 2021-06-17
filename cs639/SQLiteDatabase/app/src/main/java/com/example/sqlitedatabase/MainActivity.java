package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername;
    StudentDatabaseHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_name);
        dbHelper = new StudentDatabaseHelper(this);
        db = dbHelper.getWritableDatabase();
    }

    public void onInsert(View view) {
        ContentValues value = new ContentValues();
        String name = etUsername.getText().toString();
        if (name.isEmpty()) {
            Log.i("ON_INSERT_BTN", "INPUT IS EMPTY");
            Toast toast = Toast.makeText(this, R.string.toast_error, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            value.put("name", name);
            Log.i("ON_INSERT_BTN", "INSERTING " + name);
            long newItem = db.insert("student", null, value);
            Toast toast = Toast.makeText(this, R.string.toast_insert, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onDelete(View view) {
        String name = etUsername.getText().toString();
        if (name.isEmpty()) {
            Log.i("ON_DELETE_BTN", "INPUT IS EMPTY");
            Toast toast = Toast.makeText(this, R.string.toast_error, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Log.i("ON_DELETE_BTN", "DELETING " + name);
            db.delete("student", "name=?", new String[]{name});
            Toast toast = Toast.makeText(this, R.string.toast_delete, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}