package com.turaapp.listofcases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.turaapp.listofcases.Adapters.TaskAdapter;
import com.turaapp.listofcases.Models.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DbHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TaskAdapter adapter = new TaskAdapter(this,new ArrayList<Task>());
        ListView l = findViewById(R.id.list_view);
        final EditText edittext = findViewById(R.id.edittext);
        Button deleteButton = findViewById(R.id.delete);
        l.setAdapter(adapter);
        Button nextbutton = findViewById(R.id.nextbutton);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = new Task(edittext.getText().toString(),false);
                adapter.addTask(task);
                SQLiteDatabase db = dbhelper.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("text",task.title);
                cv.put("check",0);
                long id = db.insert("Tasks",null,cv);
                Log.d("qweqweqwe", String.valueOf(id));
            }
        });
        dbhelper = new DbHelper(this);
    }
}
